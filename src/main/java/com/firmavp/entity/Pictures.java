package com.firmavp.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.firmavp.enums.PictureCategory;

@Entity
@Setter
@Getter
public class Pictures extends BaseEntity implements Serializable{
	private String urlPictures;
	private String description;
	private PictureCategory category;
	private Integer entity_id;


	

}
