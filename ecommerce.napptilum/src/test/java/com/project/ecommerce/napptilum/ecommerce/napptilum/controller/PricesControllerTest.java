package com.project.ecommerce.napptilum.ecommerce.napptilum.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.project.ecommerce.napptilum.ecommerce.napptilum.model.PricesDto;
import com.project.ecommerce.napptilum.ecommerce.napptilum.model.RateProductRequest;

/**
 * PricesControllerTest
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricesControllerTest {

	@LocalServerPort
	private int port;
	
	private String url = "http://localhost";
	
	private static RestTemplate restTemplate = null;
	
	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}
	
	@BeforeEach
	public void setUp() {
		url = url.concat(":").concat(port+"").concat("/api/prices/applyPrice");
	}
	
	@Test
	public void caseTest1() {
		RateProductRequest request = new RateProductRequest();
		request.setDateRequest("2020-06-14 10:00:00");
		request.setProductId(35455);
		request.setBrandId(1);
		PricesDto response = restTemplate.postForObject(url, request,PricesDto.class);
		assertEquals(response.getPriceList(), 1);
		assertEquals(response.getStartDate(), "2020-06-14 00:00:00");
		assertEquals(response.getBrandId(), 1);
		assertEquals(response.getEndDate(), "2020-12-31 23:59:59");
		assertEquals(response.getPrice(), BigDecimal.valueOf(35.50).setScale(2));
		assertEquals(response.getProductId(), 35455);
	}
	
	@Test
	public void caseTest2() {
		RateProductRequest request = new RateProductRequest();
		request.setDateRequest("2020-06-14 16:00:00");
		request.setProductId(35455);
		request.setBrandId(1);
		PricesDto response = restTemplate.postForObject(url, request,PricesDto.class);
		assertEquals(response.getPriceList(), 2);
		assertEquals(response.getStartDate(), "2020-06-14 15:00:00");
		assertEquals(response.getBrandId(), 1);
		assertEquals(response.getEndDate(), "2020-06-14 18:30:00");
		assertEquals(response.getPrice(), BigDecimal.valueOf(25.45).setScale(2));
		assertEquals(response.getProductId(), 35455);
	}
	
	@Test
	public void caseTest3() {
		RateProductRequest request = new RateProductRequest();
		request.setDateRequest("2020-06-14 21:00:00");
		request.setProductId(35455);
		request.setBrandId(1);
		PricesDto response = restTemplate.postForObject(url, request,PricesDto.class);
		assertEquals(response.getPriceList(), 1);
		assertEquals(response.getStartDate(), "2020-06-14 00:00:00");
		assertEquals(response.getBrandId(), 1);
		assertEquals(response.getEndDate(), "2020-12-31 23:59:59");
		assertEquals(response.getPrice(), BigDecimal.valueOf(35.50).setScale(2));
		assertEquals(response.getProductId(), 35455);

	}
	
	@Test
	public void caseTest4() {
		RateProductRequest request = new RateProductRequest();
		request.setDateRequest("2020-06-16 21:00:00");
		request.setProductId(35455);
		request.setBrandId(1);
		PricesDto response = restTemplate.postForObject(url, request,PricesDto.class);
		assertEquals(response.getPriceList(), 4);
		assertEquals(response.getStartDate(), "2020-06-15 16:00:00");
		assertEquals(response.getBrandId(), 1);
		assertEquals(response.getEndDate(), "2020-12-31 23:59:59");
		assertEquals(response.getPrice(), BigDecimal.valueOf(38.95).setScale(2));
		assertEquals(response.getProductId(), 35455);
	}
	
	@Test
	public void caseTest5() {
		RateProductRequest request = new RateProductRequest();
		request.setDateRequest("2020-06-15 00:00:00");
		request.setProductId(35455);
		request.setBrandId(1);
		PricesDto response = restTemplate.postForObject(url, request,PricesDto.class);
		assertEquals(response.getPriceList(), 3);
		assertEquals(response.getStartDate(), "2020-06-15 00:00:00");
		assertEquals(response.getBrandId(), 1);
		assertEquals(response.getEndDate(), "2020-06-15 11:00:00");
		assertEquals(response.getPrice(), BigDecimal.valueOf(30.50).setScale(2));
		assertEquals(response.getProductId(), 35455);
	}
}
