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
						return routes.get(count);
					}
					
					count++;
				}
					
				return null;
		}
		
		public void savePreference()
		{
				
		}
	
		public void modifyRoute()
		{
		
		}
}
