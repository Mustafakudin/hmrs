package com.mustafa.hmrs.core.utilities.validation;

import org.springframework.stereotype.Service;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisValidationManager implements MernisValidationService {

	@Override
	public boolean checkIfRealPerson(Long nationalIdentity, String firstName, String lastName, int year) {
		KPSPublicSoapProxy kpsPublicSoapProxy= new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(
										nationalIdentity,
										firstName.toUpperCase(),
										lastName.toUpperCase(),
										year);
		}
		catch (Exception e) {
			System.out.println("Mustafa : " + e.getMessage());
		}
		
		return result;
	}

}