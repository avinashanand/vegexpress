package com.experiment.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Address {
	
	@Id
	String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	String FlatNo, Bld, society;
	String Landmark;
	String Locality, city;
	
	public String getFlatNo() {
		return FlatNo;
	}
	public void setFlatNo(String flatNo) {
		FlatNo = flatNo;
	}
	public String getBld() {
		return Bld;
	}
	public void setBld(String bld) {
		Bld = bld;
	}
	public String getSociety() {
		return society;
	}
	public void setSociety(String society) {
		this.society = society;
	}
	public String getLandmark() {
		return Landmark;
	}
	public void setLandmark(String landmark) {
		Landmark = landmark;
	}
	public String getLocality() {
		return Locality;
	}
	public void setLocality(String locality) {
		Locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
