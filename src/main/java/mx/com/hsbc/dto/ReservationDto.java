package mx.com.hsbc.dto;

public class ReservationDto {
	private String clientName;
	private String hour;
	private String date;
	private Integer numTable;
	private Integer numAssistants;
	
	public ReservationDto() {
	}
	
	public ReservationDto(String clientName) {
		this.clientName = clientName;
	}
	
	public ReservationDto(String clientName, String hour, String date, Integer numTable, Integer numAssistants) {
		this.clientName = clientName;
		this.hour = hour;
		this.date = date;
		this.numTable = numTable;
		this.numAssistants = numAssistants;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
		return "Reservation [clientName=" + clientName + ", hour=" + hour + ", date=" + date + ", numTable=" + numTable
				+ ", numAssistants=" + numAssistants + "]";
	}
	
	
}
