/**
 * 
 */
package com.project.ecommerce.napptilum.ecommerce.napptilum.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.ecommerce.napptilum.ecommerce.napptilum.Constants.Constants;
import com.project.ecommerce.napptilum.ecommerce.napptilum.model.Prices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * PricesRepository
 */
@Repository
public class PricesRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Method auxilary that search in BBDD the apply price
	 * @param dateRequest
	 * @param productId
	 * @param brandId
	 * @return
	 */
	public Prices getApplyPrice(Timestamp dateRequest, Integer productId, Integer brandId) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Prices> criteriaQuery = criteriaBuilder.createQuery(Prices.class);
		Root<Prices> root = criteriaQuery.from(Prices.class);

		if(null != dateRequest || null != productId || null != brandId) {
			List<Predicate> predicates = new ArrayList<>();
			if(null != dateRequest) {
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(Constants.ATTR_PRICES_START_DATE), dateRequest));
		        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(Constants.ATTR_PRICES_END_DATE), dateRequest));	
			}
			if(null != productId) {
				predicates.add(criteriaBuilder.equal(root.get(Constants.ATTR_PRICES_PRODUCT_ID), productId));	
			}
			if(null != brandId) {
				predicates.add(criteriaBuilder.equal(root.get(Constants.ATTR_PRICES_BRAND_ID), brandId));	
			}
	        
	        criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));
	        Order order = criteriaBuilder.desc(root.get(Constants.ATTR_PRICES_PRIORITY));
	        criteriaQuery.orderBy(order);
		}
		try {
            Prices result = entityManager.createQuery(criteriaQuery)
                    .setMaxResults(1) 
                    .getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        }
	}
}
