import java.time.LocalDateTime;

public class BikeService {
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
    public void  reserveBike(String bikeID,LocalDateTime tripStartTime){
        if(bikeID==null||bikeID.isEmpty()){
            System.out.println("Sorry, we’re unable to reserve a bike at this time. Please try again later.");
        }else{
            for(Bike bike:BikeDatabase.bikes){
                if(bike.getBikeID().equals(bikeID)){
                    bike.setAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving bike with ID:"+bikeID);
                    System.out.println("Please follow the on-screen direction to locate your bike and start your trip.");
                    System.out.println();
                    break;
                }
            }
        }
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

}
