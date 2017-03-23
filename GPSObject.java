package Navigation;
import GIS;

/**
 * Created by darrenadams on 2017/03/21.
 * Usage: Class presents a Has-A relationship with Navigation.Location.(Aggregation)
 *        Instantiate Navigation.GPSObject disjoint from Navigation.Location.
 *        Eg. Navigation.GPSObject obj1 = new Navigation.GPSObject(name)
 *            Navigation.Location obj2 = new Navigation.Location(name,id,obj1)
 */
public class GPSObject {
    private GPSCoords coordinates;

    public GPSObject(String n)
    {
        coordinates = new GPSCoords();
        this.getCoords(n);
    }

    /**
     * Get's coordinates of location.
     * @param n Name of the location
     *
     */
    public Boolean getCoords(String n)
    {
        //Create GISRequest
        GISRequest req = new GISRequest(n);
        GISDataObject obj = GISDataObject::getGISDataObject(req);
        if(obj == null)
        {
            return false;
        }
        else
        {
            this.coordinates.set(obj);
            return true;
        }
    }
}

class GPSCoords{
    private float longlat[];


    public GPSCoords()
    {
        longlat = new float[2];
    }

    /**
     * Sets longlat to coordinates in GISDataObject
     * @param obj GIS Module returned data
     *
     */
    public void set(GISDataObject obj)
    {

        this.longlat = obj.GPSCoord;
    }

}
