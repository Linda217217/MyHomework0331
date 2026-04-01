import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class UserRegistration {
        private static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
        private static final double VIP_DISCOUT_UNDER_18 = 20.0;
        private static final double VIP_BASE_FEE = 100.0;
        private String fullName;
        private String emailAdress;
        private String dateOfBirth;
        private long cardNumber;
        private String cardProvider;
        private int CVV;
        private String cardExpiryDate;
        private double feeToCharge;
        private String userType;
        private boolean emailValid;
        private boolean minorAndBirthday;
        private boolean minor;
        private boolean ageValid;
        private boolean cardNumberValid;
        private boolean cardStillValid;
        private boolean validCVV;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getEmailAdress() {
            return emailAdress;
        }

        public void setEmailAdress(String emailAdress) {
            this.emailAdress = emailAdress;
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

        public double getFeeToCharge() {
            return feeToCharge;
        }

        public void setFeeToCharge(double feeToCharge) {
            this.feeToCharge = feeToCharge;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public boolean isEmailValid() {
            return emailValid;
        }

        public void setEmailValid(boolean emailValid) {
            this.emailValid = emailValid;
        }

        public boolean isMinorAndBirthday() {
            return minorAndBirthday;
        }

        public void setMinorAndBirthday(boolean minorAndBirthday) {
            this.minorAndBirthday = minorAndBirthday;
        }

        public boolean isMinor() {
            return minor;
        }

        public void setMinor(boolean minor) {
            this.minor = minor;
        }

        public boolean isAgeValid() {
            return ageValid;
        }

        public void setAgeValid(boolean ageValid) {
            this.ageValid = ageValid;
        }

        public boolean isCardNumberValid() {
            return cardNumberValid;
        }

        public void setCardNumberValid(boolean cardNumberValid) {
            this.cardNumberValid = cardNumberValid;
        }

        public boolean isCardStillValid() {
            return cardStillValid;
        }

        public void setCardStillValid(boolean cardStillValid) {
            this.cardStillValid = cardStillValid;
        }

        public boolean isValidCVV() {
            return validCVV;
        }

        public void setValidCVV(boolean validCVV) {
            this.validCVV = validCVV;
        }

        public void registration() {
            System.out.println("Welcome to the ERyder Registration.");
            System.out.println("Here are your two options:");
            System.out.println("1. Register as a Regular User");
            System.out.println("2. Register as a VIP User");
            System.out.println("Please enter your choice (1 or 2):");
            Scanner sc = new Scanner(System.in);

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                setUserType("Regular User");
            } else if (choice == 2) {
                setUserType("VIP User");
            } else {
                System.out.println("wrong");

                return;
            }

            System.out.println("Please input your fullNmae: ");
            fullName = sc.nextLine();

            System.out.println("Please input your emailAdress: ");
            emailAdress = sc.nextLine();

            emailValid = analyseEmail(emailAdress);

            System.out.println("Enter your birth date in(yyyy-MM-dd):format");
            dateOfBirth = sc.nextLine();
            LocalDate dob = LocalDate.parse(dateOfBirth);
            ageValid = analyseAge(dob);

            System.out.println("Enter your cardNumber(only Visa, MasterCard, and American Express cards are accepted): ");
            cardNumber=sc.nextLong();
            sc.nextLine();
            cardNumberValid=analyseCardNumber(cardNumber);
            System.out.println("Enter your card expiry date: ");
            cardExpiryDate=sc.next();
            cardStillValid=analyseCardExpiryDate(cardExpiryDate);
            System.out.println("Enter your card's CVV: ");
            CVV=sc.nextInt();
            sc.nextLine();
            validCVV=analyseCVV(CVV);
            finalCheckpoint();
        }

        private boolean analyseEmail(String email) {
            if (email.contains("@") && email.contains(".")) {
                System.out.println("the email Address is valid");

            } else {
                System.out.println("Invalid email address. Going back to the start of the registration");
                registration();
            }
            return true;
        }

        private boolean analyseAge(LocalDate dob) {
            LocalDate end = LocalDate.now();
            int age = Period.between(dob, end).getYears();
            boolean isBirthday = true;
            if ((dob.getMonthValue() == end.getMonthValue()) && (dob.getDayOfMonth() == end.getDayOfMonth())) {
                isBirthday = true;
            } else {
                isBirthday = false;
            }
            if (userType.equals("VIP User")) {
                if (isBirthday && age <= 18 && age > 12) {
                    System.out.println("Happy Birthday! You get 25% discount on the VIP subscription fee for being born today and being under 18!");
                    minorAndBirthday = true;
                    return minorAndBirthday;
                } else if (!isBirthday && age <= 18 && age >= 12) {
                    System.out.println("You get 20% discount on the VIP subscription fee for being under 18!");
                    minor = true;
                } else if (age <= 12 || age > 120) {
                    System.out.println("Looks like you are either too young or already dead. Sorry, you can’t be our user. Have a nice day");
                    System.exit(0);
                }
            }else {

                minor = false;
                minorAndBirthday = false;

            }
            return true;
        }
        private boolean analyseCardNumber(long cardNumber){
            String cardNumStr=String.valueOf(cardNumber);
            int firstTwoDigits=0;
            if(cardNumStr.length()>2) {
                firstTwoDigits=Integer.parseInt(cardNumStr.substring(0, 2));
            }
            int firstFourDigits=0;
            if(cardNumStr.length()>4){
                firstFourDigits= Integer.parseInt(cardNumStr.substring(0,4));
            }
            if((cardNumStr.length()==13||cardNumStr.length()==15)&&(cardNumStr.startsWith("4"))){
                cardProvider="VISA";
            }else if((cardNumStr.length()==16)&&((firstTwoDigits>=51&&firstTwoDigits<=55)||firstFourDigits>=2221&&firstFourDigits<=2720)){
                cardProvider="MasterCard";
            }else if((cardNumStr.length()==15)&&(cardNumStr.startsWith("34")||cardNumStr.startsWith("37"))){
                cardProvider="American Express";
            }else{
                System.out.println("Sorry, but we accept only VISA, MasterCard, or American Express cards. Please try again with a valid card. Going back to the start of the registration.");
                registration();
            }

            return true;
        }
        private boolean analyseCardExpiryDate(String cardExpiryDate){
            int month=0;
            month=Integer.parseInt(cardExpiryDate.substring(0,2))  ;
            int year=Integer.parseInt(cardExpiryDate.substring(2,4))  ;
            year=year+2000;
            LocalDate currentDate=LocalDate.now();
            int currentYear=currentDate.getYear();
            int currentMonth=currentDate.getMonthValue();
            if((year>currentYear||year==currentYear)&&(month>=currentMonth)){
                System.out.println("The card is still valid");
            }else{
                System.out.println("Sorry, your card has expired. Please use a different card.");
                System.out.println("Going back to the start of the registration process…");
                registration();
            }
            return true;
        }
        private boolean analyseCVV(int CVV){
            String cvvStr=Integer.toString(CVV);
            if((cardProvider.equals("American Express")&&cvvStr.length()==4)||(cardProvider.equals("VISA")&&cvvStr.length()==3)||(cardProvider.equals("MasterCard")&&cvvStr.length()==3)){
                System.out.println("Card CVV is valid.");
            }else{
                System.out.println("Invalid CVV for the given card.");
                System.out.println("Going back to the start of the registration process.");
                registration();
            }
            return true;
        }
        private void finalCheckpoint(){
            if(emailValid&&ageValid&&cardNumberValid&&cardStillValid&&validCVV){
                chargeFees();
            }else{
                System.out.println("Sorry, your registration was unsuccessful due to the following reason(s)");
                if(!emailValid){
                    System.out.println(" Invalid email address");
                }
                if(!ageValid){
                    System.out.println(" Invalid age");
                }
                if(!cardNumberValid){
                    System.out.println(" Invalid card number");
                }
                if(!cardStillValid){
                    System.out.println(" Card has expired");
                }
                if(!validCVV){
                    System.out.println(" Invalid CVV");
                }
                System.out.println("Going back to the start of the registration process.");
                registration();
            }
        }
        private void chargeFees(){
            if(minorAndBirthday){
                feeToCharge=VIP_BASE_FEE*0.75;
            }
            else if(minor){
                feeToCharge=VIP_BASE_FEE*0.8;
            }else{
                feeToCharge=VIP_BASE_FEE;
            }
            System.out.println("Thank you for your payment.");
            String cardnumberstr=String.valueOf(cardNumber);
            System.out.println("A fee of "+feeToCharge+" has been charged to your card ending with "+cardnumberstr.substring(cardnumberstr.length()-4));
            System.out.println(this);

        }
        @Override
        public String toString(){
            String cardNumberStr=String.valueOf(cardNumber);
            String censoredPart="";
            cardNumberStr.substring(0,cardNumberStr.length()-4).replaceAll(".","*");
            String lastFourDigits=cardNumberStr.substring(cardNumberStr.length()-4);
            String censoredNumber=censoredPart+lastFourDigits;
            return "Registration successful! Here are your details:\n"+"User Type:"+userType+"\n"
                    +"Full Name:"+fullName+"\n"+"Email Address:"+emailAdress+"\n"
                    +"Date of Birth:"+dateOfBirth+"\n"+"Card Number:"+censoredNumber+"\n"
                    +"Card Provider:"+cardProvider+"\n"+"Card Expiry Date:"+cardExpiryDate;
        }
    }

