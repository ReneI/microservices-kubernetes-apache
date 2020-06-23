package se.magnus.microservices.core.product.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.teachers.Teacher;
import se.magnus.api.core.teachers.TeacherService;
import se.magnus.util.exception.InvalidInputException;
import se.magnus.util.exception.NotFoundException;
import se.magnus.util.http.ServiceUtil;

;
;

@RestController
public class ProductServiceImpl implements TeacherService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	private final ServiceUtil serviceUtil;

	@Autowired
	public ProductServiceImpl(ServiceUtil serviceUtil){
		this.serviceUtil = serviceUtil;
	}

	@Override
	public Teacher getTeacher(int teacherId) {
		LOG.debug("/product return the found product for productId={}", teacherId);

		if (teacherId < 1) throw new InvalidInputException("Invalid productId: " + teacherId);

		if (teacherId == 13) throw new NotFoundException("No product found for productId: " + teacherId);
		return new Teacher(teacherId, "name-"+teacherId, "ada",
                name, serviceUtil.getServiceAddress());
	}
}
