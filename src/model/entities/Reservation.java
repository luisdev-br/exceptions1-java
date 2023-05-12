package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.ReservationException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		
		if (!checkOut.after(checkIn)) {
			throw new ReservationException("Error in reservation: Check-out date must be after check-in date");
		} 
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) {
		
		Date now = new Date();
		
		if (checkin.before(now) || checkout.before(now)) {
			throw new ReservationException("Error in reservation: Reservation dates for update must be future dates");
		} 
		
		if (!checkout.after(checkin)) {
			throw new ReservationException("Error in reservation: Check-out date must be after check-in date");
		} 
		
		this.checkIn = checkin;
		this.checkOut = checkout;
		
	}
	
	@Override
	public String toString() {
		return "Room " +
				roomNumber +
				", check-in: " +
				SDF.format(checkIn) +
				", check-out: " +
				SDF.format(checkOut) +
				", " +
				duration() +
				" nights";
				
	}

}
