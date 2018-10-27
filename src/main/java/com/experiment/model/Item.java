package com.experiment.model;

import java.util.Map;

import com.experiment.ItemType;
import com.experiment.unit;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Index
public class Item {

	@Id
	String id;
	String name, price, unit, discount, img;
	int qty;

	@Index ItemType type;
	private Item() {

	}

	private Item(String id,String name,String price, String unit, String discount, String img, ItemType type, int qty) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.discount = discount;
		this.img = img;
		this.type = type;
		this.qty = qty;
	}


	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

}
