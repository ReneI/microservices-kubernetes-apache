package se.magnus.api.core.review;

public class Review {
    private int Teacher;
    private int ReviewId;
    private String comment;
    private double speaking;
    private double grammar;
    private String feedback;
    private final String author;
    private String serviceAddress;


    public Review(){
        comment = null;
        author = null;
        serviceAddress = "";

    }

    public Review(int teacher, int reviewId, String comment, double speaking, double grammar, String feedback, String author) {
        Teacher = teacher;
        ReviewId = reviewId;
        this.comment = comment;
        this.speaking = speaking;
        this.grammar = grammar;
        this.feedback = feedback;
        this.author = author;
        this.serviceAddress = serviceAddress;
    }

    public int getTeacher() {
        return Teacher;
    }

    public void setTeacher(int teacher) {
        Teacher = teacher;
    }

    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getSpeaking() {
        return speaking;
    }

    public void setSpeaking(double speaking) {
        this.speaking = speaking;
    }

    public double getGrammar() {
        return grammar;
    }

    public void setGrammar(double grammar) {
        this.grammar = grammar;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getAuthor() {
        return author;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
