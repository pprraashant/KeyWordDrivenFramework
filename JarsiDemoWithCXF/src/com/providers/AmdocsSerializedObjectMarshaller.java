package com.providers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes("application/amdpcs-serialized-object")
@Produces("application/amdocs-serialized-object")
public class AmdocsSerializedObjectMarshaller implements MessageBodyWriter<Object> ,
														MessageBodyReader<Object>
{

	@Override
	public long getSize(Object arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		
		
		return Serializable.class.isAssignableFrom(arg0);
	}

	@Override
	public void writeTo(Object target, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream os) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		
		ObjectOutputStream oos=new ObjectOutputStream(os);
		oos.writeObject(target);
		oos.flush();
		
	}

	@Override
	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object readFrom(Class<Object> arg0, Type arg1, Annotation[] arg2, MediaType arg3,
			MultivaluedMap<String, String> arg4, InputStream is) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		Object o=null;
		
		ObjectInputStream ois= new ObjectInputStream(is);
		try
		{
			o=ois.readObject();
		} catch(ClassNotFoundException e) {}
		 
		return o;
	}

	
}
