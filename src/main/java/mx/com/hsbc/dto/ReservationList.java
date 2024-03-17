package mx.com.hsbc.dto;

import org.json.JSONObject;

public class ReservationList {
	private String fechaListado;
	
	public ReservationList() {
	}

	public ReservationList(String fechaListado) {
		this.fechaListado = fechaListado;
	}

	public String getFechaListado() {
		return fechaListado;
	}

	public void setFechaListado(String fechaListado) {
		this.fechaListado = fechaListado;
	}
	
	public JSONObject toJSON() {
        return new JSONObject()
            .put("fechaListado", fechaListado);
    }

	@Override
	public String toString() {
		return "ReservationList [fechaListado=" + fechaListado + "]";
	}
	
}
