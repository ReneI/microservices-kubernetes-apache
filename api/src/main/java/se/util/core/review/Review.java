package se.util.core.review;

public class Review {
    private int Teacher;
    private int ReviewId;
    private String comment;
    private double speaking;
    private double grammar;
    private double feedback;
    private final String author;


    public Review(){
        comment = null;
        author = null;

    }

    public Review(int teacher, int reviewId, String comment, double speaking, double grammar, double feedback, String author) {
        Teacher = teacher;
        ReviewId = reviewId;
        this.comment = comment;
        this.speaking = speaking;
        this.grammar = grammar;
        this.feedback = feedback;
        this.author = author;
    }
}
