package com.gladius.navup.navigation;

/**
 * Created by darrenadams on 2017/03/23.
 * Interface for usage by Access Module
 */
public interface Navigation {

    /**
     *
     * @param inR List of locations
     * @param n name of route
     * @return JSON string of Route object.{Name,Path[{nameOfStart,locationid,coordinates}{nameOfEnd,locationid,coordinates}{nameOfWaypoints...}}
     * @throws NavigationExceptions
     */
    public String getRoute(Locations inR,String n) throws NavigationExceptions;

    /**
     *
     * @param routeName Name of route to find
     * @return route that matches the parameter
     */
    public Route accessRoute(String routeName);

    /**
     *
     * @param rN Name of route to delete
     * @return Boolean for success/failure
     */
    public Boolean deleteRoute(String rN);

    /**
     *
     * @param rt Route object to save current route
     * @return
     */
    public Boolean recordRoute(Route rt);

    /**
     *
     * @param rt Route to be saved
     * @return Boolean for success/failure
     */
    public Boolean saveRoute(Route rt);

    /**
     *
     * @param rt Modified Route
     * @param rN Name of Route to modify
     * @return Success/Failure
     */
    public Boolean modifyRoute(Route rt,String rN);

    /**
     *
     * @param loc list of locations to generate route.
     * @return the path based of preferences and locations
     */
    public Locations calculateRoute(Locations loc);

    /**
     * @param pref Preference to save
     * @return Success/Failure to save preferences
     */
    public Boolean savePreferences(String pref);

}
