package com.mustafa.hmrs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mustafa.hmrs.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	
	City getById(int cityId);
	City getByName(String cityName);
}
