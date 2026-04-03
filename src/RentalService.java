import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RentalService {
    BikeService B=new BikeService();
    Bike bike=new Bike();
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
        ActiveRental activeRental=new ActiveRental();
        BikeRequest r=B.reserveBike(bikeID,activeRental.getTripStartTime());
        while(it.hasNext()){
            ActiveRental a=it.next();
            if(a.getBikeID().equals(bikeID)){
                it.remove();
                Queue<BikeRequest>queue=B.getBikeRequestQueue();

                if (!queue.isEmpty()) {
                    r= queue.poll();
                    System.out.println("assign it to the next user " + r.getUserEmail());
                    String availableBikeId =B. validateLocation(r.getLocation());
                    B.reserveBike(availableBikeId, activeRental.getTripStartTime());
                }

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
