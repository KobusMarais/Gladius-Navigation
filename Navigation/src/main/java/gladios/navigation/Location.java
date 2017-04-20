package gladios.navigation;
/**
 * Created by darrenadams on 2017/03/21.
 *
 *
 */
public class Location {

    private String name;
    private String locationID;
    private GPSObject coordinates;

    /**
    *   Constructor that will create a new location object from a GPS object and assign it a name and id
    *   @param  n   String that will be the name for the specific location example: HB 4-14
    *   @param id   String that will be a unique identifier for the object
    *   @param obj  GPSObject received from GIS module containing latitude and longitude of location
    */
    public Location(String n, String id, GPSObject obj)
    {
        this.name = n;
        this.locationID = id;
        this.coordinates = obj;

    }

    /**
     *
     * @return Co-ordinates from location in string format
     */
    public String retrieveCoordinatesString()
    {
        float[] longlat = coordinates.getLongLatCoords();
        return longlat[0] + "," + longlat[1];
    }


    /**
     *
     * @return Co-ordinates from location in float format
     */
    public float[] retrieveCoordinatesFloat()
    {
        return coordinates.getLongLatCoords();
    }

    public String getName()
    {
        return this.name;
    }


    public String getLocationID()
    {
        return locationID;
    }

    public GPSObject getCoordinates()
    {
        return coordinates;
    }
}
