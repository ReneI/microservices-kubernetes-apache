package se.magnus.microservices.composite.product.Services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import se.magnus.api.core.recommended.Recommend;
import se.magnus.api.core.recommended.RecommendationService;
import se.magnus.api.core.review.Review;
import se.magnus.api.core.review.ReviewService;
import se.magnus.api.core.teachers.Teacher;
import se.magnus.api.core.teachers.TeacherService;
import se.magnus.util.exception.InvalidInputException;
import se.magnus.util.exception.NotFoundException;
import se.magnus.util.http.HttpErrorInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Component
public class ProductCompositeIntegration implements ReviewService, TeacherService,RecommendationService {

    private final Logger LOG = LoggerFactory.getLogger(ProductCompositeIntegration.class);
    private final String teacherServiceurl;
    private final String reviewServiceUrl;
    private ObjectMapper objectMapper;
    RestTemplate restTemplate;
    @Autowired
    public ProductCompositeIntegration(RestTemplate restTemplate, @Value("${app.product-service.host}") String teacherServiceHost, @Value("${app.product-service.port}")  String teacherServicePort,
                                       @Value("${app.product-review.host}") String teacherReviewHost, @Value("${app.product-review.port}")  String teacherReviewPort

                                       ) {
    this.restTemplate = restTemplate;
        teacherServiceurl = "http://" + teacherServiceHost +":"+ teacherServicePort;
        reviewServiceUrl = "http://" +teacherReviewHost + ":"+ teacherReviewPort;

    }

    @Override
    public List<Recommend> getRecommendations(int teacher) {

return null;

    }

    @Override
    public Teacher getTeacher(int teacherId) {

        try {
            String url = teacherServiceurl + teacherId;
            Teacher teacher = restTemplate.getForObject(url, Teacher.class);
            return teacher;
        } catch (HttpClientErrorException ex) {
            switch (ex.getStatusCode()) {
                case NOT_FOUND:
                    throw new NotFoundException(ex.getMessage());

                case UNPROCESSABLE_ENTITY:
                    throw new InvalidInputException(ex.getMessage());

                default:
                    LOG.warn("ERROR");
                    throw ex;

            }
        }

    }

    public String error(HttpClientErrorException error){

    try {
       return objectMapper.readValue(error.getResponseBodyAsString(), HttpErrorInfo.class).getMessage();
    }catch (JsonParseException e) {
      return   e.getMessage();
    } catch (JsonMappingException e) {
       return e.getMessage();
    } catch (IOException e) {
       return e.getMessage();
    }

    }


    @Override
    public List<Review> getReview(int productId) {

        try {
            String url = reviewServiceUrl + productId;

            LOG.debug("Will call getReviews API on URL: {}", url);
            List<Review> reviews = restTemplate.exchange(url, GET, null, new ParameterizedTypeReference<List<Review>>() {}).getBody();

            LOG.debug("Found {} reviews for a product with id: {}", reviews.size(), productId);
            return reviews;

        } catch (Exception ex) {
            LOG.warn("Got an exception while requesting reviews, return zero reviews: {}", ex.getMessage());
            return new ArrayList<>();
        }
    }


}
