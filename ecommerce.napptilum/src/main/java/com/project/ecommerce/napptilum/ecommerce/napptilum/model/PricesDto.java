/**
 * 
 */
package com.project.ecommerce.napptilum.ecommerce.napptilum.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * PricesDto
 */
public class PricesDto implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8459693523454802749L;

	/**
	 * productId
	 */
	private Integer productId;
	
	/**
	 * brandId
	 */
	private Integer brandId;

	/**
	 * priceList
	 */
	private Integer priceList;
	
	/**
	 * startDate
	 */
	private String startDate;
	
	/**
	 * endDate
	 */
	private String endDate;
	
	/**
	 * price
	 */
	private BigDecimal price;

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

	/**
	 * @return the priceList
	 */
	public Integer getPriceList() {
		return priceList;
	}

	/**
	 * @param priceList the priceList to set
	 */
	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
