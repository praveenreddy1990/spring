package com.review.city.catalog.model;



public class City {
	
	public City() {
		
	}
	public City(int id, String name, String countryCode, String district, int population) {
		super();
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	private	int id;
	private String name;
	private String countryCode;
	private String district;
	private int population;
	
	
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
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
				+ ", population=" + population + "]";
	}
	
	
	
	
		
}
