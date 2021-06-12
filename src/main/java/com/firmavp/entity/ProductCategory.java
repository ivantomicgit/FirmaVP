package com.firmavp.entity;



import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
public class ProductCategory extends BaseEntity{
	private String categoryName;
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Product>listProducts;

	public void addProduct(Product product) {
		listProducts.add(product);
		product.setProductCategory(this);
	}
	
	public void removeProduct(Product product) {
		listProducts.remove(product);
		product.setProductCategory(null);
	}

}
