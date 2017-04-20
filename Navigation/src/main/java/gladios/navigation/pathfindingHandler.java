package gladios.navigation;

import java.util.concurrent.*;

/**
 * Created by DJ Adams.
 * Student Number 14256232
 * This class acts as an entry point for pathfinding.
 */
public class pathfindingHandler {

    /**
     * @author DJ Adams
     * @param loc list of locations to pathfind through
     * @return correct sequence of locations to follow.
     */
    public Locations calculatePath(Locations loc)
    {

        try {

            //Start thread
            ExecutorService es = Executors.newFixedThreadPool(2);
            Future<Locations> f = es.submit(new IndoorThread(loc));
            Future<Locations> f2 = es.submit(new OutdoorThread(loc));

            //Wait until threads are done with their job.
            es.shutdown();
            es.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);



            //Now we compile the results into a single return
            return compile(f,f2);


        }
        catch (Exception exp)
        {
            System.out.println(exp.getMessage());
        }

        return null;


    }

    /**
     * @author DJ Adams
     * Provides compilation of outdoor/indoor calculations into single return
     * @param ind Indoor Calculated Route
     * @param out Outdoor Calculated Route
     * @return Final route to be used by the user
     */
    public Locations compile(Future<Locations> ind,Future<Locations> out)
    {
        try {
            Locations indoor = ind.get();
            Locations outdoor = out.get();

            Locations finalRet = new Locations();
            finalRet.addLocation(outdoor.get(0));
            for(int i = 0; i < 0; i++)
            {
                finalRet.addLocation(indoor.get(i));
            }
            finalRet.addLocation(outdoor.get(outdoor.size()-1));

            return finalRet;
        }
        catch (Exception err)
        {

        }
        return null;
    }

}

/**
 * @author DJ Adams
 * This class provides a callable to be used with executor Service for concurrency
 * IndoorPathfinding
 */
class IndoorThread implements Callable<Locations>
{
    Locations arr;
    IndoorThread(Locations arr2){
        arr = arr2;
    }
    public Locations call() {
        return new IndoorPathfinding().findIndoor(arr);
    }
}

/**
 * @author DJ Adams
 * This class provides a callable to be used with executor Service for concurrency
 * OutdoorPathfinding
 */
class OutdoorThread implements Callable<Locations>
{
    Locations arr;
    OutdoorThread(Locations arr1){
        arr = arr1;
    }
    public Locations call(){
        return new outdoorPathfinding().findOutdoor(arr);
    }
}

