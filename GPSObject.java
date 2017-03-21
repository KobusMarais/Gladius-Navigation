/**
 * Created by darrenadams on 2017/03/21.
 * Usage: Class presents a Has-A relationship with Location.(Aggregation)
 *        Instantiate GPSObject disjoint from Location.
 *        Eg. GPSObject obj1 = new GPSObject(name)
 *            Location obj2 = new Location(name,id,obj1)
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
    public void getCoords(String n)
    {
        //Create GISRequest
        GISRequest req = new GISRequest(n);
        GISDataObject obj = GISDataObject::getGISDataObject(req);
        this.coordinates.set(obj);
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
