




/**

	What is this file:
	This file is not meant to be run or compiled at all, it is a basic outline of what functions
	will look like and how they will behave according to the structure of the final class.

	Issues to be addressed:

	--> We need to check the format of the String name of start and end locations ASAP
	--> We need to decide on a String format for staircases 
*/

public class IndoorPathfinding  {

	protected GISModule GISObject; //we will receive all GIS information from this singular GIS object

	/** The following four functions are helper functions to the pathfinding algorithm 
		->	distanceBetweenTwoPoints
		-> 	arePointsOnSamePlane
		->	heightDifference
		->	isPointInvalid
	*/

	public float distanceBetweenTwoPoints(float ax, float ay, float bx, float by) {
		/*
			Simply returns the difference between two float values.
			return a - b;
		*/

	}

	public boolean arePointsOnSamePlane(String start, String dest) {
		/*
			Checks if the start and end destination are on different levels of a building.
			
			The only implementation I could think of is that we will have an exhaustive switch statement for like 7 of the most 
			popular buildings (IT, Centenary etc.) then we will use string manipulation to check the actual names of the destination
			and if they are upstairs at all we just use common sense to either return true or false. This is will work because matter 
			what, indoor navigation will ALWAYS start from ground floor.

			If points are on a different level, we will call heightDifference() to determine how many levels difference there is

 		*/
	}

	public int heightDifference(String start, String dest) {
		/* Determines the amount of floors the user should go up between the start and destination locations */
	}

	public boolean isPointInvalid(float coordx, float coordy) {
		/*
			Checks if a given point makes a user walk through a wall or room or something equally ridiculous.

			We will achieve this by checking if the coord is equal to an existing room that is NOT our start 
			or end location, otherwise we assume we are still on track.
		*/
	}

	public boolean arePointsIndoors(float ax, float ay, float bx, float by) {
		/*
			Function to make sure that points ARE indoors and we're not doing outdoor navigation by accident.
		*/
	}

	/* NB NB NB NB NB NB*/

	/* createDefaultRoute must be 
		called for an indoor route 
		to be createdthus, this will 
		be used in the interface for 
		access by other classes*/

	/* NB NB NB NB NB NB*/

	public JSONString createDefaultRoute(float prevx, float prevy, float currx, float curry, float destx, float desty, JSONString route) {
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

	public JSONString addStaircase(JSONString route) {
		/*
			Used to add a sentence or enumerator to the route string if the start and destination location are on different levels.
			This will eventually lead to the user being told that they need to find the nearest staircase and go up as many levels 
			as necessary.

			Function will be called if arePointsOnTheSamePlane returns false
		*/
	}
}
