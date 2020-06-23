package se.magnus.api.composite;

public class ReviewSummary {


    private final int reviewId;
    private final int teacher;
    private final String author;
    private final String subject;

    public ReviewSummary(int reviewId, int teacher, String author, String subject) {
        this.reviewId = reviewId;
        this.teacher = teacher;
        this.author = author;
        this.subject = subject;
    }

    public int getReviewId() {
        return reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }





}
