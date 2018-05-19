package com.providers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper
		implements ExceptionMapper<RuntimeException>{

	@Override
	public Response toResponse(RuntimeException re) {
		// TODO Auto-generated method stub
		return Response
				.status(Status.NOT_FOUND)
				.entity(re.getMessage())
				.build();
	}
	
}
