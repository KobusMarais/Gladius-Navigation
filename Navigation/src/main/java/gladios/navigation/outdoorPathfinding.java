package gladios.navigation;
import gladios.gis.*;
import org.jgrapht.*;
import org.jgrapht.alg.interfaces.AStarAdmissibleHeuristic;
import org.jgrapht.alg.shortestpath.AStarShortestPath;
import org.jgrapht.generate.CompleteGraphGenerator;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import java.util.ArrayList;
import java.util.Random;


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

            boolean debug = true;

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
            int tick = 0;
            while(current != loc.get(1).getName() && tick  < 2000) {

                float[] locFl = gis.getCoordinates(current);
                radiusLoc = gis.locationsWithinRadius(locFl[0],locFl[1],0);
                tick++;
                for(int j = 0; j < radiusLoc.length;j++)
                {
                    stubs.add(radiusLoc[j]);
                }
                current = getNext(end,radiusLoc,gis);

            }



            //===========================

            //Find waypoints=============
            ArrayList<String> needToAdd = new ArrayList<String>();
            int needed = loc.size()-2;

            for(int k = 2; k < stubs.size();k++)
            {
                if(stubs.contains(loc.get(k).getName()))
                {
                    needed--;
                }
                else
                {
                    needToAdd.add(stubs.get(stubs.indexOf(loc.get(k).getName())));
                }
            }

            if(needed != 0)
            {
                //We need to add them to our stubs list
                for(int l = 0; l < needToAdd.size();l++)
                {
                    stubs.add(needToAdd.get(l));
                }
            }



            //End location
            stubs.add(loc.get(1).getName());

            //===========================
            String[] result;
            if(debug)
            {
                result = new String[stubs.size()];
                for(int i = 0; i < stubs.size();i++)
                {
                    result[i] = stubs.get(i);
                }
            }
            else
            {
                result = getShortestPath(stubs);
            }

            return compile(result);


        }

    private String[] getShortestPath(final ArrayList<String> stubs)
    {
        String[] ret = new String[0];
        //We now construct the graph, and add all locations to one another, calculating their distances between
        WeightedGraph<CustomVertex,DefaultWeightedEdge> graph = new SimpleWeightedGraph<CustomVertex, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        CompleteGraphGenerator<CustomVertex,DefaultWeightedEdge> gen = new CompleteGraphGenerator<CustomVertex, DefaultWeightedEdge>(stubs.size());

        VertexFactory<CustomVertex> vFactory = new VertexFactory<CustomVertex>() {

            private int i = 0;
            private ArrayList<String> s = stubs;
            public CustomVertex createVertex() {
                CustomVertex n = new CustomVertex(s.get(i++));
                return n;
            }
        };

        //Draw graph
        gen.generateGraph(graph,vFactory,null);

        int i = 0;
        final GISInterface gis = GIS.getInstance();
        for(DefaultWeightedEdge e : graph.edgeSet())
        {
            float[] current = gis.getCoordinates(stubs.get(i));
            float[] next = gis.getCoordinates(stubs.get(i+1));
            if(i == stubs.size()-1)
            {

            }
            else {
                graph.setEdgeWeight(e, distanceBetween(current[0],current[1],next[0],next[1]));
            }
        }

        AStarAdmissibleHeuristic<CustomVertex> v = new AStarAdmissibleHeuristic<CustomVertex>() {
            public double getCostEstimate(CustomVertex customVertex, CustomVertex v1) {
                float[] n1 = gis.getCoordinates(customVertex.getName());
                float[] n2 = gis.getCoordinates(v1.getName());
                return distanceBetween(n1[0],n1[1],n2[0],n2[1]);
            }
        };
        AStarShortestPath a = new AStarShortestPath(graph,v);
        CustomVertex begin = new CustomVertex(stubs.get(0));
        CustomVertex end = new CustomVertex(stubs.get(1));
        GraphPath p = a.getPath(begin,end);

        String splitt = p.getVertexList().toString();
        return splitt.split(",");



        /*for(int j = 0; j < stubs.size();j++)
        {
            for(int k = 0; k < stubs.size();k++)
            {
                float[] jCoord,kCoord;
                GISInterface giss = GIS.getInstance();
                jCoord = giss.getCoordinates(stubs.get(j));
                kCoord = giss.getCoordinates(stubs.get(k));
                graph.setEdgeWeight(stubs.get(j),stubs.get(k),distanceBetween(jCoord[0],jCoord[1],kCoord[0],kCoord[1]));
            }
        }*/

    }

    private Locations compile(String[] locs)
    {
        Locations ret = new Locations();
        Random rand = new Random();
        for(int i = 0; i < locs.length;i++)
        {
            GPSObject obj = new GPSObject(locs[i]);
            ret.addLocation(new Location(locs[i], rand.nextInt() + " ",obj));
        }
        return ret;
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

class CustomVertex
{
    private String name;

    public CustomVertex(String n)
    {
        this.name = n;
    }

    public String getName()
    {
        return name;
    }


}
