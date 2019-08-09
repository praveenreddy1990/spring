package com.world.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.info.mapper.CityMapper;
import com.world.info.model.City;

@Service
public class CityService {
	@Autowired
	private CityMapper cityMapper;
		
	public List<City> getAllCities(){
		 List<City> cities = null;
		 cities = cityMapper.findAll();
		cities.forEach(System.out::println);
		return cityMapper.findAll();
		
	}
	
	public List<City> getTopCities(int count){
		 List<City> cities = null;
		 cities = cityMapper.findTopPopulatedCities(count);
		return cities;
		
	}
	
	public List<String> getlanguagesByCity(String city){
		 List<String> languages = null;
		 languages = cityMapper.getLangbyCity(city);
		return languages;
		
	}
	
	public int addCity(City city) {
		boolean isAdded = false;
		int cityID =0;
		cityID= cityMapper.nextCityID();
		if(cityID !=0) {
			city.setId(++cityID);
			System.out.println("city at services "+city.toString());
			isAdded = cityMapper.addCity(city);
		}
		 if(isAdded) {
			 return cityID;
		 }
		 
		 return 0;
	}
	
	public String updateCityPopulation(City city) {
		
		int processed= 0;
		if(city != null) {
		  processed = cityMapper.UpdatePopulation(city);
		 
	}
		if(processed >0)
			 return " record updated";
		 return "record not updated";
	}
	
	public String deleteCityDetails(int id) {
		
		boolean processed = cityMapper.deleteCityDetails(id);
		if(processed) {
			return "deleted successfully";
		}else {
			return "not deleted";
		}
	}
	
	public City getCityDetails(int id) {
		return cityMapper.getCityDetails(id);
	}
}
