package com.gladius.navup.navigation;
import com.google.gson.*;
import java.util.ArrayList;

/**
 * Created by darrenadams on 2017/03/23.
 * Implementation for the Navigation Interface
 */
public class NavigationIHandler implements Navigation {
    private static NavigationIHandler object;
    private NavigationIHandler(){}

    public static NavigationIHandler getInstance()
    {
        if(object == null)
        {
            object = new NavigationIHandler();
        }
        return object;
    }


    public String getRoute(Locations inR,String n) throws NavigationExceptions {
            //Check if user is registered
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            //Check if information is correct
            if(inR.get(0).equals(null) && inR.get(1).equals(null))
            {
                throw new IncompleteInformation();
            }

            //Check if validation failed

            //Check if route is found
            Routes nR = new Routes();
            if((nR.getRoute(n)) == null)
            {
                //throw new RouteNotFound();
                return gson.toJson(new Route(n,calculateRoute(inR)));
            }
            else
            {
                return gson.toJson(nR.getRoute(n));

            }

    }

    public Route accessRoute(String rN) {
        return new Route();

    }

    public Boolean deleteRoute(String rt)
    {
        Routes nR = new Routes();
        return nR.removeRoute(new Route());
    }

    public Boolean recordRoute(Route rt)
    {
        Routes nR = new Routes();
        return true;
    }

    public Boolean saveRoute(Route rt)
    {
        Routes nR = new Routes();
        return nR.addRoute(new Route());

    }

    public Boolean modifyRoute(Route rt,String rN)
    {
        Routes nR = new Routes();
        return true;

    }

    public Locations calculateRoute(Locations rt)
    {
        Routes nR = new Routes();
        return nR.getPreferedRoute(rt);

    }

    public Boolean savePreferences(String pref)
    {
        Routes nR = new Routes();
        return nR.savePreference(pref);
    }








}

