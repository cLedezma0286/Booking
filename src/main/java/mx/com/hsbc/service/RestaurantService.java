package mx.com.hsbc.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mx.com.hsbc.dto.ReservationDto;
import mx.com.hsbc.dto.ResponseEntity;
import mx.com.hsbc.entities.Reservation;
import mx.com.hsbc.util.HibernateUtil;
import mx.com.hsbc.util.TimeAndDateUtils;

public class RestaurantService {
	private final Integer ERROR_CODE = -1;
	private final Integer SUCCESS_CODE = 0;

	@SuppressWarnings("deprecation")
	public ResponseEntity makeReservation(ReservationDto res) {
		 Transaction transaction = null;
		 ResponseEntity response = new ResponseEntity();
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 Date dateRes = TimeAndDateUtils.getDateFromString(res.getDate());
			 Time hourRes = TimeAndDateUtils.getTimeFromString(res.getHour());
			 Reservation reserve = new Reservation(res.getClientName(),hourRes,dateRes, res.getNumTable(),res.getNumAssistants());
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the reserve objects
	            session.save(reserve);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            response = new ResponseEntity("Error al persistir entidad", ERROR_CODE, e.getMessage());
	            e.printStackTrace();
	        }
		 	response = new ResponseEntity("Operation was successfully!" , SUCCESS_CODE, "");
	       
	     return response;
	    
	}
	
	public ResponseEntity getReservationsByDay(String dateReservations) {
		 ResponseEntity response = new ResponseEntity();
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 	Date fechaRes = TimeAndDateUtils.getDateFromString(dateReservations);
			 	List < Reservation > reservations = session.createQuery("from Reservation where resDate =:resDate ", Reservation.class)
						.setParameter("resDate", fechaRes)
						.list();
//			 	List < Reservation > reservations = query.list();
//	            List < Reservation > reservations = session.createQuery("from Reservation where resDate = ", Reservation.class).list();
	            for (Reservation rsv : reservations) {
	            	System.out.println("client: " + rsv.toString());
				}
	            response = new ResponseEntity("response \n: " + reservations.toString(), SUCCESS_CODE, "");
	     } catch (Exception e) {
	            response = new ResponseEntity("Error al recuperar listado de reservas", ERROR_CODE, e.getMessage());
	            e.printStackTrace();
	     }
		 return response;
	}
}
