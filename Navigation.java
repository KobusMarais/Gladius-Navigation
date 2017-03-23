package Navigation;

import org.json.*;

/**
 * Created by darrenadams on 2017/03/23.
 * Interface for usage by Access Module
 */
public interface Navigation {

    public JSONObject getRoute(getRouteRequest inR) throws NavigationExceptions;

    public Response accessRoute();

    public Boolean deleteRoute(getRouteRequest rt);

    public Boolean recordRoute(getRouteRequest rt);

    public Boolean saveRoute(getRouteRequest rt);

    public Response modifyRoute(getRouteRequest rt);

    public Response calculateRoute(getRouteRequest rt);

    public Boolean savePreferences();

    public JSONObject navigation_Route(getRouteRequest rt);
}
