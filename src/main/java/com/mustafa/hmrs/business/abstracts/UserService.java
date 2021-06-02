package com.mustafa.hmrs.business.abstracts;

import java.util.List;


import com.mustafa.hmrs.core.utilities.results.DataResult;
import com.mustafa.hmrs.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getall();
}
