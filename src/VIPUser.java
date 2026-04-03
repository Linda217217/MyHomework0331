public class VIPUser extends RegisteredUsers{
    public VIPUser() {
    }

    public VIPUser(String fullName, String emailAdress, String dateOfBirth, long cardNumber, String cardProvider, String cardExpiryDate, int CVV, String userType, String[] lastThreeTrips) {
        super(fullName, emailAdress, dateOfBirth, cardNumber, cardProvider, cardExpiryDate, CVV, userType, lastThreeTrips);
    }

    @Override
    public double calculateFare(double baseFare){
       return  baseFare*0.8;
    }

    @Override
    public void displayUserType() {
        System.out.println("VIP User");
    }
}
