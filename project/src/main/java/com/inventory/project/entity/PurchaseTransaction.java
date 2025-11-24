package com.inventory.project.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class PurchaseTransaction {
	@Id
	private Integer ptran_id;
	private Integer inv_no;
	private String s_name;
	private LocalDate date;
	@Enumerated(EnumType.STRING)
	private PurchaseTransactionType type;
	private Integer priceperunit;
	private String status;
	private PurchaseDetails purch;
	
	
}
