package com.gladius.navup.navigation;
import java.util.*;

public class Route
{
		private String name;
		private Locations path;
	
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
				path = new Locations();
		}
		
		public Route(String rN, Locations clone)
		{
				name = rN;
				path = new Locations();
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
		
		public Locations calculateRoute(Locations routeArray)
		{
				Boolean locationObjectsAreValid = true;
		
				if(locationObjectsAreValid)
				{
					Locations wayPoints = new Locations();
						//ArrayList<Location> wayPoints = new ArrayList<Location>();
						int i = 0;
						while(i < routeArray.size())
						{
							wayPoints.addLocation(routeArray.get(i));
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

		public Locations getLocations()
		{
			return this.path;
		}
}
