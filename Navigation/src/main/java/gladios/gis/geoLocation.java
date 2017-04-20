/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladios.gis;

/**
 *
 * @author peter
 */
public class geoLocation  {
   public double longitude;
    public double latitude;
    
    public geoLocation(double longitude,double latitude){
    this.longitude=longitude;
    this.latitude= latitude;
    }
    
    public double getLatitude(){
    return this.latitude;
    }
    
    public double getLongitude(){
    return this.longitude;
    }
    
    
    


}
