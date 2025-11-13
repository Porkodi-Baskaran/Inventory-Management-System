package com.inventory.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.project.entity.Items;
import com.inventory.project.entity.PurchaseDetails;
import com.inventory.project.repository.PurchaseRepo;

@Service
public class PurchaseService { 
	
	@Autowired
	private PurchaseRepo purchaseRepo;

	public String addPurchase(PurchaseDetails purchaseDetails) {
		if(purchaseDetails.getItems()!=null) {
			for(Items item:purchaseDetails.getItems()) {
				item.setPurchaseDetails(purchaseDetails);
				
			}
		}
		
		purchaseRepo.save(purchaseDetails);
		return "Saved successfully";
	}
	
	 // Update if exists, or add new if not found
    public String updateOrAddPurchase(Integer id, PurchaseDetails updatedPurchase) {
        Optional<PurchaseDetails> optionalPurchase = purchaseRepo.findById(id);

        if (optionalPurchase.isPresent()) {
            PurchaseDetails existing = optionalPurchase.get();

            // update supplier
            existing.setSupplier(updatedPurchase.getSupplier());

            // update or replace item list
            if (updatedPurchase.getItems() != null) {
                updatedPurchase.getItems().forEach(item -> item.setPurchaseDetails(existing));
                existing.setItems(updatedPurchase.getItems());
            }

            purchaseRepo.save(existing);
            return "Items updated into existing Items Successfully!";
        } else {
            // new record
            updatedPurchase.setPurch_id(null);
            if (updatedPurchase.getItems() != null) {
                updatedPurchase.getItems().forEach(item -> item.setPurchaseDetails(updatedPurchase));
            }
             purchaseRepo.save(updatedPurchase);
             return " New Purchase Added Successfully!";
        }
    }
    // Delete purchase
    public void deletePurchase(Integer id) 
    {
        if (purchaseRepo.existsById(id)) 
        {
            purchaseRepo.deleteById(id);
        }
        else 
        {
            throw new RuntimeException("Purchase not found with ID: " + id);
        }
    }
    //  Get all purchases
    public List<PurchaseDetails> getAllPurchases() {
        return purchaseRepo.findAll();
    }
    // Get purchase by ID
    public PurchaseDetails getPurchaseById(Integer id) {
        return purchaseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found with ID: " + id));
    }

}
