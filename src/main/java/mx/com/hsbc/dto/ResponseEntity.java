package mx.com.hsbc.dto;

public class ResponseEntity {
	private String message;
	private Integer responseCode;
	private String exceptionDetail;
	
	
	public ResponseEntity() {
	}
	
	
	public ResponseEntity(String message, Integer responseCode, String exceptionDetail) {
		this.message = message;
		this.responseCode = responseCode;
		this.exceptionDetail = exceptionDetail;
	}



	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getExceptionDetail() {
		return exceptionDetail;
	}
	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

	@Override
	public String toString() {
		return "ResponseEntity [message=" + message + ", responseCode=" + responseCode + ", exceptionDetail="
				+ exceptionDetail + "]";
	}
	
}
