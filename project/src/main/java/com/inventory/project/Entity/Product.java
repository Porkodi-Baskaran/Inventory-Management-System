package com.inventory.project.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	private String name;
    
	@Enumerated(EnumType.STRING)
    private UnitType unittype;
    
    private Integer salesprice;
    
    private Integer purchaseprice;
    
    private Double taxrate;
    
    private Integer openingquantity;
    
    private Integer Atprice;
    
    private Integer lowstock;
    
    private LocalDate updatedate;
    
    @OneToMany(mappedBy = "product")
    private List<Transaction> transactions;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UnitType getunittype() {
		return unittype;
	}

	public void setunittype(UnitType unittype) {
		this.unittype = unittype;
	}

	public Integer getSalesprice() {
		return salesprice;
	}

	public void setSalesprice(Integer salesprice) {
		this.salesprice = salesprice;
	}

	public Integer getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(Integer purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public Double getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(Double taxrate) {
		this.taxrate = taxrate;
	}

	public Integer getOpeningquantity() {
		return openingquantity;
	}

	public void setOpeningquantity(Integer openingquantity) {
		this.openingquantity = openingquantity;
	}

	public Integer getAtprice() {
		return Atprice;
	}

	public void setAtprice(Integer atprice) {
		Atprice = atprice;
	}

	public Integer getLowstock() {
		return lowstock;
	}

	public void setLowstock(Integer lowstock) {
		this.lowstock = lowstock;
	}

	public LocalDate getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(LocalDate updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", unittype=" + unittype + ", salesprice=" + salesprice
				+ ", purchaseprice=" + purchaseprice + ", taxrate=" + taxrate + ", openingquantity=" + openingquantity
				+ ", Atprice=" + Atprice + ", lowstock=" + lowstock + ", updatedate=" + updatedate + "]";
	}
    
    
    
	
}
