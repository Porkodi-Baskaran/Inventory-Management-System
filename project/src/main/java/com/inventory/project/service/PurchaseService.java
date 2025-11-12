package com.inventory.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.project.entity.Items;
import com.inventory.project.entity.PurchaseDetails;
import com.inventory.project.entity.Unit;
import com.inventory.project.repository.PurchaseRepo;
@Service
public class PurchaseService { 
	
	@Autowired
	private PurchaseRepo purchaseRepo;
	
	@Autowired
//	private Items items;

	 public PurchaseDetails addPurchase(PurchaseDetails purchaseDetails) {
	        return purchaseRepo.save(purchaseDetails);
	 }

	
	 
		


}
