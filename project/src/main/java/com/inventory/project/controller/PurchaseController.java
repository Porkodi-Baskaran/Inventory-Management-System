package com.inventory.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrAddPurchase(@PathVariable Integer id, @RequestBody PurchaseDetails updatedPurchase) {
        String res = purchaseService.updateOrAddPurchase(id, updatedPurchase);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
   // Delete Purchase
    @DeleteMapping("/delete/{id}")
    public String deletePurchase(@PathVariable Integer id) {
        purchaseService.deletePurchase(id);
        return "Purchase deleted successfully!";
    }
   // Get All Purchases
    @GetMapping("/all")
    public List<PurchaseDetails> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }
  // Get Purchase by ID
    @GetMapping("/{id}")
    public PurchaseDetails getPurchaseById(@PathVariable Integer id) {
        return purchaseService.getPurchaseById(id);
    }
    
   
}
