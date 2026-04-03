
    import java.util.Arrays;

    public abstract class RegisteredUsers {
        private String fullName;
        private String emailAddress;
        private String dateOfBirth;
        private long cardNumber;
        private String cardProvider;
        private String  cardExpiryDate;
        private int CVV;
        private String userType;
        private String[] lastThreeTrips;

        public RegisteredUsers() {
            this.lastThreeTrips=new String[3];
        }

        public RegisteredUsers(String fullName, String emailAdress, String dateOfBirth, long cardNumber, String cardProvider, String cardExpiryDate, int CVV, String userType, String[] lastThreeTrips) {
            this.fullName = fullName;
            this.emailAddress = emailAdress;
            this.dateOfBirth = dateOfBirth;
            this.cardNumber = cardNumber;
            this.cardProvider = cardProvider;
            this.cardExpiryDate = cardExpiryDate;
            this.CVV = CVV;
            this.userType = userType;
            this.lastThreeTrips = lastThreeTrips;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public long getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(long cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getCardProvider() {
            return cardProvider;
        }

        public void setCardProvider(String cardProvider) {
            this.cardProvider = cardProvider;
        }

        public String getCardExpiryDate() {
            return cardExpiryDate;
        }

        public void setCardExpiryDate(String cardExpiryDate) {
            this.cardExpiryDate = cardExpiryDate;
        }

        public int getCVV() {
            return CVV;
        }

        public void setCVV(int CVV) {
            this.CVV = CVV;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String[] getLastThreeTrips() {
            return lastThreeTrips;
        }

        public void setLastThreeTrips(String[] lastThreeTrips) {
            this.lastThreeTrips = lastThreeTrips;
        }
public abstract double calculateFare(double baseFare);
        public abstract void  displayUserType();
        @Override
        public String toString() {
            return "RegisteredUsers{" +
                    "fullName='" + fullName + '\'' +
                    ", emailAdress='" + emailAddress + '\'' +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    ", cardNumber=" + cardNumber +
                    ", cardProvider='" + cardProvider + '\'' +
                    ", cardExpiryDate='" + cardExpiryDate + '\'' +
                    ", CVV=" + CVV +
                    ", userType='" + userType + '\'' +
                    ", lastThreeTrips=" + Arrays.toString(lastThreeTrips) +
                    '}';
        }
    }

