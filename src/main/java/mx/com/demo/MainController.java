package mx.com.demo;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONObject;

import io.muserver.openapi.SchemaObject;
import io.muserver.openapi.SchemaObjectBuilder;
import io.muserver.rest.ApiResponse;
import io.muserver.rest.Description;
import io.muserver.rest.SchemaObjectCustomizer;
import io.muserver.rest.SchemaObjectCustomizerContext;
import mx.com.hsbc.dto.ReservationDto;
import mx.com.hsbc.dto.ReservationList;
import mx.com.hsbc.dto.ResponseEntity;
import mx.com.hsbc.service.RestaurantService;

import static java.util.Arrays.asList;

@Path("/restaurant/")
@Description(value = "restaurant bookings", details = "Use this API to manage reservations in a restaurant")
public class MainController implements SchemaObjectCustomizer {
	
	@GET
    @Path("/sayHello")
    @Produces("application/json")
	@Description(value = "Hello world", details = "Use this API only to try")
    public String sayHello() {
		System.out.println("entramos? ");
		JSONObject json = null;
		try {
			json = new JSONObject(new ReservationDto("Christian"));	
		} catch (Exception e) {
			e.printStackTrace();
	    }
		return json.toString();
	}
	
	 @POST
     @Path("/client/reserve")
     @Produces("application/json")
	 @ApiResponse(code = "200", message = "Success")
     @ApiResponse(code = "500", message = "there arent reservations")
	 @Description(value = "A booking service", details = "Use this API to create a booking")
     public String reserve(ReservationDto reservation) {
		 System.out.println("Reservation: " + reservation.toString());
		 ResponseEntity response = null;
		 try {
			 RestaurantService restaurantService = new RestaurantService();
			 response = restaurantService.makeReservation(reservation);
			 System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new JSONObject(response).toString();	
	 }
	 
	 @POST
     @Path("/owner/getReservations")
     @Produces("application/json")
	 @ApiResponse(code = "200", message = "Success")
     @ApiResponse(code = "500", message = "Error to recover list of reservations")
	 @Description(value = "List of bookings", details = "Use this API by the restaurant owner to recover reservations by date")
     public String getListReservations(ReservationList paramDate) {
		 System.out.println("Reservation: " + paramDate.toString());
		 ResponseEntity response = null;
		 try {
			 RestaurantService restaurantService = new RestaurantService();
			 response = restaurantService.getReservationsByDay(paramDate.getFechaListado());
			 System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new JSONObject(response).toString();	
	 }

	@Override
	public SchemaObjectBuilder customize(SchemaObjectBuilder builder, SchemaObjectCustomizerContext context) {
		if (context.resource() == this && context.type().equals(ReservationList.class)) {
            Map<String, SchemaObject> props = new HashMap<>();
            props.put("name", SchemaObjectBuilder.schemaObjectFrom(String.class).build());
            props.put("price", SchemaObjectBuilder.schemaObjectFrom(double.class).build());
            builder.withProperties(props)
                .withRequired(asList("fechaListado"))
                // If a map is given as an example object, then the properties are listed separately.
                // Alternatively, a string can be given as the example.
                .withExample(new ReservationList("24/03/2024").toJSON().toMap());
        }
        return builder;
	}
	 
	 
}
