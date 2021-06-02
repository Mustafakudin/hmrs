package com.mustafa.hmrs.core.utilities.validation;

public interface MernisValidationService {
	public boolean checkIfRealPerson(Long nationalIdentity,
			String firstName, String lastName, int year);
}
