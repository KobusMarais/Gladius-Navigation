//Created by Jacobus Marais 15188397 21/03/2017
public class Locations
{
	public Location[] listOfLocations;

	public Locations()
	{
		listOfLocations = null; //initialises the list to null
	}
	
	public void addLocation(Location inLoc)
	{
		
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
		}	
	}
	
	public Location modifyLocation(Location inLoc, String name, String id, GPSObject obj)
	{
		
	}
	
	public void removeLocation(Location inLoc)
	{
	
	}
}