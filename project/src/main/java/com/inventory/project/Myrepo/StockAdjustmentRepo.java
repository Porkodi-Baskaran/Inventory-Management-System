package com.inventory.project.Myrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.project.Entity.StockAdjustment;

@Repository
public interface StockAdjustmentRepo extends JpaRepository<StockAdjustment, Integer>{

}
