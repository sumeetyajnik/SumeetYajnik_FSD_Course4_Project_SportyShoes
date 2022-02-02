package com.sportyshoes.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.app.model.PurchaseOrderUserDetail;

public interface SportyShoesPurchaseOrderUserDetailRepository extends CrudRepository<PurchaseOrderUserDetail, String> {
	
	List<PurchaseOrderUserDetail> findByCreatedDateAndCategory(String createdDate, String category);

}

