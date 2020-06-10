package se.util.composite;

import se.util.core.recommended.Recommend;
import se.util.core.review.Review;

import java.util.List;

public class TeacherAggregate {

    private final int teacher;
    private List<Recommend>recommends;
    private List<Review>reviews;

    private final ServiceAddress serviceAddress;

    public TeacherAggregate(int teacher, List<Recommend> recommends, List<Review> reviews, ServiceAddress serviceAddress) {
        this.teacher = teacher;
        this.recommends = recommends;
        this.reviews = reviews;
        this.serviceAddress = serviceAddress;
    }

    public int getTeacher() {
        return teacher;
    }

    public List<Recommend> getRecommends() {
        return recommends;
    }

    public void setRecommends(List<Recommend> recommends) {
        this.recommends = recommends;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public ServiceAddress getServiceAddress() {
        return serviceAddress;
    }
}
