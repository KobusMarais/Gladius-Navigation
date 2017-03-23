package Navigation;
/**
 * Created by darrenadams on 2017/03/23.
 * Custom Request Class As Per Documentation
 */
public class getRouteRequest {

    public Route route;

    public getRouteRequest(Route rt)
    {
        route = new Route(rt);
    }

    public String getName()
    {
        return route.getName();
    }


}
