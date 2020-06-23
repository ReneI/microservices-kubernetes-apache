package se.magnus.microservices.composite.product;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import se.magnus.api.core.recommended.Recommend;
import se.magnus.api.core.review.Review;
import se.magnus.api.core.teachers.Teacher;
import se.magnus.microservices.composite.product.Services.ProductCompositeIntegration;

import java.util.Collections;

import static org.mockito.Mockito.when;

;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCompositeServiceApplicationTest {

	private static final int PRODUCT_ID_OK=1;

	@Autowired
	private WebTestClient client;

	@MockBean
	private ProductCompositeIntegration compositeIntegration;

	@Before
	public void setup(){
		when(compositeIntegration.getTeacher(PRODUCT_ID_OK))

				.thenReturn(new Teacher(PRODUCT_ID_OK, "EXTREME","http://www.google.com","Maria","Nativa americana",   "mock-address"));

		when(compositeIntegration.getRecommendations(PRODUCT_ID_OK))
				.thenReturn(Collections.singletonList(new Recommend(PRODUCT_ID_OK,
						1, "author", "content", "mock address")));

		when(compositeIntegration.getReview(PRODUCT_ID_OK))
				.thenReturn(Collections.singletonList(new Review(PRODUCT_ID_OK,
						1, "Excelent",4.5,4.1,"Nothing","mock address")));




	}



	@Test
	public void getProductById(){

		client.get()
				.uri("/product-composite/" + PRODUCT_ID_OK)
				.accept(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
				.expectBody()
				.jsonPath("$.productId").isEqualTo(PRODUCT_ID_OK)
				.jsonPath("$.recommendations.length()").isEqualTo(1)
				.jsonPath("$.reviews.length()").isEqualTo(1);
	}



}
