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
		updateStockValue(products);
		repo.save(products);
		return products;
	}
	
	public void updateStockValue(Product products)
	{
		if(products.getPurchaseprice() !=null && products.getOpeningquantity()!=null )
		{
			products.setStockValue(products.getPurchaseprice() * products.getOpeningquantity());
		}
		else
		{
			products.setStockValue(0);
		}
	}
	
	public Product updateProduct(Integer id, Product updatedProduct) 
	{
        Optional<Product> optionalProduct = repo.findById(id);

        if (optionalProduct.isPresent()) 
        {
            Product existingProduct = optionalProduct.get();
           if(updatedProduct.getName() !=null)
           {
            existingProduct.setName(updatedProduct.getName());
           }
           if(updatedProduct.getunittype() !=null)
           {
            existingProduct.setunittype(updatedProduct.getunittype());
           }
           if(updatedProduct.getSalesprice() !=null)
           {
            existingProduct.setSalesprice(updatedProduct.getSalesprice());
           }
           if(updatedProduct.getPurchaseprice() !=null)
           {
            existingProduct.setPurchaseprice(updatedProduct.getPurchaseprice());
           }
           if(updatedProduct.getTaxrate() !=null)
           {
            existingProduct.setTaxrate(updatedProduct.getTaxrate());
           }
           if(updatedProduct.getOpeningquantity() !=null)
           {
            existingProduct.setOpeningquantity(updatedProduct.getOpeningquantity());
           }
           if(updatedProduct.getAtprice() !=null)
           {
            existingProduct.setAtprice(updatedProduct.getAtprice());
           }
           if(updatedProduct.getLowstock() !=null)
           {
            existingProduct.setLowstock(updatedProduct.getLowstock());
           }
           if(updatedProduct.getUpdatedate() !=null)
           {
            existingProduct.setUpdatedate(updatedProduct.getUpdatedate());
           }
          
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
