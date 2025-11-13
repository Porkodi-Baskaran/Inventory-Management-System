package com.inventory.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PurchaseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purch_id;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "supplier_id")
	@JsonBackReference
	private Supplier supplier;
	
	@OneToMany(mappedBy = "purchaseDetails", cascade = CascadeType.ALL)    
	@JsonManagedReference
	private List<Items> items;
	
	
	private Integer total_amount;
	
	public Integer getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}
	
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
	
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	public PurchaseDetails(Integer purch_id, Supplier supplier, List<Items> items) {
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
