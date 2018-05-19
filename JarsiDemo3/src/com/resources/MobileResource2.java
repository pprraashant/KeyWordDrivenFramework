package com.resources;

import java.util.List;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/mobiles")
public class MobileResource2 {
	
	@GET
	@Path("/{name}-{price}")
	public Response printMobileDetails(
			@PathParam("name") String name,
			@PathParam("price") String price)
	{
		return Response
				.ok()
				.entity("name:"+name+ "and price:" +price)
				.type(MediaType.TEXT_PLAIN)
				.build();
		
	}
	
	@GET
	@Path("/{mobileno : \\d+}")
	public Response printMobileNumber(
			@PathParam("mobileno") String mobileno)
	{
		return Response
				.ok()
				.entity("MobileNumber:"+mobileno)
				.type(MediaType.TEXT_PLAIN)
				.build();
		
	}
	
	@GET
	@Path("/{name : [a-z][a-zA-z0-9] }")
	public Response printMobileName(
			@PathParam("name") String name)
	{
		return Response
				.ok()
				.entity("MobileName:"+name)
				.type(MediaType.TEXT_PLAIN)
				.build();
		
	}
	
	@GET
	@Path("/{mobileno}/and/{mobileno}")
	public Response printMobileNumbers(
			@Context UriInfo uriInfo,
			@MatrixParam("color") @DefaultValue("Black") String color,
			@MatrixParam("ram") @DefaultValue("1Gb") String ram)
	{
		return Response
				.ok()
				.entity("MobileNumber2:"+uriInfo.getPathParameters()
						+"and color:"+color
						+"and Ram :"+ ram)
				.type(MediaType.TEXT_PLAIN)
				.build();
		
	}
	@GET
	@Path("/price/{price : .+}")
	public Response printPrice(
			@PathParam("price") List<PathSegment> pathSegment)
	{
		String result= "";
		for(PathSegment segment : pathSegment) {
			result += "price :" + segment.getPath()
			+"and matrix parameter:"
			+segment.getMatrixParameters()
			+ "\n ";
		}
		return Response
				.ok()
				.entity(result)
				.type(MediaType.TEXT_PLAIN)
				.build();
		
	}
	
	@GET
	public Response fetchRecord(
			@HeaderParam("User-Agent") String agent,
			@CookieParam("SessionId") String sessionId,
			@QueryParam("start") @DefaultValue("1") int start,
			@QueryParam("end") @DefaultValue("10") int end)
	{
		return Response
				.ok()
				.entity("Agent :" +agent +
						"\n session id :" +sessionId +
						"\n start :" + start + "and End :"+ end)
				.type(MediaType.TEXT_PLAIN)
				.cookie(new NewCookie("SessionId","121212"))
				.build();
	}
	//

}
