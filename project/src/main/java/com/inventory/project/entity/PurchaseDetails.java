package com.inventory.project.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PurchaseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purch_id;
	
	private Supplier supplier;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "item_id") // foreign key column
	    private Items items;
	
	public Integer getPurch_id() {
		return purch_id;
	}
	public void setPurch_id(Integer purch_id) {
		this.purch_id = purch_id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public PurchaseDetails(Integer purch_id, Supplier supplier, Items items) {
		super();
		this.purch_id = purch_id;
		this.supplier = supplier;
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "PurchaseDetails [purch_id=" + purch_id + ", supplier=" + supplier + ", items=" + items + "]";
	}

}
