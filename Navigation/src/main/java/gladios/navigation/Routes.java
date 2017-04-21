package gladios.navigation;
import javax.management.relation.RoleInfo;
import java.util.*;

public class Routes
{
	/**
	 *	This ArrayList of Route Objects holds
	 *	Route's contained in the database.
	 */
	private ArrayList<Route> routes;
	
	public Routes()
		{
				routes = new ArrayList<Route>();
		}

	/**
	 * This method inserts a Route into the database
	 * and furthermore maintains a List of inserted Routes.
	 *
	 * @param roo Route to be inserted into the DB.
	 * @return true if the Route was successfully added, else false.
	 */
	public Boolean addRoute(Route roo)
	{
		routes.add(roo);
				
		//Formulate sql query that maps Route Object to DB
		String query = "INSERT INTO Routes .....VALUES(...)";
				
		//Connect to the DB
		Boolean connectionMadeSuccessfully = true;
				
		//If connection is made
		if(connectionMadeSuccessfully)
		{
			//Execute the sql query
			System.out.println("Querying the DB ...");
			System.out.println("Route added successfully!\n");
			return true;
		}
		else//Failed to connect to DB
		{
			System.out.println("Connection to Database failed!\n");
			return false;
		}
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
		Boolean routeContainedInDB = true;
			
		if(routeContainedInDB)
		{
			//Remove Route from ArrayList
			routes.remove(roo);
				
			//Formulate sql query to delete the specified Route from the DB
			//using the Route' name attribute as a Primary-Key
			String query = "DELETE FROM Routes ..... WHERE name = roo.name";
				
			//Connect to the DB
			Boolean connectionMadeSuccessfully = true;
				
			//If connection is made
			if(connectionMadeSuccessfully)
			{
				//Execute the sql query
				System.out.println("Querying the DB ...");
				System.out.println("Route removed successfully!\n");
				return true;
			}
			else//Failed to connect to DB
			{
				System.out.println("Connection to Database failed!");
				return false;
			}
		}
		else
		{
			System.out.println("Route is not contained in the DB.\n");
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
		if(search(routeName) == null)
		{
			//If Route is not contained, add the Route to the DB.
			routes.add(new Route(routeName));
		}
		else
		{
			return search(routeName);
		}
		return null;
	}
					
	public Route search(String target)
	{
		int count = 0;
					
		while(count < routes.size())
		{
			if(routes.get(count).getName() == target)
			{
				System.out.println("Route found!\n");
				return routes.get(count);
			}
					
			count++;
		}
				
		System.out.println("Route not contained in DB\n");
		return null;
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
		Boolean locationObjectsAreValid = true;
			
		if(locationObjectsAreValid)
		{
			//Formulate sql query to extract Routes from the DB with the specified start and end Location.
			String query = "SELECT FROM Routes ..... WHERE ..";
					
			//Connect to the DB
			Boolean connectionMadeSuccessfully = true;
				
			//If connection is made
			if(connectionMadeSuccessfully)
			{
				//Execute the sql query
				System.out.println("Querying the DB ...");
				System.out.println("Retrieving Routes!\n");
							
				//Add returned Routes to a List of Routes
				ArrayList<Route> possibleRoutes = new ArrayList<Route>();
				Boolean addingRoutes = true;
								
				while(addingRoutes)
				{
					possibleRoutes.add(new Route(/*Initialize with data extracted from DB*/));
					addingRoutes = false;
				}
							
				return possibleRoutes;
			}
			else//Failed to connect to DB
			{
				System.out.println("Connection to Database failed!");
				return null;
			}
		}
		else
		{
			System.out.println("Locations are invalid.\n");
		}
			
		return null;
	}


	/**
	 * This function returns a Route based on a given user preference.
	 *
	 * @param loc Locations object encapsulating the start and end Locations.
	 * @return a Locations object encapsulating the possible Route's that can be taken to reach the destination.
	 */
	public Locations getPreferedRoute(Locations loc)
	{
		String preferenceA = "simplestRoute";
		String preferenceB = "shortestRoute";
			
		Boolean locationObjectsAreValid = true;
			
		if(locationObjectsAreValid)
		{
			//Get all possible Routes that can be taken to reach destination
			ArrayList<Route> possibleRoutes = getRoutes(loc);
					
			//Get preferences from DB
			String retrievedPref = "simplestRoute";//Mock
					
			//Based on preference, return the relavent Route
			if(retrievedPref == preferenceA)
			{
				//return relavent Route from possibleRoutes
				System.out.println("Returning Simplest-Route.");
				return loc;
			}
			else
			{
				//return relavent Route from possibleRoutes
				System.out.println("Returning Shortest-Route.");
				return loc;
			}
		}
			
		return null;
	}

		/**
		 *This method saves the prefered routes that the user deems useful. It saves the selected route to the preferences database.
		 *
		*/
		public Boolean savePreference(String pref)
		{
			boolean connectionWasMade = true;

			if(connectionWasMade){
				System.out.println("Preferences are saved");
				return true;

			}else{
				System.out.println("Preferences were not saved");
				return true;

			}
				
		}

		/**
		 * This method calculates and returns the simplest routes for people with disabilities
		 *
		 * @param currRoute The route that has to be modified
		 * @return			The modified route
		 */
		public Route modifyRoute(Route currRoute)
		{
			return new Route("Modified",currRoute);
		}
}
