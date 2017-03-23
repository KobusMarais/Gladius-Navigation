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
	
		public String getName()
		{
				return name;	
		}
		
		public ArrayList<Location> calculateRoute(Location start, Location end)
		{
				Boolean locationObjectsAreValid = true;
		
				if(locationObjectsAreValid)
				{
						ArrayList<Location> wayPoints = new ArrayList<>();
						wayPoints.add(start);
						wayPoints.add(end);
				
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
}
