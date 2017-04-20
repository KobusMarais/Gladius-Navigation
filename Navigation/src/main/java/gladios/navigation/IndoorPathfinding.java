




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
		return (heightDifference(start, dest) == 0);
		/*
			Checks if the start and end destination are on different levels of a building.
		*/
	}

	public int heightDifference(String start, String dest) {
		/* Determines the amount of floors the user should go up between the start and destination locations */
		int numstart = 0;
		int numdest = 0;
		while(numstart < start.length()) //gets floors of locations regardless if they are the same building or not(could be useful for IT4-4 to EMS  building)
		{
			if(Character.isDigit(start.charAt(numstart))) //gets floor of first location
			{
				if(Character.isDigit(dest.charAt(numdest))) //gets floor of second location
				{
					if(start.charAt(numstart) - dest.charAt(numdest) == 0)
					{
						return 0;
					}
					else if(start.charAt(numstart) - dest.charAt(numdest) > 0)
					{
						return start.charAt(numstart) - dest.charAt(numdest);
					}
					else if(start.charAt(numstart) - dest.charAt(numdest) > 0)
					{
						return dest.charAt(numdest) - start.charAt(numstart);
					}
				}
				else
				{
					numdest++;
				}
			}
			else
			{
				numstart++;
			}
		}
		return 0;
	}

	public boolean isPointInvalid(float currx, float curry,float startx, float starty,float destx, float desty) 
	{
		/*
			Checks if a given point makes a user walk through a wall or room or something equally ridiculous.

			We will achieve this by checking if the coord is equal to an existing room that is NOT our start 
			or end location, otherwise we assume we are still on track.
		*/
		String name = GISObject.getLocation(currx, curry);
		if((name == GISObject.getLocation(startx, starty)) || (GISObject.getLocation(currx, curry) == GISObject.getLocation(destx, desty))) //checks if its the start or end location rooms
		{
			return false;
		}
		else
		{
			int count = 0;
			for(int i = 0; i < name.length(); i++)
			{
				if(Character.isDigit(name.charAt(i)))
				{
					count++;
				}
			}
			if(count > 1) //2 or more digits means its a specific room for example IT4-4
			{
				return true;
			}
			else// 1 or less digits means its just the bulding and possibly the level for example IT4
			{
				return false;
			}
		}
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
					route.add(addStaircase());
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
					if(isPointInvalid(xPoints[i],positiveYPoints[i],prevx,prevy,destx,desty) == false) {
						smallestDistance = distanceBetweenTwoPoints(xPoints[i],positiveYPoints[i],destx,desty);
						smallestx = xPoints[i];
						smallesty = positiveYPoints[i];
					}
				}
				if(distanceBetweenTwoPoints(xPoints[i],negativeYPoints[i],destx,desty) < smallestDistance) {
					if(isPointInvalid(xPoints[i],negativeYPoints[i],prevx,prevy,destx,desty) == false) {
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
