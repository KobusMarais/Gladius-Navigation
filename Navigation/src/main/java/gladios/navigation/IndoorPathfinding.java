




/**

	What is this file:
	This file is not meant to be run or compiled at all, it is a basic outline of what functions
	will look like and how they will behave according to the structure of the final class.

	Issues to be addressed:

	--> We need to check the format of the String name of start and end locations ASAP
	--> We need to decide on a String format for staircases 
	--> We need to use the same JSON plugin to create and parse JSON in Java
	
	NB ANY 0,0 COORDINATES WITHIN A ROUTE MEANS STAIRS NEED TO BE TAKEN
*/
import com.gladius.GIS;
import java.lang.Math;
import java.util.ArrayList;

public class IndoorPathfinding  {

	protected GISInterface GISObject; //we will receive all GIS information from this singular GIS object

	public IndoorPathfinding() {
		GISObject = new GISInterface();
	}
	/** The following four functions are helper functions to the pathfinding algorithm 
		->	distanceBetweenTwoPoints
		-> 	arePointsOnSamePlane
		->	heightDifference
		->	isPointInvalid
	*/

	public float distanceBetweenTwoPoints(float ax, float ay, float bx, float by) {
		
		return (float)Math.sqrt(Math.pow((double)(bx-ax),2) + Math.pow((double)(by-ay),2));
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

	public ArrayList<ArrayList<Float>> createDefaultRoute(float prevx, float prevy, float currx, float curry, float destx, float desty, ArrayList<ArrayList<Float>> route) {
		if(distanceBetweenTwoPoints(currx,curry,destx,desty) <= 4) {
			ArrayList<Float> temp = new ArrayList<Float>(0);
			temp.add(destx);
			temp.add(desty);
			route.add(temp);
			return route;
		} else {
			
			if(route.size() == 0) {
				if(arePointsOnSamePlane(GISObject.getLocation(currx,curry),GISObject.getLocation(destx,desty)) == false) {
					route = addStaircase(route);
				}
				ArrayList<Float> beginning = new ArrayList<Float>(0);
				beginning.add(currx);
				beginning.add(curry);
				route.add(beginning);
			}

			float [] xPoints = {currx-4,currx-(float)3.5,currx-3,currx-(float)2.5,currx-2,currx-(float)1.5,currx-1,currx-(float)0.5,currx,currx+(float)0.5,currx+1,currx+(float)1.5,currx+2,currx+(float)2.5,currx+3,currx+(float)3.5,currx+4};
			float [] positiveYPoints = {curry,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,curry};
			float [] negativeYPoints = {curry,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,curry};
			int i;

			for(i = 1; i < 16; i++) {
				positiveYPoints[i] = (float)Math.sqrt(Math.pow(4,2) - Math.pow((double)xPoints[i],2));
				negativeYPoints[i] = -1 * ( (float)Math.sqrt(Math.pow(4,2) - Math.pow((double)xPoints[i],2)) );
			}

			float smallestDistance = Integer.MAX_VALUE;
			float smallestx = Integer.MAX_VALUE;
			float smallesty = Integer.MAX_VALUE; 

			for(i = 0; i < 17; i++) {
				if(distanceBetweenTwoPoints(xPoints[i],positiveYPoints[i],destx,desty) < smallestDistance) {
					if(isPointInvalid(xPoints[i],positiveYPoints[i]) == false) {
						smallestDistance = distanceBetweenTwoPoints(xPoints[i],positiveYPoints[i],destx,desty);
						smallestx = xPoints[i];
						smallesty = positiveYPoints[i];
					}
				}
				if(distanceBetweenTwoPoints(xPoints[i],negativeYPoints[i],destx,desty) < smallestDistance) {
					if(isPointInvalid(xPoints[i],negativeYPoints[i]) == false) {
						smallestDistance = distanceBetweenTwoPoints(xPoints[i],negativeYPoints[i],destx,desty);
						smallestx = xPoints[i];
						smallesty = negativeYPoints[i];
					}
				}
			}

			ArrayList<Float> temp = new ArrayList<Float>(0);
			temp.add(smallestx);
			temp.add(smallesty);
			route.add(temp);

			return createDefaultRoute(currx,curry,smallestx,smallesty,destx,desty,route);

		}
	}

	public ArrayList<Float> addStaircase() {
		/*
			Used to add a sentence or enumerator to the route string if the start and destination location are on different levels.
			This will eventually lead to the user being told that they need to find the nearest staircase and go up as many levels 
			as necessary.

			Function will be called if arePointsOnTheSamePlane returns false
			
			will add 0,0 coordinates
		*/
		ArrayList<Float> temp = new ArrayList<Float>(0);
		temp.add((float)0.0);
		temp.add((float)0.0);
		return temp;
	}
}
