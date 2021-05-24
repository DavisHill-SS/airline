package users;

import java.util.Scanner;

public class Traveler {
	
	public Traveler() {
		
	}
	
	public void menu() {
		Integer input = 0;
		Scanner scan = new Scanner(System.in);
		while(input != 3) {
			System.out.println("1 to book a reservation");
			System.out.println("2 to cancel a reservation");
			System.out.println("3 to quit to previous menu");
			try {
				input = scan.nextInt();
				switch(input) {
				case 1:
					bookReservation();
					break;
				case 2:
					cancelReservation();
					break;
				case 3:
					break;
				default:
					System.out.println("Please enter 1, 2, or 3");
					break;
				}
			}
			catch(Exception e){
				System.out.println("Please enter 1, 2, or 3");
				//e.printStackTrace();
			}

		}
		scan.close();
	}
	
	public void bookReservation() {
		//retrieve list of flights: flight.readAll();
		//user chooses a flight
		//get flight id: flight.getId();
		//create new booking
		//create new passenger
		//add one reserved seat to flight
	}
	
	public void cancelReservation() {
		//find reservation by booking_id of passenger
		//delete booking_id from booking table
		
	}

}
