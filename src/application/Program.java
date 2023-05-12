package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.ReservationException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			Integer room = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = SDF.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = SDF.parse(sc.next());
	
			Reservation reservation = new Reservation(room, checkin, checkout);
	
			System.out.println("Reservation: " + reservation);
	
			System.out.println("");
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = SDF.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = SDF.parse(sc.next());
	
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format.");
		}
		catch (ReservationException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}

		sc.close();
	}

}
