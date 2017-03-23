package Navigation;

import java.util.ArrayList;

public interface NavigationInterface {
		/* Function adds an existing route into the database */
		public Boolean addRoute(Route roo);

		/*
				This function deletes a Route from the database
				using the Route' name as a key.
		*/
		public Boolean removeRoute(Route roo);
		/**
		 * This returns the route that the user has entered. It will return the calulated route for the user.
		 *
		 * @param routeName The name of the saved route in the database
		 * @return 			The specified route
		 *
		 */
		public Route getRoute(String routeName);
					
		public Route search(String target);
	
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
		public ArrayList<Route> getRoutes(Location from, Location to);
	
		/*
				This function returns a Route based on a given user preference
		*/
		public Route getPreferedRoute(Location from, Location to);

		/**
		 *This method saves the prefered routes that the user deems useful. It saves the selected route to the preferences database.
		 *
		*/
		public boolean savePreference();

		/**
		 * This method calculates and returns the simplest routes for people with disabilities
		 *
		 * @param currRoute The route that has to be modified
		 * @return			The modified route
		 */
		public Route modifyRoute(Route currRoute);
}