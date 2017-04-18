public class IndoorRouteCreation {
	//Mia
	public JSONString createDefaultRoute(float startx, float starty, float currx, float curry, float endx, float endy , JSONString route) {
		/* 	Okay so this is a recursive function, this will be called from our class interface.
				
			-->	it repeatedly calls itself until currentPoint is equal to finalDestination or less
				than 3 meters away from finalDestination (because then you should be able to physically see the location)
			
			--> At the VERY BEGINNING of this function we call arePointsOnTheSamePlane, if they are on the same level we continue normally as explained
				below, but if they aren't we will call addStaircase() and then "jump" the user to the correct level of the building and continue 
				from the currentPoint. (We can do this because x and y will be the same regardless of z axis BUT we will need to check isPointInvalid)

			-->	If currentPoint isn't the final case THEN distanceBetweenTwoPoints from the helperObject will be called on all coordinates 
				in a 3 meter radius from the currentPoint, the coordinate in that radius that returns the smallest value is added to the route
				and we call createDefaultRoute on that new coordinate.

			-->	However before that new point is added we call isPointInvalid on it, if it is invalid, we take the next coordinate within radius of 
				prevPoint that has the second smallest distance between it and finalDestination
		
		*/
	}
	//Mia
	public JSONString addStaircase(JSONString route) {
		/*
			Used to add a sentence or enumerator to the route string if the start and destination location are on different levels.
		*/
	}

	protected GISModule GISObject;
	//Kobus
	public float distanceBetweenTwoPoints(float ax, float ay, float bx, float by) {

		/*
			Simply returns the difference between two float values.
			return a - b;
		*/



	}
	//Kobus
	public boolean arePointsOnSamePlane(String start, String dest) {
		/*
			Checks if the start and end destination are on different levels of a building.
			
			The only implementation I could think of is that we will have an exhaustive switch statement for like 7 of the most 
			popular buildings (IT, Centenary etc.) then we will use string manipulation to check the actual names of the destination
			and if they are upstairs at all we just use common sense to either return true or false. This is will work because matter 
			what, indoor navigation will ALWAYS start from ground floor.



 		*/
	}
	//Kobus
	public boolean isPointInvalid(float x, float y) {

		
		/*
			Checks if a given point makes a user walk through a wall or room or something equally ridiculous.

			We will achieve this by checking if the coord is equal to an existing room that is NOT our start 
			or end location, otherwise we assume we are still on track.
		*/
	}
	//Kobus
	public boolean arePointsIndoors(float ax, float ay, float bx, float by) {
		/*
			Function to make sure that points ARE indoors and we're not doing outdoor navigation by accident.
		*/
	}
}
