package com.project.ecommerce.napptilum.ecommerce.napptilum.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.napptilum.ecommerce.napptilum.model.Prices;
import com.project.ecommerce.napptilum.ecommerce.napptilum.model.PricesDto;
import com.project.ecommerce.napptilum.ecommerce.napptilum.model.RateProductRequest;
import com.project.ecommerce.napptilum.ecommerce.napptilum.repository.PricesRepository;
import com.project.ecommerce.napptilum.ecommerce.napptilum.service.PricesService;

@Service
public class PricesServiceImpl implements PricesService{

	@Autowired
	private PricesRepository pricesRepository;

	@Override
	public PricesDto findApplyPrice(RateProductRequest request) {
		PricesDto pricesDto = null;
		Prices prices =  pricesRepository.getApplyPrice(Timestamp.valueOf(request.getDateRequest()),request.getProductId(),request.getBrandId());
		if(null != prices) {
			pricesDto = new PricesDto();
			pricesDto.setBrandId(prices.getBrandId());
			pricesDto.setEndDate(getFormatDate(prices.getEndDate()));
			pricesDto.setPrice(prices.getPrice());
			pricesDto.setPriceList(prices.getPriceList());
			pricesDto.setProductId(prices.getProductId());
			pricesDto.setStartDate(getFormatDate(prices.getStartDate()));
		}
		return pricesDto;
	}

	/**
	 * Auxiliary method that format Timestamp to 'yyyy-mm-dd HH:mm:ss'
	 * @param timestamp
	 * @return
	 */
	private String getFormatDate(Timestamp timestamp) {
		if(null != timestamp) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return dateFormat.format(timestamp);			
		}else {
			return null;
		}
	}
}
