package se.magnus.api.composite;

import java.util.List;

public class TeacherAggregate {

    private final int teacher;
    private List<RecommendationSummary>recommends;
    private List<ReviewSummary>reviews;

    private final ServiceAddresse serviceAddresse;

    public TeacherAggregate(int teacher, List<RecommendationSummary> recommends, List<ReviewSummary> reviews, ServiceAddresse serviceAddresse) {
        this.teacher = teacher;
        this.recommends = recommends;
        this.reviews = reviews;
        this.serviceAddresse = serviceAddresse;
    }

    public int getTeacher() {
        return teacher;
    }

    public List<RecommendationSummary> getRecommends() {
        return recommends;
    }

    public void setRecommends(List<RecommendationSummary> recommends) {
        this.recommends = recommends;
    }

    public List<ReviewSummary> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewSummary> reviews) {
        this.reviews = reviews;
    }

    public ServiceAddresse getServiceAddress() {
        return serviceAddresse;
    }
}
