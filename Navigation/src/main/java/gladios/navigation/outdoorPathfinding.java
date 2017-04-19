package gladios.navigation;
import gladios.gis.*;

import java.util.ArrayList;


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

            //We will be receiving a list of locations to find our way around


            //We need to find a radius of locations from start to end.


            //Holds a list of applicable locations
            ArrayList<String> stubs = new ArrayList<String>();

            //===========================Finding the path towards the end position.

            GISInterface gis = GIS.getInstance();
            String current = loc.get(0).getName();
            float[] fl = loc.get(0).retrieveCoordinatesFloat();
            float[] end = loc.get(1).retrieveCoordinatesFloat();
            String[] radiusLoc = gis.locationsWithinRadius(fl[0],fl[1],0);

            stubs.add(current);

            for(int i = 0; i < radiusLoc.length;i++)
            {
                stubs.add(radiusLoc[i]);
            }

            //Find the lowest distance to go to next waypoint
            current = getNext(end,radiusLoc,gis);
            while(current != loc.get(1).getName()) {

                float[] locFl = gis.getCoordinates(current);
                radiusLoc = gis.locationsWithinRadius(locFl[0],locFl[1],0);
                for(int j = 0; j < radiusLoc.length;j++)
                {
                    stubs.add(radiusLoc[j]);
                }
                current = getNext(end,radiusLoc,gis);

            }

            //===========================

            //Find waypoints=============




            //===========================




            return null;
        }

    /**
     *
     * @param loc Array of locations within radius
     * @return shortest distanced location
     */
    private String getNext(float[] end,String[] loc ,GISInterface gis)
    {
        double lowest = 0;
        String lowestLocation = "";
        for(int i = 0; i < loc.length;i++)
        {
            float[] fl = gis.getCoordinates(loc[i]);
            if(lowest == 0)
            {

                lowest = distanceBetween(end[0],end[1],fl[0],fl[1]);
                lowestLocation = loc[i];
            }
            else
            {
                if(distanceBetween(end[0],end[1],fl[0],fl[1]) < lowest)
                {
                    lowest = distanceBetween(end[0],end[1],fl[0],fl[1]);
                    lowestLocation = loc[i];
                }
            }
        }

        return lowestLocation;
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
