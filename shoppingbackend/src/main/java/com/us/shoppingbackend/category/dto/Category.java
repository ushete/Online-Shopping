package com.us.shoppingbackend.category.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Column(name = "CATEGORY_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESC")
	private String desc;

	public int getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getDesc(){
		return desc;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	@Override
	public String toString(){
		return "Category [categoryId=" + categoryId + ", name=" + name + ", desc=" + desc + "]";
	}
}
