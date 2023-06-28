package com.project.ecommerce.napptilum.ecommerce.napptilum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.napptilum.ecommerce.napptilum.model.PricesDto;
import com.project.ecommerce.napptilum.ecommerce.napptilum.model.RateProductRequest;
import com.project.ecommerce.napptilum.ecommerce.napptilum.service.PricesService;

@RestController
@RequestMapping(value = "api/prices")
public class PricesController {

	@Autowired
	private PricesService pricesService;
	
	/**
	 * Method that search in BBDD the apply price
	 * @param request {@link RateProductRequest}
	 * @return {@link PricesDto}
	 */
	@PostMapping(value = "/applyPrice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PricesDto getApplyPrice(@RequestBody RateProductRequest request){
		return pricesService.findApplyPrice(request);
	}
	
}
