
    import java.util.Locale;

    public class Feedback {
        private String firstName;
        private String lastName;
        private String email;
        private String completeFeedback;
        private String reviewID;
        private boolean longFeedback;
        public Feedback(){}
        public Feedback(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getUsername() {
            return firstName;
        }

        public void setUsername(String username) {
            this.firstName = username;
        }

        public String getLastname() {
            return lastName;
        }

        public void setLastname(String lastname) {
            this.lastName = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCompleteFeedback() {
            return completeFeedback;
        }

        public void setCompleteFeedback(String completeFeedback) {
            this.completeFeedback = completeFeedback;
        }

        public String getReviewID() {
            return reviewID;
        }

        public void setReviewID(String reviewID) {
            this.reviewID = reviewID;
        }

        public boolean getLongFeedback() {
            return longFeedback;
        }

        public void setLongFeedback(boolean longFeedback) {
            this.longFeedback = longFeedback;
        }
        public void analyseFeedback( boolean isConcatenation,String  sent1,String  sent2,String  sent3,String  sent4,String sent5){
            if(isConcatenation){
                completeFeedback=  feedbackUsingConcatenation(sent1,sent2,sent3,sent4,sent5);
                checkFeedbackLength( completeFeedback);
                createReviewID(firstName,lastName,completeFeedback);
            }else{

                StringBuilder sb =feedbackUsingStringBuilder(sent1,sent2,sent3,sent4,sent5) ;
                completeFeedback=sb.toString();
                checkFeedbackLength(completeFeedback);
                createReviewID(firstName,lastName,completeFeedback);
            }
        }
        private String feedbackUsingConcatenation(String sent1,String sent2,String sent3,String sent4,String sent5){
            String concatenatedFeedback;
            concatenatedFeedback=sent1+sent2+sent3+sent4+sent5;
            return concatenatedFeedback;
        }
        private StringBuilder feedbackUsingStringBuilder(String sent1,String sent2,String sent3,String sent4,String sent5){
            StringBuilder sb=new StringBuilder();
            sb.append(sent1).append(" ").append(sent2).append(sent3).append(sent4).append(sent5);
            return sb;
        }
        private boolean checkFeedbackLength(String completeFeedback){

            if(completeFeedback.length()>500){
                longFeedback=true;
                return longFeedback;
            }else{
                longFeedback=false;
                return longFeedback;
            }

        }
        private void createReviewID(String firstName,String lastName,String completeFeedback){
            reviewID=((firstName+lastName).substring(2,6).toUpperCase()+completeFeedback.substring(10,15).toLowerCase()+completeFeedback.length()+"_"+ System.currentTimeMillis()).replace(" ","");

        }
        @Override
        public String toString(){
            return "Feedback :\n"+"firstName: "+firstName+"\n"+
                    "lastName: "+lastName+"\n"+"Email: "+email+
                    "\n"+"Complete Feedback: "+completeFeedback+"\n"+
                    "if is long Feedback: "+longFeedback+"\n"+"Review id: "+reviewID;
        }

}
