package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		Integer room = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = SDF.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = SDF.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} 
		else {

			Reservation reservation = new Reservation(room, checkin, checkout);

			System.out.println("Reservation: " + reservation);

			System.out.println("");
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = SDF.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = SDF.parse(sc.next());

			Date now = new Date();
			
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} 
			else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} 
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation: " + reservation);
			}
		}

		sc.close();
	}

}
