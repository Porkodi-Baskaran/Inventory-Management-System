package com.inventory.project.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransactionsDTO 
{
	 @NotNull(message = "Product ID is required")
		private Integer productId;
	 
	 @NotBlank(message = "Transaction type is required")
	    private String type;
	 
	 @NotBlank(message = "Name is required")
	    private String name;
	 
	 @NotNull(message = "Quantity is required")
	    @Positive(message = "Quantity must be positive")
	    private Integer quantity;
	 
	 @NotNull(message = "Price per unit is required")
	    @Positive(message = "Price per unit must be positive")
	    private Integer pricePerUnit;
	 
	 @NotBlank(message = "Status is required")
	    private String status;
	    
	    
	    
		public Integer getProductId() {
			return productId;
		}
		public void setProductId(Integer productId) {
			this.productId = productId;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Integer getPricePerUnit() {
			return pricePerUnit;
		}
		public void setPricePerUnit(Integer pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	    
	    
}
