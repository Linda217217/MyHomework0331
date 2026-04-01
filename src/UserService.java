import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserService {
    List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    public void addNewUsers() {

        System.out.println("How many users the admin would like to add");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter your fullNmae: ");
            String fullName = sc.nextLine();

            System.out.println("Enter your emailAdress: ");
            String emailAddress = sc.nextLine();


            System.out.println("Enter your birth date in(yyyy-MM-dd):format: ");
            String dateOfBirth = sc.nextLine();


            System.out.println("Enter your cardNumber: ");
            long cardNumber = sc.nextLong();
            sc.nextLine();

            System.out.println("Enter your cardProvider: ");
            String cardProvider = sc.next();
            sc.nextLine();

            System.out.println("Enter your card expiry date: ");
            String cardExpiryDate = sc.next();
            sc.nextLine();

            System.out.println("Enter your card's CVV: ");
            int CVV = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter your usertype: ");
            String usertype = sc.next();
            sc.nextLine();
            String[] lastThreeTrips = new String[3];
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter the date of the trip in YYYY-MM-DD format: ");
                String date = sc.next();
                sc.nextLine();

                System.out.println("Enter the source of that trip(for example: NJIT Gate 5, Destination Wending Square): ");
                String source = sc.nextLine();


                System.out.println("Enter the destination of that trip(for example: NJIT Gate 5, Destination Wending Square): ");
                String destination = sc.nextLine();


                System.out.println("Enter the fare that was paid by the user on that trip:");
                double fare = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter the feedback the user might have entered. It can be NULL");
                String feedback = sc.nextLine();


                StringBuilder sb = new StringBuilder();
                sb.append("Date:").append(date).append(",Source:").append(source).append(",Destination:").append(destination).append(",Fare(€):").append(fare).append(",Feedback:").append(feedback);
                lastThreeTrips[j] = sb.toString();

            }
            RegisteredUsers user = new RegisteredUsers(fullName, emailAddress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, CVV, usertype, lastThreeTrips);
            registeredUsersList.add(user);
        }

    }
    public void removeRegisteredUsers() {
        boolean flag = registeredUsersList.isEmpty();
        if (flag) {
            System.out.println("No registered users to remove");
        } else {
            System.out.println("Input the email address that must be removed:");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
            boolean ifuserFound = false;
            while (iterator.hasNext()) {
                RegisteredUsers user = iterator.next();

                if (user.getEmailAddress().equals(email)) {
                    iterator.remove();
                    ifuserFound = true;
                    System.out.println("User removed successfully!");
                }
            }
            if(!ifuserFound){
                System.out.println("No user found with this email address");
            }
        }
    }
   public void updateRegisteredUsers(){
        boolean flag = registeredUsersList.isEmpty();
        if(flag){
            System.out.println("No registered users to remove");
        }else{
            System.out.println("Input the email address of the user whose object must be updated:");
            Scanner sc=new Scanner(System.in);
            boolean found=false;
            String newemail=sc.nextLine();
            for(RegisteredUsers r:registeredUsersList){
                if(r.getEmailAddress().equals(newemail)){
                    found=true;
                    System.out.println("-------Update your details:");
                    System.out.println("Type new full name: (Press ENTER for no change): ");
                    String name = sc.nextLine();

                    if(!name.isEmpty()){
                        r.setFullName(name);
                    }

                    System.out.println("Type new emailAddress: (Press ENTER for no change): ");
                    String emailAddress = sc.nextLine();

                    if(!emailAddress.isEmpty()){
                        r.setEmailAddress(emailAddress);
                    }
                    System.out.println("Type new dateOfBirth: (Press ENTER for no change): ");
                    String dateOfBirth = sc.nextLine();

                    if(!dateOfBirth.isEmpty()){
                        r.setDateOfBirth(dateOfBirth);
                    }

                    System.out.println("Type new cardNumber: (Press 0 for no change):");
                    long cardNumber = sc.nextLong();
                    sc.nextLine();
                    if(cardNumber!=0){
                        r.setCardNumber(cardNumber);
                    }

                    System.out.println("Type new cardProvider: (Press ENTER for no change):");
                    String cardProvider = sc.nextLine();
                    if(!cardProvider.isEmpty()){
                        r.setCardProvider(cardProvider);
                    }

                    System.out.println("Type new cardExpiryDate: (Press ENTER for no change):");
                    String cardExpiryDate = sc.nextLine();
                    if(!cardExpiryDate.isEmpty()){
                        r.setCardExpiryDate(cardExpiryDate);
                    }

                    System.out.println("Type new CVV: (Press 0 for no change):");
                    int CVV = sc.nextInt();
                    sc.nextLine();
                    if(CVV!=0){
                        r.setCVV( CVV);
                    }

                    System.out.println("Type new usertype: (Press ENTER for no change):");
                    String usertype = sc.nextLine();
                    if(!usertype.isEmpty()){
                        r.setUserType(usertype);
                    }
                    System.out.println("Successfully change!");
                }
            }if(!found){
                System.out.println("No user found with this email address");
            }


        }
    }
    public void viewRegisteredUsers() {
        boolean flag = registeredUsersList.isEmpty();
        if (flag) {
            System.out.println("No registered users to display");
        } else {
            for (RegisteredUsers r : registeredUsersList) {
                System.out.println(r);
            }
        }
    }

}
