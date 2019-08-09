package com.review.city.catalog.model;

public class CityCatalog {
	
	private int city_id;
	private String city_name;
	private int rating;
	private int user_id;
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "CityCatalog [city_id=" + city_id + ", city_name=" + city_name + ", rating=" + rating + ", user_id="
				+ user_id + "]";
	}
	
	
	

}
