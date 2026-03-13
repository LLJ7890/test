package homework;

public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void analyseFeedback(boolean isConcatenation,
                                String sent1, String sent2, String sent3,
                                String sent4, String sent5) {

        if (isConcatenation = true) {
            this.completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        } else {
            this.completeFeedback = feedbackUsingStringBuilder(sent1, sent2, sent3, sent4, sent5).toString();
        }

        this.longFeedback = checkFeedbackLength(this.completeFeedback);
        createReviewID(firstName, lastName, completeFeedback);
    }
    public String feedbackUsingConcatenation(String sent1,String sent2,String sent3,String  sent4,String sent5)
    {
        String concatenatedFeedback="";

        concatenatedFeedback+=sent1;
        concatenatedFeedback+=sent2;
        concatenatedFeedback+=sent3;
        concatenatedFeedback+=sent4;
        concatenatedFeedback+=sent5;

        return concatenatedFeedback;
    }

    public String feedbackUsingStringBuilder(String sent1,String sent2,String sent3,String  sent4,String sent5)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(sent1).append(" ")
                .append(sent2).append(" ")
                .append(sent3).append(" ")
                .append(sent4).append(" ")
                .append(sent5);
        return sb.toString();
    }
    private boolean checkFeedbackLength(String feedback) {
        this.longFeedback = completeFeedback.length() > 500;
        return feedback.length() > 500;
    }
    private void createReviewID(String fName, String lName, String feedback) {
        String fullName = fName + lName;
        String namePart = fullName.length() >= 6 ?
                fullName.substring(2, 6).toUpperCase() :
                fullName.toUpperCase();

        String feedbackPart = feedback.length() >= 15 ?
                feedback.substring(10, 15).toLowerCase() :
                feedback.toLowerCase();

        String lengthMeta = "_" + feedback.length();
        String timeStamp = "_" + System.currentTimeMillis();

        reviewID = (namePart + feedbackPart + lengthMeta + timeStamp).replace(" ", "");
    }

    public String toString() {
        return "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Complete Feedback: " + completeFeedback + "\n" +
                "Long Feedback: " + longFeedback + "\n" +
                "Review ID: " + reviewID;
    }
}

