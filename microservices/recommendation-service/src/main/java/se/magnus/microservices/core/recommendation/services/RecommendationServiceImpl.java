package se.magnus.microservices.core.recommendation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import se.magnus.api.core.recommended.Recommend;
import se.magnus.api.core.recommended.RecommendationService;
import se.magnus.util.exception.InvalidInputException;
import se.magnus.util.exception.NotFoundException;
import se.magnus.util.http.ServiceUtil;

import java.util.ArrayList;
import java.util.List;

public class RecommendationServiceImpl implements RecommendationService {


    private static final Logger LOG = LoggerFactory.getLogger(RecommendationServiceImpl.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public RecommendationServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }
        @Override
    public List<Recommend> getAllR(int teacherId) {


        LOG.debug("/teacher's  return the found product for productId={}", teacherId);

        if (teacherId < 1) throw new InvalidInputException("Invalid productId: " + teacherId);

        if (teacherId == 13) throw new NotFoundException("No product found for productId: " + teacherId);

            List<Recommend>list = new ArrayList<>();
            list.add(new Recommend("dd","33",serviceUtil.getServiceAddress()));

        return  list;




    }
}
