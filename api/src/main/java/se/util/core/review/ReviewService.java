package se.util.core.review;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.util.core.recommended.Recommend;

import java.util.List;

public interface ReviewService {

    @GetMapping(value ="/review",produces = "application/json")
    List<Recommend> getReview(@RequestParam(value = "teacher" ,required = true) int teacher);

}
