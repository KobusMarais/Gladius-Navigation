package Navigation;
import java.util.*;

public class Routes
{
		/*
		 *	Routes class has atleast one Route.
		 *	This ArrayList of Route Objects holds
		 *	Route's contained in the database.
		*/
		
		private ArrayList<Route> routes;
	
		public Routes()
		{
				routes = new ArrayList<>();
		}
	
		/*
				This function inserts a Route into the database
				and furthermore maintains a List of inserted Routes.
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

		/*
				This function deletes a Route from the database
				using the Route' name as a key.
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
				return search(routeName);
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
	
		/*
				This function returns a collection of Routes with a starting
				Location "from" and end Location "to"
		
				Note: Using the start and end Locations as a key may return
				multiple Routes because Routes can have the same start and end Locations
				but the wayPoints of each Route may be unique. This behaviour could
				or could not be desireable (ie: we could provide the user with multiple
				Routes to the same destination and the users preference(s) will serve
				as a decider as to which Route he/she wants to take)
		*/
		public ArrayList<Route> getRoutes(ArrayList<Location> loc)
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
								ArrayList<Route> possibleRoutes = new ArrayList<>();
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
	
		/*
				This function returns a Route based on a given user preference
		*/
		public Route getPreferedRoute(ArrayList<Location> loc)
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
								return new Route();//Mock
						}
						else
						{
								//return relavent Route from possibleRoutes
								System.out.println("Returning Shortest-Route.");
								return new Route();//Mock
						}
				}
			
				return null;
		}

		/**
		 *This method saves the prefered routes that the user deems useful. It saves the selected route to the preferences database.
		 *
		*/
		public Boolean savePreference()
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
