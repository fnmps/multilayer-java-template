package com.fnmps.java.template.multilayer.businesslayer.relationships.adapters;

import com.fnmps.java.template.multilayer.businesslayer.common.exceptions.ExternalServiceException;

public interface IAuthenticationAdapterService {

	public boolean isValidUser(String username) throws ExternalServiceException;
}
