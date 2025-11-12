package com.inventory.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties("purchaseDetails")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer item_id;
	private String name;
	private Integer qty;
	
	@Enumerated(EnumType.STRING)
	private Unit unit;
	
	private Integer price;
	private Integer discount;
	private Integer taxrate;
	private boolean tax_present;
	
	@ManyToOne
	@JoinColumn(name = "purchase_id")
	@JsonBackReference
	private PurchaseDetails purchaseDetails;
	
	public PurchaseDetails getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(PurchaseDetails purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public double getTaxrate() {
		return taxrate;
	}
	public void setTaxrate(Integer taxrate) {
		this.taxrate = taxrate;
	}
	
	public boolean isTax_present() {
		return tax_present;
	}
	public void setTax_present(boolean tax_present) {
		this.tax_present = tax_present;
	}
	
	public Items() {}
	public Items(Integer item_id, String name, Integer qty, Unit unit, Integer price, Integer discount, Integer taxrate,
			boolean tax_present, PurchaseDetails purchaseDetails) {
		super();
		this.item_id = item_id;
		this.name = name;
		this.qty = qty;
		this.unit = unit;
		this.price = price;
		this.discount = discount;
		this.taxrate = taxrate;
		this.tax_present = tax_present;
		this.purchaseDetails = purchaseDetails;
	}
	@Override
	public String toString() {
		return "Items [item_id=" + item_id + ", name=" + name + ", qty=" + qty + ", unit=" + unit + ", price=" + price
				+ ", discount=" + discount + ", taxrate=" + taxrate + ", tax_present=" + tax_present
				+ ", purchaseDetails=" + purchaseDetails + "]";
	}

		
}
