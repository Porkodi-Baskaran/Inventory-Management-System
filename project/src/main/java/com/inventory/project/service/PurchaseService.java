package com.inventory.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventory.project.entity.PurchaseDetails;
import com.inventory.project.repository.PurchaseRepo;

@Service
public class PurchaseService { 
	
	@Autowired
	private PurchaseRepo purchaseRepo;

	public String addPurchase(PurchaseDetails purchaseDetails) {
		 purchaseRepo.save(purchaseDetails);
		 return "Saved successfully";
	}

	
	 
		


}
