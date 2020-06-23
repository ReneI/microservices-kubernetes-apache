package se.magnus.microservices.composite.product.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.composite.*;
import se.magnus.api.core.recommended.Recommend;
import se.magnus.api.core.review.Review;
import se.magnus.api.core.teachers.Teacher;
import se.magnus.util.exception.NotFoundException;
import se.magnus.util.http.ServiceUtil;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductCompositeServiceImpl implements TeacherCompositeService {

    private final ServiceUtil serviceUtil;

    private ProductCompositeIntegration integration;

    @Autowired
    public ProductCompositeServiceImpl(ServiceUtil serviceUtil,
                                       ProductCompositeIntegration productCompositeIntegration){
        this.serviceUtil = serviceUtil;
        this.integration = productCompositeIntegration;
    }


    private TeacherAggregate createProductAggregate(Teacher product, List<Recommend> recommendations, List<Review> reviews, String serviceAddress) {

        int productId = product.getId();
        String rate = product.getQuality();
        String imgs = product.getPicture();
        String name = product.getName();


        List<RecommendationSummary> recommendationSummaries = (recommendations == null) ? null :
                recommendations.stream()
                        .map(r -> new RecommendationSummary(r.getTeacherId(), r.getRegion(), r.getRating()))
                        .collect(Collectors.toList());

        List<ReviewSummary> reviewSummaries = (reviews == null)  ? null :
                reviews.stream()
                        .map(r -> new ReviewSummary(r.getReviewId(), r.getTeacher(), r.getAuthor(), r.getComment()))
                        .collect(Collectors.toList());

        String productAddress = product.getServiceAddress();
        String reviewAddress = (reviews != null && reviews.size() > 0) ? reviews.get(0).getServiceAddress() : "";
        String recommendationAddress = (recommendations != null && recommendations.size() > 0) ? recommendations.get(0).getServiceAddress() : "";
        ServiceAddresse serviceAddresses = new ServiceAddresse(serviceAddress, productAddress, reviewAddress, recommendationAddress);
        return new TeacherAggregate(productId,  recommendationSummaries, reviewSummaries, serviceAddresses);
    }

    @Override
    public TeacherAggregate get(int teacherId) {



        Teacher product = integration.getTeacher(teacherId);
        if(product == null) throw new NotFoundException("No product found for product id: "+ teacherId);




        List<Recommend> recommendations = integration.getRecommendations(teacherId);

        List<Review> reviews = integration.getReview(teacherId);


        return createProductAggregate(product, recommendations, reviews, serviceUtil.getServiceAddress());

    }
}