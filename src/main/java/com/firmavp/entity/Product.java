package com.firmavp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseEntity{
	private String title;
	private String code;
	private String shortDescription;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private ProductCategory productCategory;
	//@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  //  private List<Pictures>listPictures;	

	/*
	 * //metoda za sinhronizaciju public void addPictures(Pictures slika) {
	 * listPictures.add(slika); slika.setProduct(this); } //metoda za sinhronizaciju
	 * public void removePictures(Pictures slika) { listPictures.remove(slika);
	 * slika.setProduct(null); }
	 */
}
