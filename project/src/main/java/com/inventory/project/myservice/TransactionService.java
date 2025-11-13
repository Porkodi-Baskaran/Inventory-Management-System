package com.inventory.project.myservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.project.Entity.Product;
import com.inventory.project.Entity.Transaction;
import com.inventory.project.Entity.TransactionType;
import com.inventory.project.Entity.TransactionsDTO;
import com.inventory.project.Myrepo.ProductRepo;
import com.inventory.project.Myrepo.TransactionRepo;

@Service
public class TransactionService
{
	@Autowired
	TransactionRepo transrepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	
	public void recordtransaction(TransactionsDTO dto)
	{
		Transaction transaction=new Transaction();
		
		Product product=productRepo.findById(dto.getProductId()).orElseThrow(()->new RuntimeException("product not found"));
		
		
		transaction.setProduct(product);
        transaction.setType(TransactionType.valueOf(dto.getType()));
        transaction.setName(dto.getName());
        transaction.setDate(LocalDate.now());
        transaction.setQuantity(dto.getQuantity());
        transaction.setPriceperunit(dto.getPricePerUnit());
        if (dto.getType().equals("PURCHASE") || dto.getType().equals("SALE")) {
            transaction.setStatus(dto.getStatus());
        }
        else
        {
        	transaction.setStatus("");
        }

		transrepo.save(transaction);
	}
	
	public List<Transaction> getAllTransaction()
	{
		return transrepo.findAll();
	}
}
