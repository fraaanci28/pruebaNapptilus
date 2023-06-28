/**
 * 
 */
package com.project.ecommerce.napptilum.ecommerce.napptilum.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RateProductRequest
 */
public class RateProductRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7346092365859347101L;

	@JsonProperty("dateRequest")
	private String dateRequest;
	
	@JsonProperty("productId")
	private Integer productId;
	
	@JsonProperty("brandId")
	private Integer brandId;

	/**
	 * @return the dateRequest
	 */
	public String getDateRequest() {
		return dateRequest;
	}

	/**
	 * @param dateRequest the dateRequest to set
	 */
	public void setDateRequest(String dateRequest) {
		this.dateRequest = dateRequest;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the brandId
	 */
	public Integer getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	
}
