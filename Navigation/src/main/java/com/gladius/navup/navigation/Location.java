
package com.gladius.navup.navigation;
/**
 * Created by darrenadams on 2017/03/21.
 *
 *
 */
public class Location {

    private String name;
    private String locationID;
    private GPSObject coordinates;

    public Location(String n, String id, GPSObject obj)
    {
        this.name = n;
        this.locationID = id;
        this.coordinates = obj;

    }

    /**
     *
     * @return Co-ordinates from location
     */
    public String retrieveCoordinates()
    {
        float[] longlat = coordinates.getLongLatCoords();
        return longlat[0] + "," + longlat[1];
    }
}
