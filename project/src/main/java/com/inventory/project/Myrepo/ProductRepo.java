package com.inventory.project.Myrepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.project.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>
{

	
	
}
