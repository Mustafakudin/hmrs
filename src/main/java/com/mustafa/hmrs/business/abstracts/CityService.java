package com.mustafa.hmrs.business.abstracts;

import java.util.List;

import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.core.utilities.results.Result;
import com.mustafa.hmrs.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getall();
	Result add(City city);
}
