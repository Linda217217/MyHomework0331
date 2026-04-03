

    import java.util.*;

    public class AdminPanel {
        private final UserService userService = new UserService();
        private final BikeService bikeService = new BikeService();
        private final RentalService rentalService = new RentalService();
        private final Bike bike = new Bike();
        UserRegistration u=new UserRegistration();
        private final ActiveRental activeRental = new ActiveRental();

        public void userManagementOptions() {

            System.out.println("Please select an option:");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. Demo rental service");
            System.out.println("6. View System Logs");
            System.out.println("7. Manage Pending Bike Requests");
            System.out.println("8. EXIT");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                   RegisteredUsers registeredUsers= userService.addNewUsers();

                   break;
                case 2:
                    userService.viewRegisteredUsers();
                    break;
                case 3:
                    userService.removeRegisteredUsers();
                    break;
                case 4:
                    userService.updateRegisteredUsers();
                    break;
                case 5:
                  String ID=bikeService.validateLocation(bike.getLocation());
                  if(ID!=null) {
                      RegisteredUsers u1 = userService.addNewUsers();

                      bikeService.reserveBike(ID, activeRental.getTripStartTime());
                      rentalService.startRental(ID, u.getEmailAdress(), activeRental.getTripStartTime());

                      rentalService.endRental(ID, u1);
                      rentalService.removeTrip(ID);
                      bikeService.releaseBike(ID);
                      rentalService.viewActiveRentals();
                  }else{
                      System.out.println("wrong");
                      break;
                  }
                case 6:
                      bikeService.viewSystemLogs();
                      break;
                case 7:
                    System.out.println("1. View Queue");
                    System.out.println("2. Update Queue");
                    System.out.println("3. Exit");
                   int your=sc.nextInt();
                   sc.nextLine();
                    Queue<BikeRequest> que= bikeService.getBikeRequestQueue();
                   if(your==1){

                      for(BikeRequest r:que){
                          System.out.println(r);
                      }
                   }else if(your==2){
                      BikeRequest request= que.poll();
                   }else  if(your==3){
                       System.exit(0);
                   }
                   break;
                case 8:
                    System.exit(0);
            }


        }
    }

