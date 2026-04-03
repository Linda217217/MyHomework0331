import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BikeService {
    Stack<ERyderLog>logStack=new Stack<>();
    Bike bike=new Bike();
  private Queue<BikeRequest>bikeRequestQueue=new ArrayDeque<>();

    public Queue<BikeRequest> getBikeRequestQueue() {
        return bikeRequestQueue;
    }

    ActiveRental A=new ActiveRental();

    public  String validateLocation(String location){
        for(Bike bike:BikeDatabase.bikes){
            if(bike.getLocation().equals(location)){
                if(bike.isAvailable()){
                    System.out.println("A bike is available at the location you requested.");
                    System.out.println();
                    return bike.getBikeID();
                }
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested. ");
        System.out.println("Exiting the program.Please try again later when we have bikes available at your location.Thank you!");
        return null;

    }
    public BikeRequest reserveBike(String bikeID,LocalDateTime tripStartTime){
        if(bikeID==null||bikeID.isEmpty()){
            BikeRequest r=new BikeRequest(A.getUserEmail(),bike.getLocation(),LocalDateTime.now());
            bikeRequestQueue.add(r);
            System.out.println("Sorry, we’re unable to reserve a bike at this time. Please try again later.");
        return r;
        }else{
            for(Bike bike:BikeDatabase.bikes){
                if(bike.getBikeID().equals(bikeID)){
                    bike.setAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving bike with ID:"+bikeID);
                    System.out.println("Please follow the on-screen direction to locate your bike and start your trip.");
                    ERyderLog log = new ERyderLog("The "+bike.getBikeID()," was rented at " +bike.getLocation()  + " on ",tripStartTime);
                    System.out.println();
                    break;
                }
            }
        }
        return null;
    }
    public void releaseBike(String bikeID) {
        for (Bike b : BikeDatabase.bikes) {
            if (b.getBikeID().equals(bikeID)) {
                b.setAvailable(true);
                b.setLastUsedTime(LocalDateTime.now());
                break;
            }
        }
    }
    public void  viewSystemLogs(){
        for(ERyderLog L:logStack){
            System.out.println(L);
        }
    }

}
