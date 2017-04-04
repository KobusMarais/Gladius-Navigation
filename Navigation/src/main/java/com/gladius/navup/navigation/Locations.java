//Created by Jacobus Marais 15188397 21/03/2017
package com.gladius.navup.navigation;

import java.util.ArrayList;

public class Locations
{
	public ArrayList<Location> listOfLocations;

	public Locations()
	{
		listOfLocations = new ArrayList<Location>(); //initialises the list to null
	}

	/**
	*	Function will add push a new location to the end of an existing list of locations to form a route
	*
	*	@param inLoc	The Location object that will be added to the listOfLocations ArrayList
	*/
	public void addLocation(Location inLoc)
	{
		listOfLocations.add(inLoc);
		/*//This will add a location to the List of Saved Locations
		if((listOfLocations != null ) && (listOfLocations.length > 0)) //checks if the list has any entries
		{
			Location[] temp = new Location[listOfLocations.length+1];
			for(int i = 0; i < listOfLocations.length; i++)
			{
				temp[i] = listOfLocations[i];
			}
			temp[listOfLocations.length] = inLoc;
			listOfLocations = new Location[temp.length]; //grow list
			for(int i = 0; i < temp.length; i++)
			{
				listOfLocations[i] = temp[i];
			}
		}
		else //easy adds only location in list
		{
			listOfLocations = new Location[1];
			listOfLocations[0] = inLoc;
		}*/
	}

	/**
	*	Function will create a new Location object from the given parameters to replace a given Location
	*
	*	@param	inLoc	The location that will be replaced by the new location 
	*	@param	name	The name of the new location
	*	@param	id	The id of the new location
	*	@param	obj	The latitude and longitude of the new object
	*
	*	@return	the newly created location
	*/
	public Location modifyLocation(Location inLoc, String name, String id, GPSObject obj)
	{
		Location newLoc = new Location(name, id, obj);
		if(listOfLocations.indexOf(inLoc) == -1)
		{

		}
		else {

			listOfLocations.set(listOfLocations.indexOf(inLoc), newLoc);
		}
		//This will modify a location on the List of Saved Locations
		/*if(listOfLocations != null && listOfLocations.length > 0)
		{
			Location modified = new Location(name, id, obj); //create new Location
			for (int i = 0; i < listOfLocations.length; i++)
			{
				if(listOfLocations[i] == inLoc)
				{
					listOfLocations[i] = modified;	//replace old location with modified location
					return modified;
				}
			}
		}

		Location modified = new Location(name, id, obj); //create new Location*/
		return newLoc;
	}

	/** 
	*	Function removes a given location from the ArrayList
	*	@param inLoc	the location to be removed 
	*
	*/
	public void removeLocation(Location inLoc)
	{
		listOfLocations.remove(listOfLocations.indexOf(inLoc));
		//This will remove a location from the List of Saved Locations
		/*if(listOfLocations != null && listOfLocations.length > 0)
		{
			if(listOfLocations.length == 1) //simple remove by clearing list
			{
				listOfLocations = null;
			}
			else
			{
				Location[] temp = new Location[listOfLocations.length-1];
				int j = 0;
				for(int i = 0; i < listOfLocations.length; i++)
				{
					if(inLoc != listOfLocations[i])
					{
						temp[j] = listOfLocations[i];
						j++;
					}
				}
				listOfLocations = new Location[temp.length]; //shrinks list
				for(int i = 0; i < temp.length; i++)
				{
					listOfLocations[i] = temp[i];
				}
			}
		}*/
	}
	/**
	*	Function returns a location at a specific location in the ArrayList
	*
	*	@param	index	The index in the ArrayList of the location that will be returned
	*	@return a Location object
	*/
	public Location get(int index)
	{
		return listOfLocations.get(index);
	}
	public int size()
	{

			return listOfLocations.size();

	}

}
