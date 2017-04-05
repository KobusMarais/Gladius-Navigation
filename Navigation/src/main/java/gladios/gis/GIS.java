package gladios.gis;
import java.sql.*; 
import java.util.*; 
import java.lang.*; 
import static java.sql.DriverManager.getConnection;
//import org.postgis.*;
//import org.postgresql.*;

public class GIS implements GISInterface {
    Connection conn ;
    Statement statement;
    private static GIS gisobject= new GIS();
    public static void main(String[] args) {
        // TODO code application logic here
        // do all your testing of your modules here
          
        
    }

    
    /**
     * Constructor for the class that will initialize the fields and establish connection
     * to the database with the default parameters.
     */
   public GIS(){}
   


     /**
     * Returns the instance of the GIS object.
     * @return 
     */
    public static GIS getInstance(){
    return gisobject;
    
    }
    /**
     * Constructor for the class that will initialize the fields and establish connection
     * to the database.
     *
     * @param db        String value that holds the name of the database
     * @param password  String value that holds the password which will authenticate the
     *                  connection
     */
    public GIS(String db, String password){
/*
            java.sql.Connection conn = null; 

  try { 
    
    Class.forName("org.postgresql.Driver"); 
    String url = "jdbc:postgresql://localhost:5433/postgis_23_sample"; 
    
    // DriverManager.getConnection(url, username, password);
   this.conn = DriverManager.getConnection(url, "postgres", "1234"); 
        */
    /* 
    * Add the geometry types to the connection. Note that you 
    * must cast the connection to the pgsql-specific connection 
    * implementation before calling the addDataType() method. 
    */
   // ((org.postgresql.Connection)conn).addDataType("geometry","org.postgis.PGgeometry");
   // ((org.postgresql.Connection)conn).addDataType("box3d","org.postgis.PGbox3d");
    /* 
    * Create a statement and execute a select query. 
    */ 
   // PreparedStatement ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS buildings(");
   // ps.executeUpdate();
   // ps.close();
    
    
    // ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS lectureHalls");
   // ps.executeUpdate();
   // ps.close();
    
    
  // Statement s = conn.createStatement(); 
   // ResultSet r = s.executeQuery("select AsText(geom) as geom,id from geomtable"); 
   // while( r.next() ) { 
      /* 
      * Retrieve the geometry as an object then cast it to the geometry type. 
      * Print things out. 
      */ 
    //  PGgeometry geom = (PGgeometry)r.getObject(1); 
     // int id = r.getInt(2); 
     // System.out.println("Row " + id + ":");
     // System.out.println(geom.toString()); 
   // } 
   // s.close(); 
   // conn.close(); 
 // } 
  // catch( Exception e ) { 
  //          e.printStackTrace(); 
   // } 


   //  System.out.println("Opened database successfully");
   // */
    }




    /**
     * Queries the database and returns the coordinates for the respective building location
     *
     * @param b     name of the building
     * @return      array of coordinates for the requested building
     */
    @Override
    public float[] getCoordinates(String b){
        try {
            statement = conn.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM LOCATIONS WHERE NAME = '" + b + "'");
            String[] coords = set.getString("COORDINATES").split(",");
            float[] ret = new float[2];
            ret[0] = Float.valueOf(coords[0]);
            ret[1] = Float.valueOf(coords[1]);
          
            return ret;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            
            // dummy result
            float[] temp={1,14};
            return temp;
        }
    } 
    

    /**
     * Queries the database and returns the building location for the respective coordinates
     * 
     * @param x     X coordinate of the building
     * @param y     Y coordinate of the building
     * @return      name of the building
     */
    @Override
    public String getLocation( float x, float y )
    {
        try {
            String coords = String.valueOf(x) + "," + String.valueOf(y);
            statement = conn.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM LOCATIONS WHERE COORDINATES = '" + coords + "'");
            String ret = set.getString("NAME");
          
            return ret;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            
            // dummy result
            return "IT 4-4";
        }
    }
  
    /**
     * Returns all locations stored in the database
     *
     * @return  All locations
     */
    public String[] getAllLocations() {
     /*   try {
            statement = conn.createStatement();
            ResultSet set = statement.executeQuery("SELECT COUNT(*) FROM LOCATIONS");
            int count = set.getInt(), k = 0;
            String[] ret = new String[count];
            set = statement.executeQuery("SELECT * FROM LOCATIONS");
            while (set.next())
                ret[k++] = set.getString("NAME");
            return ret;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
        */
       String[] test={"hi"};
        return test;
     
    }
    
    /**
     * Returns all locations within a radius
     *
     * @param   x   X coordinate of current position
     * @param   y   Y coordinate of current position
     * @param   r   Radius
     * @return  Location array
     */
    public String[] locationsWithinRadius(float x, float y, float r) {
    /*
            try {
            statement = conn.createStatement();
            ResultSet set = statement.executeQuery("SELECT COUNT(*) FROM LOCATIONS");
        //giving errors 
                int count = set.getInt(), k = 0;
            String[] temp = new String[count];
            set = statement.executeQuery("SELECT * FROM LOCATIONS");
            while (set.next()) {
                float rad, a = 0, b = 0;
                                //rs doesnt exist
                //String[] coords = rs.getString("COORDINATES").split(",");
                                //coords doesnt exist
                //a = Float.valueOf(coords[0]);
                //b = Float.valueOf(coords[1]);
                rad = (float) Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2));
                if (rad <= r)
                    temp[k++] = set.getString("NAME");
            }
            String[] ret = new String[k];
            for (int j = 0; j < k; j++)
                ret[j] = temp[j];
            return ret;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
            */
        String[] test={"hi"};
        return test;
    }

    @Override
    public String getGISDataObject(String a){ return a;}
    @Override
    public String modifyGISData(String a){ return a;}

   /**  
     * Creates a new table in the database, provided that the authenticated user has
     * the appropriate permissions.
     *
     * @param table     A string value of the object to be deleted
     * @return          A boolean value on whether the method was successful or not
     */
    @Override
    public boolean newTable(String table){
    //creates new table from string
        return true;
    }
    
    /**  
     * Inserts an item into the database, provided that the authenticated user has the
     * appropriate permissions.
     *
     * @param values    A string value of the object to be inserted
     * @return          A boolean value on whether the method was successful or not
     */
    @Override
    public boolean insert(String values){
    //inserts values into database
        return true;
    }
     
    /**  
     * Updates an item from the database, provided that the authenticated user has the
     * appropriate permissions.
     *
     * @param values    A string value of the object to be updated
     * @return          A boolean value on whether the method was successful or not
     */ 
    
    @Override
    public boolean update(String values){
    //updates value with given values string
        return true;
    }
      
    /**  
     * Removes an item from the database, provided that the authenticated user has the
     * appropriate permissions.
     *
     * @param values    A string value of the object to be deleted
     * @return          A boolean value on whether the method was successful or not
     */
    @Override
    public boolean delete(String values){
    //deletes item on the database
        return true;
    }


    /**
     * this is for demo purposes only
     * @return returns the names of all the builds in the database
     */
    public String[] getAllBuildings(){
    
    String[] test={"geography","IT","Maths","Economics"};
    return test;
    }
    
    
    
     /**
      *  this is for demo purposes only
     * @b is the name of the building that the user has selected
     * @return returns all the classrooms of the building that was passed through as parameter
     */
    public String[] getClassRooms(String b)
    {
    
    String[] test={"IT 4-1","IT 4-2","IT 4-3","IT 4-4","IT 4-5"};
    return test;
    
    }

    //@Override
    public double[] getLocationTemp(String b) {
      // double[] test;
        double a;
        a = -25.7559782;
       double c;
       c= 28.2332799;
        double[]  test={a,c};
        return test;
    }
    
    
      public geoLocation[] getRoute(double longitude, double latitude, String buildingName)
      {
          // sends route from in front of csc to IT building
            geoLocation a=new geoLocation(-25.7545198,28.2314715);
             geoLocation b=new geoLocation(-25.7551981,28.2314407);
              geoLocation c=new geoLocation(-25.7553843,28.232275);
               geoLocation d=new geoLocation(-25.7559221,28.2332922);
      
              geoLocation[] test={a,b,c,d};
             return test;
      
      }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}