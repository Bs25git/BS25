package reservation.model.vo;

import java.sql.Date;

public class Reservation {
	
	private String email;
	private Date reserveDate; 
	
	public Reservation() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	@Override
	public String toString() {
		return "Reservation [email=" + email + "]";
	}
}
