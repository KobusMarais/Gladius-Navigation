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
					if(routes.get(count).name == target)
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
		 *This method saves the prefered routes that the user deems useful. It saves the selected route to the preferences database.
		 *
		*/
		public void savePreference()
		{
				
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
