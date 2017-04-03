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
	public Location get(int index)
	{
		return listOfLocations.get(index);
	}
	public int size()
	{

			return listOfLocations.size();

	}

}