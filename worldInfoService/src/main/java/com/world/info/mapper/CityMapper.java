package com.world.info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.world.info.model.City;

@Mapper
public interface CityMapper {
	
	final String nextValue= "SELECT MAX(ID) FROM WORLD.CITY"; 
	
	@Select("select * from city")
     List<City> findAll();
	
	@Select("SELECT * FROM world.city order by population desc limit #{num}")
    List<City> findTopPopulatedCities(int num);

	@Select("SELECT CL.LANGUAGE FROM COUNTRYLANGUAGE CL, CITY C WHERE CL.COUNTRYCODE = C.COUNTRYCODE AND C.NAME LIKE '%' #{city} '%'")
    List<String> getLangbyCity(String city);
	
	@Select(nextValue)
	int nextCityID();
	
	@Insert("INSERT INTO world.city (id,name,countryCode,district,population) VALUES (#{id},#{name},#{countryCode},#{district},#{population})")
	boolean addCity(City city);
	
	
	@Update("UPDATE WORLD.CITY SET POPULATION = #{population} WHERE ID = #{id}")
	int UpdatePopulation(City city);
	
	@Delete("DELETE from world.city WHERE ID =#{id}")
	boolean deleteCityDetails(int id);
	
	@Select("SELECT * FROM CITY WHERE ID =#{id}")
	City getCityDetails(int id);
}
