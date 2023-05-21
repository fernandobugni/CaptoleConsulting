package com.example.CaptoleConsulting;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = CaptoleConsultingApplication.class)
@AutoConfigureMockMvc
class CaptoleConsultingApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void petitionAt10hsThe14thJune() throws Exception {
		testMethodGetPriceAtThisMoment("1", "35455",  LocalDateTime.of(2020, 06, 14, 10, 0, 0), "35.5");
	}

	@Test
	void petitionAt16hsThe14thJune() throws Exception {
		testMethodGetPriceAtThisMoment("1", "35455",  LocalDateTime.of(2020, 06, 14, 16, 0, 0), "25.45");
	}

	@Test
	void petitionAt21hsThe14thJune() throws Exception {
		testMethodGetPriceAtThisMoment("1", "35455",  LocalDateTime.of(2020, 06, 14, 21, 0, 0), "35.5");
	}

	@Test
	void petitionAt10hsThe15thJune() throws Exception {
		testMethodGetPriceAtThisMoment("1", "35455",  LocalDateTime.of(2020, 06, 15, 10, 0, 0), "30.5");
	}

	@Test
	void petitionAt21hsThe16thJune() throws Exception {
		testMethodGetPriceAtThisMoment("1", "35455",  LocalDateTime.of(2020, 06, 16, 21, 0, 0), "38.95");
	}

	private void testMethodGetPriceAtThisMoment(String brand_id, String product_id, LocalDateTime datetime, String expected_price) throws Exception{

		String datetimestr = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(datetime);

		mvc.perform(get("/getPriceAtThisMoment/brand/{brand_id}/product/{product_id}?localDateTime={datetimestr}", brand_id, product_id, datetimestr)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.price").value(expected_price));
	}

	@Test
	void petitionNoElement() throws Exception {
		mvc.perform(get("/getPriceAtThisMoment/brand/1/product/35456?localDateTime=2025-06-14T10:00:00")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isConflict())
				.andExpect(content().string("Some elements are not present"));
	}

	@Test
	void petitionEmpty() throws Exception {
		mvc.perform(get("/getPriceAtThisMoment/brand/1/product/35455?localDateTime=2025-06-14T10:00:00")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("{}"));
	}
}
