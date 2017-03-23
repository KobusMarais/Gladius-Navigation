package Navigation;

import org.json.*;

/**
 * Created by darrenadams on 2017/03/23.
 * Implementation for the Navigation Interface
 */
public class NavigationIHandler implements Navigation {

    public JSONObject getRoute(getRouteRequest inR) throws NavigationExceptions {
            //Check if user is registered

            //Check if information is correct
            if(inR.getName() == "" || inR.route.getLocations() == null)
            {
                throw new IncompleteInformation();
            }

            //Check if validation failed

            //Check if route is found
            Routes nR = new Routes();
            Route rT;
            if((rT = nR.getRoute(inR.getName())) == null)
            {
                throw new RouteNotFound();
            }
            else
            {

                return navigation_Route(new getRouteRequest(rT));
            }

    }

    public Response accessRoute() {
        return new Response(null);

    }

    public Boolean deleteRoute(getRouteRequest rt)
    {
        Routes nR = new Routes();
        return nR.removeRoute(rt.route);
    }

    public Boolean recordRoute(getRouteRequest rt)
    {
        Routes nR = new Routes();
        return nR.addRoute(rt.route);
    }

    public Boolean saveRoute(getRouteRequest rt)
    {
        Routes nR = new Routes();
        return nR.addRoute(rt.route);

    }

    public Response modifyRoute(getRouteRequest rt)
    {
        Routes nR = new Routes();
        return new Response(nR.modifyRoute(rt.route));

    }

    public Response calculateRoute(getRouteRequest rt)
    {
        Routes nR = new Routes();
        return new Response(nR.getPreferedRoute(rt.route.getLocations()));

    }

    public Boolean savePreferences()
    {
        Routes nR = new Routes();
        return nR.savePreference();
    }

    public JSONObject navigation_Route(getRouteRequest rt)
    {
        //Build JSON to parse to Access
        JSONObject returnobj = new JSONObject();
        returnobj.put("origin","-25.756462,28.231124");
        returnobj.put("destination","-25.753815,28.228808");
        returnobj.put("travelMode","WALKING");
        return returnobj;

    }





}

