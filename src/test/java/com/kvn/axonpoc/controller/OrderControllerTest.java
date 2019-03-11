/**
 * 
 */
package com.kvn.axonpoc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kvn.axonpoc.AxonSpringbootPocApplication;

/**
 * @author prabhu
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AxonSpringbootPocApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class OrderControllerTest {

	@Autowired
	MockMvc mockMvc;
	JacksonTester<PlaceOrderRequest> jacksonTester;
	@Autowired private ObjectMapper objectMapper;
	@Before
    public void setup() {
        JacksonTester.initFields(this, objectMapper);
       
    }
	/**
	 * Test method for
	 * {@link com.kvn.axonpoc.controller.OrderController#placeOrder(com.kvn.axonpoc.controller.PlaceOrderRequest)}.
	 */
	@Test
	public void testPlaceOrder() {
		
		for(int i=0;i<100;i++) {

		UUID uuid = UUID.randomUUID();
		PlaceOrderRequest request = new PlaceOrderRequest();
		request.setOrderId(uuid.toString());
		request.setProductId("Product:" + uuid.toString());
		request.setStatus("Initial");
		try {
			String req = jacksonTester.write(request).getJson();
			mockMvc.perform(post("/orders/create").content(req).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isCreated());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}

}
