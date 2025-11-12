package com.inventory.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.project.entity.PurchaseDetails;

public interface PurchaseRepo extends JpaRepository<PurchaseDetails, Integer> {

}
