package com.review.city.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.review.city.catalog.model.City;
import com.review.city.catalog.model.CityCatalog;
import com.review.city.catalog.service.CatalogService;

@RestController
public class CityCatalogController {
	
	@Autowired
	CatalogService catalogService;
	
	 @Autowired 
	 RestTemplate restTemplate;	 
	
	@RequestMapping(value ="/getAllCityCatalog")
	public List<CityCatalog> getAllCityCatalog(){
		return  catalogService.getCityCatalogs();
	}
	
	@RequestMapping("/getCityDetailByUserId/{id}")
	public City getReviewedCitiesByuserId(@PathVariable int id){
			System.out.println("entered into getReviewedCitiesByuserId with"+id);
			int city_id = catalogService.getCityIdByUserId(id);
			return restTemplate.getForObject("http://city-info-service/city/getCityDetails/"+city_id, City.class);			
	}
}
