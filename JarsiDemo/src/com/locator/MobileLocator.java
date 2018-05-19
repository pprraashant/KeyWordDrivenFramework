package com.locator;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.resources.MobileResource;

@Path("/mobiles")
public class MobileLocator {
	
	@Path("/{location}")
	public MobileResource getMobileResource(
			@PathParam("location") String loc)
	{
		if("india".equalsIgnoreCase(loc)) {
			
			return new MobileResource();
		}
		return null;
		
	}

}
