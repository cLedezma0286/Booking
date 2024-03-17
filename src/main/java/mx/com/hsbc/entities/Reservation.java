package mx.com.hsbc.entities;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
	private Integer reservationId;
    @Column(name = "nom_client")
    private String nomclient;
	@Column(name = "res_hour")
	private Time resHour;
	@Column(name = "res_date")
	private Date resDate;
	@Column(name = "num_table")
	private Integer numTable;
	@Column(name = "num_assistants")
	private Integer numAssistants;
	
	public Reservation() {
	}

	public Reservation(String nomclient, Time resHour, Date resDate, Integer numTable, Integer numAssistants) {
		this.nomclient = nomclient;
		this.resHour = resHour;
		this.resDate = resDate;
		this.numTable = numTable;
		this.numAssistants = numAssistants;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public String getNomclient() {
		return nomclient;
	}

	public void setNomclient(String nomclient) {
		this.nomclient = nomclient;
	}

	public Time getResHour() {
		return resHour;
	}

	public void setResHour(Time resHour) {
		this.resHour = resHour;
	}

	public Date getResDate() {
		return resDate;
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}

	public Integer getNumTable() {
		return numTable;
	}
	public void setNumTable(Integer numTable) {
		this.numTable = numTable;
	}
	public Integer getNumAssistants() {
		return numAssistants;
	}
	public void setNumAssistants(Integer numAssistants) {
		this.numAssistants = numAssistants;
	}

	@Override
	public String toString() {
		return "Reservation [nomclient=" + nomclient + ", resHour=" + resHour + ", resDate=" + resDate + ", numTable="
				+ numTable + ", numAssistants=" + numAssistants + "]";
	}



}
