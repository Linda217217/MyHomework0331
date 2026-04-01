

    import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

    public class AdminPanel {
        private final UserService userService = new UserService();
        private final BikeService bikeService = new BikeService();
        private final RentalService rentalService = new RentalService();

        public void userManagementOptions() {

            System.out.println("Please select an option:");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    userService.addNewUsers();
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
                    System.exit(0);

            }


        }
    }

