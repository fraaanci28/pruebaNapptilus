package com.project.ecommerce.napptilum.ecommerce.napptilum.service;

import com.project.ecommerce.napptilum.ecommerce.napptilum.model.PricesDto;
import com.project.ecommerce.napptilum.ecommerce.napptilum.model.RateProductRequest;

public interface PricesService {

	/**
	 * Method findApplyPrice that obtain the apply price
	 * @param request{{@link RateProductRequest}
	 * @return
	 */
	public PricesDto findApplyPrice(RateProductRequest request);
	
}
