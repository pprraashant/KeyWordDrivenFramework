package com.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.locator.MobileLocator;
import com.providers.AmdocsSerializedObjectMarshaller;
import com.providers.RuntimeExceptionMapper;
import com.resources.CustomerResources;
import com.resources.MobileResource;

public class BankingApplication extends Application {

	private Set<Class<?>> perRequest =new HashSet<Class<?>>();
	private Set<Object> singletons =new HashSet<Object>();
	
	@Override
	public Set<Object> getSingletons()
	{
		singletons.add(new CustomerResources());
		return singletons;
	}
	@Override
	public Set<Class<?>> getClasses()
	{
		perRequest.add(MobileResource.class);
		//perRequest.add(MobileLocator.class);
		perRequest.add(AmdocsSerializedObjectMarshaller.class);
		perRequest.add(RuntimeExceptionMapper.class);
		return perRequest;
	}
	
}
