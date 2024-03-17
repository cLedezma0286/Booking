package mx.com.hsbc.exposer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import mx.com.hsbc.dto.ReservationList;
import java.lang.reflect.Type;
import java.lang.annotation.*;
import javax.ws.rs.core.*;

@Produces("application/json")
public class ListReservationWriter implements MessageBodyWriter<ReservationList>{
	 
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
         return ReservationList.class.isAssignableFrom(type);
     }

     public void writeTo(ReservationList reservationList, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
    	 reservationList.toJSON().write(new OutputStreamWriter(entityStream));
     }
}
