package gladios.gis;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public interface GISInterface{
  //--------------------------------------------working-------------------------------------------------------------//
    //takes in the building name and gives back all the classroom names in an array of strings 
     public String[] getClassRooms(String b);// THIS WORKS
     // returns the names of all the buildings in an array of strings
    public String[] getAllBuildings(); //THIS WORKS
    //takes in the name of a room and returns the coordinates in a float array 
    // takes a string such as IT 4-4 and returns the coordinates in a double array
     public double[] getLocationTemp(String b); // THIS WORKS
  
     // takes in longitude and latitude and a building name and returns and array of geolocations 
        public geoLocation[] getRoute(double longitude, double latitude, String buildingName);
     
  
    //-----------------------------------------uderwork------------------------------------------------------------//
    public float[] getCoordinates(String b); // implemented- needs testing
    
    // takes in the longitude and latitude and returns the place which x and y lay inside
     public String getLocation( float x, float y );  // implemented- needs testing
    
  
      public String[] getAllLocations() ; // implemented- needs testing
      public String[] locationsWithinRadius(float x, float y, float r); // implemented- needs testing
   
  
  // will return a JSON object of the building that is passed through.
   public String getGISDataObject(String a);
      public String modifyGISData(String a);
      public boolean newTable(String table);
      public boolean insert(String values);
       public boolean update(String values);
       public boolean delete(String values);

}
    