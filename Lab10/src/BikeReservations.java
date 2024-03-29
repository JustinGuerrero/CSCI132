import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lab 09
 * 
 * This lab is meant to do two things for you: 1. Give you some experience
 * working with Java's ArrayList class, and 2. get you used to checking and
 * handling input.
 * 
 * It may be useful to warm up with a Tester class and make an
 * ArrayList<Integer> just to try out some methods. For some reference material,
 * check out the ArrayList API documentation, and review exception handling from
 * Week 6. Also recall that the textbook has a good technique on p 40 for how to
 * get a valid type from the user.
 * 
 * Begin the lab by downloading the BikeRental and BikeReservations classes. You
 * will not have to modify BikeRental, but there are some TODO tags in the
 * BikeReservations file, which mark the tasks for this lab, each with hints.
 * 
 * Take some time to read and understand the code. Add some print statements and run 
 * the debugger if you're unsure of what something is doing.
 * 
 * 2 pts - TODO 1. Ensure user enters an integer. (see textbook p 40)
 * 2 pts - TODO 2. Allow reservation only if requested bike is available. (see ArrayList API)
 * 2 pts - TODO 3. Handle IndexOutOfBoundsException (see week 06 example; textbook p 82)
 * 2 pts - TODO 4. Check bike in and make it available. Don't accept bad input. (see above)
 * 2 pts - TODO 5. Print out all of the bike reservation data (see existing methods)
 * 
 */

public class BikeReservations {

	// Fields

	final static int NUMBIKES = 10;

	// Constructor

	public BikeReservations() {

		Scanner src = new Scanner(System.in);
		String menuChoice = "";
		String firstName, lastName;
		int hoursRented;
		int bikeID = -1;
		BikeRental newBike;

		//
		ArrayList<BikeRental> bikeListing = new ArrayList<BikeRental>();

		addBikes(bikeListing);
		makeBikesAvailable(bikeListing);

		while (!menuChoice.equals("Q")) {
			System.out.println();
			System.out.print("(L)ist Reservations, (R)eserve Bike, (C)heck In, or (Q)uit > ");
			menuChoice = src.next().toUpperCase();

			if (menuChoice.equals("L")) {
				printBikeListing(bikeListing);
			} 
			else if (menuChoice.equals("R")) {
				System.out.print("Bike ID: ");

				// TODO: 1. Ensure user enters an integer. (see textbook p 40, and below*)

				while(!src.hasNextInt()){
					src.nextLine();
					System.out.println("Please enter an valid choice ya doink");
				}

				while(bikeID < 0 || bikeID > 9){

					try{
						//read in bikeID from user input
						bikeID = src.nextInt();
						bikeListing.get(bikeID);
						if(bikeListing.get(bikeID).isAvailable()) {
							System.out.print("First name: ");
							firstName = src.next();
							System.out.print("Last name: ");
							lastName = src.next();
							System.out.print("Hours rented: ");

							while (!src.hasNextInt()) {        // *Ensure user enters an integer.
								src.next();
								System.out.println("Enter hours");
							}
							hoursRented = src.nextInt();

							newBike = new BikeRental();
							newBike.checkBikeOut(firstName, lastName, hoursRented);
							bikeListing.set(bikeID, newBike);
							System.out.println("Reservation Complete.");

						}
						else{
							System.out.println("That bike is not available, try again");
						}

					}catch(IndexOutOfBoundsException e){
						System.out.println("Oh YoU ThOUghT yOu WeRE fUnNy, EnTEr A nuMbEr");


					}


				}
				bikeID = -1;





				// TODO: 2. Allow reservation only if requested bike is available. (see ArrayList API)

				// TODO: 3. Handle IndexOutOfBoundsException (see week 06 example; textbook p 82)


			} 
			else if (menuChoice.equals("C")) {

				System.out.print("Bike ID: ");
				while(!src.hasNextInt()){
					src.nextLine();
					System.out.println("Please enter an valid choice ya doink");
				}

				while(bikeID < 0 || bikeID > 9){

					try{
						//read in bikeID from user input
						bikeID = src.nextInt();
						BikeRental wreckedBike = bikeListing.get(bikeID);
						if(!wreckedBike.isAvailable()) {
							wreckedBike.checkBikeIn();
							System.out.println("YOOOOOO YOU WRECKED THAT SHIT BUT WE GOT YOU FAM");
						}
						else{
							System.out.println("That bike is not available, try again");
						}

					}catch(IndexOutOfBoundsException e){
						System.out.println("Oh YoU ThOUghT yOu WeRE fUnNy, EnTEr A nuMbEr");


					}


				}
				bikeID = -1;
				
				// TODO: 4. Check bike in and make it available. Don't accept bad input. (see above TODOS)

	
			} 
			else if (menuChoice.equals("Q")) {
				System.out.println("<end>");
			} 
			else {
				System.out.println("Choose P, C, R, or Q");
			}
		}
		src.close();

	}

	// Methods

	public void addBikes(ArrayList<BikeRental> bikes) {
		for (int i = 0; i < NUMBIKES; ++i) {
			bikes.add(new BikeRental());
		}
	}

	public void makeBikesAvailable(ArrayList<BikeRental> bikes) {
		for (int i = 0; i < bikes.size(); ++i) {
			bikes.get(i).checkBikeIn();
		}
	}

	public void printBikeListing(ArrayList<BikeRental> bikes) {
		System.out.println("BikeID\tFirst\tLast\tHours");
		int bikeID = 0;
		for(BikeRental bike : bikes){
			bike.printReservation(bikeID);
			bikeID++;
		}

	}

	public static void main(String[] args) {

		new BikeReservations();
	}

}
