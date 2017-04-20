package gladios.navigation;
//import gladios.gis.*;

/**
 * Created by darrenadams on 2017/03/21.
 * Usage: Class presents a Has-A relationship with Navigation.Location.(Aggregation)
 *        Instantiate Navigation.GPSObject disjoint from Navigation.Location.
 *        Eg. Navigation.GPSObject obj1 = new Navigation.GPSObject(name)
 *            Navigation.Location obj2 = new Navigation.Location(name,id,obj1)
 */
public class GPSObject {
    private float latitude,longitude;

    /**
     *
     *
     * @param n Name of location to get co-ordinates for
     */
    public GPSObject(String n)
    {
        this.requestGIS(n);
    }

    /**
     * Get's coordinates of location.
     * @param n Name of the location
     *
     */
    public Boolean requestGIS(String n)
    {
        float[] obj;
        //Create GISRequest
        GISInterface gis = GIS.getInstance();
        obj = gis.getCoordinates(n);
        if(obj == null)
        {
          return false;
        }
        else
        {
            set(obj);
            return true;
        }
    }
    private void set(float[] ob)
    {
        this.longitude = ob[1];
        this.latitude = ob[0];
    }

    /**
     *
     * @return Float array co-ordinates
     */
    public float[] getLongLatCoords()
    {
        float[] l = new float[2];
        l[0] = latitude;
        l[1] = longitude;
        return l;
    }

    public float getLatitude()
    {
        return latitude;
    }

    public float getLongitude()
    {
        return longitude;
    }
}

