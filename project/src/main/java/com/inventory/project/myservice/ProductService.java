package com.inventory.project.myservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.project.Entity.Product;
import com.inventory.project.Myrepo.ProductRepo;

@Service
public class ProductService 
{
    
	@Autowired
	ProductRepo repo;
	
	public Product addproduct(Product products)
	{
		repo.save(products);
		return products;
	}
	
	public Product updateProduct(Integer id, Product updatedProduct) 
	{
        Optional<Product> optionalProduct = repo.findById(id);

        if (optionalProduct.isPresent()) 
        {
            Product existingProduct = optionalProduct.get();

            existingProduct.setName(updatedProduct.getName());
            existingProduct.setunittype(updatedProduct.getunittype());
            existingProduct.setSalesprice(updatedProduct.getSalesprice());
            existingProduct.setPurchaseprice(updatedProduct.getPurchaseprice());
            existingProduct.setTaxrate(updatedProduct.getTaxrate());
            existingProduct.setOpeningquantity(updatedProduct.getOpeningquantity());
            existingProduct.setAtprice(updatedProduct.getAtprice());
            existingProduct.setLowstock(updatedProduct.getLowstock());
            existingProduct.setUpdatedate(updatedProduct.getUpdatedate());
             return repo.save(existingProduct);
        } 
        
        
        else 
        {
       
            return null;
        }
    }
	
	public String deleteProduct(Integer id)
	{
		
		repo.deleteById(id);
		return "Successfully deleted...";
	}
	
	public Optional<Product> viewProductsbyid(Integer id)
	{
		return repo.findById(id);
	}
	
	public List<Product> viewAllProducts() 
	{
	    return repo.findAll();
	}
	
	
	
	
}
