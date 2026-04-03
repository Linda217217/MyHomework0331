public class RegularUser extends RegisteredUsers {
    public RegularUser() {
    }

    public RegularUser(String fullName, String emailAdress, String dateOfBirth, long cardNumber, String cardProvider, String cardExpiryDate, int CVV, String userType, String[] lastThreeTrips) {
        super(fullName, emailAdress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, CVV, userType, lastThreeTrips);
    }

    @Override
    public double calculateFare(double baseFare) {
             return baseFare;
    }
    @Override
    public void displayUserType(){
        System.out.println("Regular User");
    }
}
