package se.magnus.api.core.recommended;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RecommendationService {
    @GetMapping(value ="/recommendation",produces = "application/json")
    List<Recommend>getRecommendations(@RequestParam (value = "teacher" ,required = true) int teacher);
}
























