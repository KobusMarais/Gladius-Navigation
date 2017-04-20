package gladios.navigation;
import gladios.gis.GIS;
import gladios.gis.GISInterface;

import javax.management.relation.RoleInfo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;

public class Routes
{
	
	//This HashMap of Route Objects holds Route's contained in the database.
	//Advantage: Safe and fast direct-access, no search required.
	//Key = RouteName, Value = Route Object.
	private HashMap<String,Route> routes;


	//Modify to specification of final DB/server information...
	final private String url = "jdbc:mysql://localhost/Navigation";
	final private String user = "root";
	final private String driver = "com.mysql.jdbc.Driver";//Do not change
	final private String pass = "*********";
	
	public Routes()
		{
				routes = new HashMap<String, Route>();
		}

	/**
	 * This method inserts a Route into the database
	 * and furthermore maintains a List of inserted Routes.
	 *
	 * @param roo Route to be inserted into the DB.
	 * @return true if the Route was successfully added, else false.
	 */
	public Route addRoute(Route roo)
	{
		if(roo != null)
		{
			routes.put(roo.getName(), roo);

			Connection connect = null;
			Statement statement = null;
			GISInterface gis = GIS.getInstance();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection(url, user, pass);
				connect.setAutoCommit(false);

				if(connect != null)
				{
					System.out.println("Connection to DB Successful!");
				}
				else
				{
					System.out.println("CONNECTION TO DB FAILED!");
					//return false;
				}

				String start = roo.getLocations().getStartLocation().getName();
				String locIDStart = roo.getLocations().getStartLocation().getLocationID();

				String end = roo.getLocations().getEndLocation().getName();
				String locIDEnd = roo.getLocations().getEndLocation().getLocationID();

				float[] startCoords = roo.getLocations().getStartLocation().getCoordinates().getLongLatCoords();
				float[] endCoords = roo.getLocations().getEndLocation().getCoordinates().getLongLatCoords();

				statement = connect.createStatement();

				String query = "INSERT INTO Routes(RouteName,StartLocationName,EndLocationName)" + "VALUES('"+roo.getName()+"','"+start+"','"+end+"');";
				statement.executeUpdate(query);

				query = "INSERT INTO Location(LocationName, LocationID, Longitude, Latitude)" + "VALUES('"+start+"','"+locIDStart+"','"+startCoords[0]+"','"+startCoords[1]+"');";
				statement.executeUpdate(query);
				query = "INSERT INTO Location(LocationName, LocationID, Longitude, Latitude)" + "VALUES('"+end+"','"+locIDEnd+"','"+endCoords[0]+"','"+endCoords[1]+"');";
				statement.executeUpdate(query);

				String[] str = gis.locationsWithinRadius(startCoords[0], startCoords[1], getDistance(startCoords, endCoords));
				Location[] environment = new Location[str.length];

				Random rand = new Random();
				for(int i = 0; i < str.length;i++)
				{
					GPSObject obj = new GPSObject(str[i]);
					environment[i] = new Location(str[i],rand.nextInt() + "",obj);

				}

				LinkedList<Location> wayPoints = computePath(environment);

				int pass = 0;

				//Fully initialize (addition of its way-points) the Route in the local structure (HashMap) -- Needs testing...
				while(pass < wayPoints.size())
				{
					routes.get(roo.getName()).getLocations().listOfLocations.add(wayPoints.get(pass));
					pass++;
				}

				int track = 0;	Location curr;

				//Add way-points to collection of Location's in DB (avoiding duplicate Location's) -- Needs testing...
				while(track < wayPoints.size())
				{
					curr = wayPoints.get(track);
					query = "INSERT INTO Location(LocationName, LocationID, Longitude, Latitude)" + "VALUES('"+curr.getName()+"','"+curr.getLocationID()+"','"+curr.getCoordinates().getLongitude()+"','"+curr.getCoordinates().getLatitude()+"');";
					statement.executeUpdate(query);

					track++;
				}

				query = "INSERT INTO RouteWayPoints(RouteName, StartLoc, EndLoc)" + "VALUES('"+roo.getName()+"','"+start+"','"+end+"');";

				int count = 0;

				//Update Route with the now computed wayPoints -- Needs testing...
				while(count < wayPoints.size())
				{
					query = "UPDATE RouteWayPoints set WayPoint"+(count + 1)+" = '"+wayPoints.get(count).getName()+"' WHERE RouteName = '"+start+"';";
					statement.executeUpdate(query);

					count++;
				}

				statement.close();
				connect.commit();
				connect.close();
			}
			catch (Exception exp)
			{
				System.err.println(exp.getClass().getName() + ": " + exp.getMessage());
				System.exit(0);
			}

			return routes.get(roo.getName());
		}

		return null;
	}

	private LinkedList<Location> computePath(Location[] enviro)
	{
		LinkedList<Location> path = new LinkedList<Location>();

		//Actual Route building happens in here.. GIS didnt pull through with locationsWithinRadius() method.

		return path;
	}

	/**
	 * Computes the direct (point-to-point) distance between a start and end Location, independent of the waypoints.
	 *
	 * @param startCoords Longitude and latitude of the starting point (X and Y coordinates).
	 * @param endCoords	Longitude and latitude of the ending point (X and Y coordinates).
	 * @return	The point-to-point distance between a start and end Location.
	 */
	private float getDistance(float[] startCoords, float[] endCoords)
	{
		return (float) (Math.sqrt(Math.pow((startCoords[0]-endCoords[0]), 2) + Math.pow((startCoords[1]-endCoords[1]), 2)));
	}

	/**
	 * This method removes a given Route from the database of Routes
	 * and updates the list of maintained Routes accordingly.
	 *
	 * @param roo the Route to be removed from both the DB and list of Routes.
	 * @return true given the Route exists in the DB and is successfully removed. Else false.
	 */
	public Boolean removeRoute(Route roo)
	{
		if(roo != null) {
			//routes.put(roo.getName(), roo);
			routes.remove(roo.getName());

			Connection connect = null;
			Statement statement = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection(url, user, pass);
				connect.setAutoCommit(false);

				if (connect != null) {
					System.out.println("Connection to DB Successful!");
				} else {
					System.out.println("CONNECTION TO DB FAILED!");
					//return false;
				}

			//	String start = roo.getLocations().getStartLocation().getName();
			//	String locIDStart = roo.getLocations().getStartLocation().getLocationID();

			//	String end = roo.getLocations().getEndLocation().getName();
			//	String locIDEnd = roo.getLocations().getEndLocation().getLocationID();

			//	float[] startCoords = roo.getLocations().getStartLocation().getCoordinates().getLongLatCoords();
			//	float[] endCoords = roo.getLocations().getEndLocation().getCoordinates().getLongLatCoords();

				statement = connect.createStatement();
				String query = "DELETE FROM Routes WHERE RouteName = '"+roo.getName()+"';";
				statement.executeUpdate(query);

				statement.close();
				connect.commit();
				connect.close();
			} catch (Exception exp) {
				System.err.println(exp.getClass().getName() + ": " + exp.getMessage());
				System.exit(0);
			}
		}
		return false;
	}


	/**
	 * This returns the route that the user has entered. It will return the calulated route for the user.
	 *
	 * @param routeName The name of the saved route in the database
	 * @return 			The specified route
	 *
	 */
	public Route getRoute(String routeName)
	{
		//Beauty of the HashMap, Direct-Access
		Route la = routes.get(routeName);

		if(la == null)
		{
			//If Route is not contained, add the Route to the DB & HashMap.
			la = this.addRoute(new Route(routeName));
		}

		return la;
	}


	/**
	 * 	This function returns a List of Routes with the same starting and ending Locations.
	 *	Using the start and end Locations as a key when querying the DB may return
	 *	multiple Routes because Routes can have the same start and end Locations
	 *	but the wayPoints of each Route may be unique. This behaviour could
	 *	or could not be desireable (ie: we could provide the user with multiple
	 *	Routes to the same destination and the users preference(s) will serve
	 *	as a decider as to which Route he/she wants to take)
	 *
	 * @param loc Locations object encapsulating the start and end Locations.
	 * @return an ArrayList of Route's with the specified start and end Locations.
	 */
	public ArrayList<Route> getRoutes(Locations loc)
	{
		/*if(loc != null)
		{
			ArrayList<Route> list = new ArrayList<>();


		}*/

		return null;
	}

	/**
	 * This function returns a Route based on a GIVEN user preference.
	 *
	 * @param loc Locations object encapsulating the start and end Locations.
	 * @return a Locations object encapsulating the possible Route's that can be taken to reach the destination.
	 */
	public Locations getPreferedRoute(Locations loc)
	{
		/*String preferenceA = "simplestRoute";
		String preferenceB = "shortestRoute";
			
		Boolean locationObjectsAreValid = true;
			
		if(locationObjectsAreValid) {
			//Get all possible Routes that can be taken to reach destination
			ArrayList<Route> possibleRoutes = getRoutes(loc);
			if (possibleRoutes == null) {
				//No routes, calculate
				//Entry point to pathfinding

			} else {
				//Get preferences from DB
				String retrievedPref = "simplestRoute";//Mock

				//Based on preference, return the relavent Route
				if (retrievedPref == preferenceA) {
					//return relavent Route from possibleRoutes
					System.out.println("Returning Simplest-Route.");
					return loc;
				} else {
					//return relavent Route from possibleRoutes
					System.out.println("Returning Shortest-Route.");
					return loc;
				}
			}
		}*/
			
		return null;
	}

		/**
		 *This method saves the prefered routes that the user deems useful. It saves the selected route to the preferences database.
		 *
		*/
		public Boolean savePreference(String pref)
		{
			return true;
		}

		/**
		 * This method calculates and returns the simplest routes for people with disabilities
		 *
		 * @param currRoute The route that has to be modified
		 * @return			The modified route
		 */
		public Route modifyRoute(Route currRoute)
		{
			return null;
		}
}
