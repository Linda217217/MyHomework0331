import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RentalService {
    List<ActiveRental> activeRentalList=new LinkedList<>();
    public void startRental(String bikeID, String emailAddress, LocalDateTime tripStartTime) {
        ActiveRental activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
        activeRentalList.add(activeRental);
    }
    public void endRental(String bikeID) {
        for (Bike b : BikeDatabase.bikes) {
            if (b.getBikeID().equals(bikeID)) {
                b.setAvailable(true);
                b.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us!");
                System.out.println();
                break;
            }
        }
    }
    public void removeTrip(String bikeID){
        Iterator<ActiveRental> it=activeRentalList.iterator();
        while(it.hasNext()){
            ActiveRental a=it.next();
            if(a.getBikeID().equals(bikeID)){
                it.remove();;
                break;
            }
        }

    }

    public void viewActiveRentals(){
        if(activeRentalList.isEmpty()){
            System.out.println("No active rentals at the moment. ");
        }else{
            for(ActiveRental rental:activeRentalList){
                System.out.println(rental);
            }
        }
    }
}
