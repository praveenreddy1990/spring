package com.world.info.controller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.world.info.model.City;
import com.world.info.service.CityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/city")
public class CityController {
		
	Logger logger = LogManager.getLogger(CityController.class);
		final String className= "CityController";
		@Autowired
		private CityService cityService;
		
		@ApiOperation(value = "Retrieves the top highest populated cities",
		        notes = "Retrieves highest populated cities based on given value , if it 10 it will provide highest ten cites based number it will vary",
		        response = City.class)
		
		@RequestMapping(value ="/top/{count}/populatedcities",method = RequestMethod.GET)
		public List<City> getTopCities(@PathVariable("count") @ApiParam (" discribes number of cities that have highest population")int count ){
			logger.log(Level.INFO, className, "getTopCities","enter into", "getTopCities");
			List<City> cities =null;
			System.out.println("getting top cities");
			cities = cityService.getTopCities(count);	
			logger.log(Level.INFO, className, "getTopCities","exit from", "getTopCities");
			return cities;					
		}
		
		@RequestMapping(value ="/languages/of/{city}",method = RequestMethod.GET)
		public List<String> getLanguagesByCity(@PathVariable String city){
			logger.info(className," getLanguagesByCity", " entered ");
			logger.log(Level.INFO, "CityController", "getLanguagesByCity","enter into", "getLanguagesByCity");
			List<String> languages = null;
			  languages = cityService.getlanguagesByCity(city);
			  logger.log(Level.INFO, "CityController", "getLanguagesByCity","exit from", "getLanguagesByCity");
			 return languages;
		}
		@RequestMapping(value ="/addCity", method =RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
		public String addNewCity(@RequestBody City city) {
			int cityID= 0;
			System.out.println("city "+city.toString());
			logger.info(className,"addNewCity" ,"entered",city.toString());
				cityID = cityService.addCity(city);
				
				if(cityID != 0) {
					return city.getName()+" added with city id "+cityID;
				}
			
			return city.getName()+"  not added";
			
			
		}
		
		@RequestMapping(value ="/updatePopulation", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON)
		public String updateCityPopulation(@RequestBody City city) {			 
			
			return cityService.updateCityPopulation(city);			
			
		}
		
		@RequestMapping(value ="/delete/{id}", method =RequestMethod.DELETE)
		public String deleteCityDetails(@PathParam("id") int id) {
			
			return cityService.deleteCityDetails(id);
		}
		
		@RequestMapping("/getCityDetails/{id}")
		public City getCityById(@PathVariable int id) {
			
			 return cityService.getCityDetails(id);
		}
		
		public String getCountryDetailsByCity(String id) {
			return null;
		}
		
}
