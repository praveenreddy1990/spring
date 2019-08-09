package com.review.city.catalog.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.city.catalog.mapper.CityCatalogMapper;
import com.review.city.catalog.model.CityCatalog;

@Service
public class CatalogService {
	@Autowired
	CityCatalogMapper cityCatalogMapper;
	public  List<CityCatalog> getCityCatalogs(){
		return cityCatalogMapper.getCatalogs();
	}
	
	public int getCityIdByUserId(int id){
		
		return	cityCatalogMapper.getCityIdByUserId(id);
		
	}
	
}
