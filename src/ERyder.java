public class ERyder {

        private String bikeID;
        private int batteryLevel;
        private boolean isAvailable;
        private double kmDriven;
        private static final String  COMPANY_NAME="ERyder";
        private static final double BASE_FARE=1.0;
        private static final double PER_MINUTE_FARE =0.5;
        private final String  LINKED_ACCOUNT;
        private final String  LINKED_PHONE_NUMBER;

        private double totalFare;
        private double totalUsageInMinutes ;
        public ERyder(String bikeID,int batteryLevel,boolean isAvailable,double kmDriven){
            this.LINKED_ACCOUNT = "Amy@111";
            this.LINKED_PHONE_NUMBER = "12345678";
            this.bikeID=bikeID;
            this.batteryLevel=batteryLevel;
            this. isAvailable=isAvailable;
            this.kmDriven=kmDriven;
            this.totalUsageInMinutes=0.0;
        }
        public ERyder(String bikeID,int batteryLevel,boolean isAvailable,double kmDriven,String LINKED_ACCOUNT,String LINKED_PHONE_NUMBER,double totalUsageInMinutes){
            this.bikeID=bikeID;
            this.batteryLevel=batteryLevel;
            this.isAvailable=isAvailable;
            this.kmDriven=kmDriven;
            this.LINKED_PHONE_NUMBER=LINKED_PHONE_NUMBER;
            this.LINKED_ACCOUNT=LINKED_ACCOUNT;
            this.totalUsageInMinutes=totalUsageInMinutes;


        }
        public void ride(){
            if(batteryLevel>0&&batteryLevel<=100&&isAvailable){
                System.out.println("The bike is available.");
            }else{
                System.out.println("The bike is not available");
            }
        }
        public void printBikeDetails(){
            System.out.println("bikeID: "+bikeID);
            System.out.println("batteryLevel: "+batteryLevel+"%");
            System.out.println("isAvailable: "+isAvailable);
            System.out.println("kmDriven: "+kmDriven+"km");
        }
        public void printRideDetails(double usageInMinutes ){
            double totalFare=calculateFare(usageInMinutes );
            System.out.println("your LINKED_ACCOUNT is "+LINKED_ACCOUNT);
            System.out.println("your LINKED_PHONE_NUMBER is "+LINKED_PHONE_NUMBER);
            System.out.println("your bikeID is "+bikeID);
            System.out.println("your usageMinutes "+totalUsageInMinutes );
            System.out.println("your totalFare is "+totalFare+" yuan");
        }
        private double calculateFare(double usageInMinutes ){
            totalFare=BASE_FARE+(PER_MINUTE_FARE*usageInMinutes );
            return totalFare;
        }

        public String getBikeID() {
            return bikeID;
        }

        public void setBikeID(String bikeID) {
            this.bikeID = bikeID;
        }

        public int getBatteryLevel() {
            return batteryLevel;
        }

        public void setBatteryLevel(int batteryLevel) {
            if(batteryLevel>=0&&batteryLevel<=100) {
                this.batteryLevel = batteryLevel;
            }else{
                System.out.println("Error");
            }
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            this.isAvailable = available;
        }

        public double getKmDriven() {
            return kmDriven;
        }

        public void setKmDriven(double kmDriven) {
            this.kmDriven = kmDriven;
        }

        public static void main(String[] args ){
            ERyder eryder1=new ERyder("001",60,true,126.8);
            eryder1.ride();
            eryder1.printBikeDetails();
            eryder1.printRideDetails(15);
            ERyder eryder2=new ERyder("002",25,false,12.3,"Bob@111","123456",15);
            eryder2.printBikeDetails();
            eryder2.printRideDetails(13);

        }
    }

