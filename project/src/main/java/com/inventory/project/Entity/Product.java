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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    
    @NotBlank(message = "Product name is required")
	private String name;
    
    @NotNull(message = "Unit type is required")
	@Enumerated(EnumType.STRING)
    private UnitType unittype;
    
    @NotNull(message = "Sales price is required")
    @Positive(message = "Sales price must be positive")
    private Integer salesprice;
    
    @NotNull(message = "Purchase price is required")
    @Positive(message = "Purchase price must be positive")
    private Integer purchaseprice;
    
    @NotNull(message = "Tax rate is required")
    @Min(value = 0, message = "Tax rate cannot be negative")
    private Integer taxrate;
    
    @NotNull(message = "Opening quantity is required")
    @Min(value = 0, message = "Opening quantity cannot be negative")
    private Integer openingquantity;
    
    @NotNull(message = "At price is required")
    @Positive(message = "At price must be positive")
    private Integer Atprice;
    
    @NotNull(message = "Low stock value is required")
    @Min(value = 0, message = "Low stock must be 0 or more")
    private Integer lowstock;
    
    @NotNull(message = "Update date is required")
    private LocalDate updatedate;
    
    private Integer stockValue;
    
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

	public Integer getStockValue() {
		return stockValue;
	}

	public void setStockValue(Integer stockValue) {
		this.stockValue = stockValue;
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

	public Integer getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(Integer taxrate) {
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
