package com.review.city.catalog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.review.city.catalog.model.CityCatalog;

@Mapper
public interface CityCatalogMapper {
	
	@Select("SELECT * FROM CITY_CATALOG")
	List<CityCatalog> getCatalogs();

	@Select("SELECT CITY_ID FROM CITY_CATALOG WHERE USER_ID = #{id}")
	int getCityIdByUserId(int id);
}
