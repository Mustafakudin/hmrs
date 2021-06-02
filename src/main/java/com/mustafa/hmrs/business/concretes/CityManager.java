package com.mustafa.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafa.hmrs.business.abstracts.CityService;
import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.ErrorResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.core.utilities.results.SuccesResult;
import com.mustafa.hmrs.core.utilities.results.SuccessDataResult;
import com.mustafa.hmrs.dataAccess.CityDao;
import com.mustafa.hmrs.entities.concretes.City;

@Service

public class CityManager implements CityService{
	
	private CityDao cityDao;
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao=cityDao;
	}

	@Override
	public DataResult<List<City>> getall() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(City city) {
		if(cityDao.getByName(city.getName())!=null) {
			return new ErrorResult("aynı isimde şehir bulunuyor");
		}
		else {
			return new SuccesResult("yeni şehir eklendi");
		}
	}

}
