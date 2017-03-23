package Navigation;
import java.util.*;

public class Route
{
		private String name;
		private ArrayList <Location> path;
	
		public Route()
		{
				name = "";
				path = null;
		}
	
		public Route(String V, Route M)
		{
			
		}
	
		public Route(String rN)
		{
				name = rN;
				path = new ArrayList<>();
		}
		
		public Route(String rN, ArrayList <Location> clone)
		{
				name = rN;
				path = new ArrayList<>();
				path = clone;
		}

		public Route(Route rt)
		{
			this.name = rt.name;
			this.path = rt.path;
		}
	
		public String getName()
		{
				return name;	
		}
		
		public ArrayList<Location> calculateRoute(ArrayList<Location> routeArray)
		{
				Boolean locationObjectsAreValid = true;
		
				if(locationObjectsAreValid)
				{
						ArrayList<Location> wayPoints = new ArrayList<>();
						int i = 0;
						while(i < routeArray.size())
						{
							wayPoints.add(routeArray.get(i));
						}
				
						System.out.println("Calculating route...");
						System.out.println("Route calculation successful!\n");
						return wayPoints;
				}
				else
				{
						System.out.println("Location Objects are invalid.\n");
				}
				
				return null;
		}

		public ArrayList<Location> getLocations()
		{
			return this.path;
		}
}
