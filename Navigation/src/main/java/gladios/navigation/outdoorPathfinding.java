package gladios.navigation;
import gladios.gis.*;


/**
 * Created by DJ Adams.
 * Student Number 14256232
 *
 * This class is responsible for creating an optimal path needed for navigating outdoors.
 */
public class outdoorPathfinding {

    /**
     *
     * @param loc locations to navigate to and from.
     * @return Outdoor route to follow
     */
    public Locations findOutdoor(Locations loc)
        {


            return null;
        }

    /**
     * This method works out the distance between 2 lon/lat combinations
     * @param lat1 latitude for location 1
     * @param lon1 longitude for location 1
     * @param lat2 latitude for location 2
     * @param lon2 longitude for location 2
     * @return distance in Kilometers between the 2
     * This method was adapted from online sources
     * Credit goes to http://stackoverflow.com/users/75701/dommer
     */
    private double distanceBetween(float lat1, float lon1, float lat2, float lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        //Convert to Kilometers
        dist = dist * 1.609344;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }


}
