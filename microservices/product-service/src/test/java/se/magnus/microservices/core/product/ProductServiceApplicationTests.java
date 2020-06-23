package se.magnus.microservices.core.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceApplicationTests {


	@Autowired
	public WebTestClient restClientTest;

	@Test
	public void contextLoads() {
		int teacherId = 1;
		restClientTest.get().uri("/product"+teacherId).accept(MediaType.APPLICATION_JSON_UTF8)
				.exchange().expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8).expectBody().jsonPath("$teacherId").isEqualTo(teacherId);
	}

}
