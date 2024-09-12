package com.ty.dto;

public class Car {
	
	int id;
	String name;
	String brand;
	int cost;
	int manufactureYear;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getManufactureYear() {
		return manufactureYear;
	}
	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", brand=" + brand + ", cost=" + cost + ", manufactureYear="
				+ manufactureYear + "]";
	}
	
	
	

}
