package com.inventory.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.project.entity.PurchaseDetails;
import com.inventory.project.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	
	// Add Purchase
    @PostMapping("/add")
    public ResponseEntity<String> addPurchase(@RequestBody PurchaseDetails purchaseDetails) {
        String res=purchaseService.addPurchase(purchaseDetails);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
   
}
