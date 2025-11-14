package com.inventory.project.Myrepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.project.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>
{	
}
