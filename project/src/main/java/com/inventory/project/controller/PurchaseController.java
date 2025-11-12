package com.inventory.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.project.entity.PurchaseDetails;
import com.inventory.project.service.PurchaseService;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	
	// Add Purchase
    @PostMapping("/add")
    public PurchaseDetails addPurchase(@RequestBody PurchaseDetails purchaseDetails) {
        return purchaseService.addPurchase(purchaseDetails);
        }
   
}
