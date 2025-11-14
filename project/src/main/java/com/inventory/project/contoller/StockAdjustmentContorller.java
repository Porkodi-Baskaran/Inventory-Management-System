package com.inventory.project.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.project.Entity.StockAdjustment;
import com.inventory.project.Entity.Transaction;
import com.inventory.project.Myrepo.TransactionRepo;
import com.inventory.project.myservice.StockAdjustmentService;

@RestController
@RequestMapping("/stock-adjustment")
public class StockAdjustmentContorller {

	@Autowired
	private StockAdjustmentService adjustmentService; 
	
	@PostMapping("/{productId}")
	public String adjustStock(@PathVariable Integer productId, @RequestBody StockAdjustment adjustment)
	{
		adjustmentService.adjustStock(productId, adjustment);
		return "Stock updated successfully";
	}
}
