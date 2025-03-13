/*
	Student Name: Ali Shahbaz Aman
	Student ID: 12165410
	Submission Date: 23/04/2021
	Class: COIT20245 - Introduction to Programming
	Assessment 1: Yeppoon Caravan Park Booking and Discount Prices
	Purpose: To exercise the fundamentals of Java learned during classes which include input/output operations, Classes, If and While Statements, and
		basic arithmetic problems conducted in Java
*/

import java.util.Scanner; // imports the Java Scanner Utility
public class YeppoonCaravanPark // the class name using capital camel notation which matched the java file name
{
	public static void main (String [] args) // using the java main method
	{
		final int STANDARD_NUMBER_OF_NIGHTS = 5; // Constant variable defining the first five nights
		final double STANDARD_NIGHT_PRICE = 14.50; // Constant variable defining the per night price of the first five nights
		final double STANDARD_GUEST_PRICE = 4.95; // Constant variable defining the per night guest of the first five nights
		final int DISCOUNT_NUMBER_OF_NIGHTS_1 = 10; // Constant variable defining nights 6 to 10
		final double DISCOUNT_NIGHT_PRICE_1 = 12.50; // Constant variable defining the per night price of nights 6 to 10
		final double DISCOUNT_GUEST_PRICE_1 = 3.95; // Constant variable defining the per guest price of nights 6 to 10
		final double DISCOUNT_NIGHT_PRICE_2 = 10.50; // Constant variable defining the per night price of nights over 10
		final double DISCOUNT_GUEST_PRICE_2 = 2.95; // Constant variable defining the per guest price of nights over 10
		double chargePerNight = 0;
		double chargePerGuest = 0;

		int i = 0; // constant value
		final int N = 6; // number of loops. Assigned based on the largest number on my student ID
		int numberOfNights = 0;
		int numberOfGuests = 0;
		double bookingCharge = 0; // total charge per booking
		int min = Integer.MAX_VALUE; // minimum nights spent in a booking
		String minBookingName = null; // used to assign the booking name to the minimum value
		int max = Integer.MIN_VALUE; // maximum nights spent in a booking
		String maxBookingName = null; // used to assign the booking name to the minimum value
		double average = 0; // average of nights per booking
		double totalCharge = 0; // total charge for all N bookings

		System.out.printf("Welcome to the Yeppoon Caravan Park Management System%n%n%n"); // welcome message

		Scanner input = new Scanner(System.in);

		while(i < N) // while loop
		{
			System.out.print("Please enter your booking name ==> "); // input for users to add their name
			String bookingName = input.nextLine(); // input code
			while (bookingName.equals("")) // code that doesn't allow users to leave the input blank
			{
				System.out.println("ERROR - booking name cannot be blank"); // error message if left blank
				System.out.print("Please enter your booking name ==> "); // input prompt sent again after the error
				bookingName = input.nextLine();
			}

			System.out.printf("Enter the number of nights stay for %s ==> ", bookingName);  // input for users to add the number of nights they're staying
			numberOfNights = input.nextInt(); // input code
			while (numberOfNights <= 0) // code that doesn't allow users enter anything under 1
			{
				System.out.println("ERROR - the number of nights must be greater than or equal to 1"); // error message
				System.out.printf("Enter the number of nights stay for %s ==> ", bookingName); // input prompt sent again after the error
				numberOfNights = input.nextInt();
			}

			System.out.printf("Enter the number of guests for %s ==> ", bookingName); // input for users to add the number of guests staying
			numberOfGuests = input.nextInt(); // input code
			input.nextLine(); // code to send back to the first input for a new entry/booking
			while (numberOfGuests <= 0) // code that doesn't allow users enter anything under 1
			{
				System.out.println("ERROR - the number of guests must be greater than or equal to 1"); // error message
				System.out.printf("Enter the number of guests for %s ==> ", bookingName); // prompt sent again after the error
				numberOfGuests = input.nextInt();
				input.nextLine(); // code to send back to the first input for a new entry/booking
			}

				i++; // post increment for loops

			if (numberOfNights <= 5) // if statement to select the range of prices
			{
				chargePerNight = STANDARD_NIGHT_PRICE * numberOfNights; // per night standard price
				chargePerGuest = STANDARD_GUEST_PRICE * numberOfGuests; // per guest standard price
			}
			else if (numberOfNights > 5 && numberOfNights <= 10) // else if statement for the next range of discount prices
			{
				chargePerNight = DISCOUNT_NIGHT_PRICE_1 * numberOfNights; // per night discount price 1
				chargePerGuest = DISCOUNT_GUEST_PRICE_1 * numberOfGuests; // per guest standard price 1
			}
			else // else statement for the last range of discount prices
			{
				chargePerNight = DISCOUNT_NIGHT_PRICE_2 * numberOfNights; // per night discount price 2
				chargePerGuest = DISCOUNT_GUEST_PRICE_2 * numberOfGuests; // per guest standard price 2
			}

			bookingCharge = (double)chargePerNight + chargePerGuest; // price per booking
			totalCharge += (double)bookingCharge; // total price of all bookings in N
			average += (double)numberOfNights / N; // average nights per booking code

			if (numberOfNights < min) // minimum number of nights in a booking code
			{
				min = numberOfNights; // obtaining the minimum amount of nights
				minBookingName = bookingName; // obtaining the booking name for the minimum amount of nights
			}

			if (numberOfNights > max) // maximum number of nights in a booking code
			{
				max = numberOfNights; // obtaining the maximum amount of nights
				maxBookingName = bookingName; // obtaining the booking name for the maximum amount of nights
			}

		System.out.printf("The charge for %s for %d night(s) and %d guest(s) is $%.2f%n%n", bookingName, numberOfNights, numberOfGuests, bookingCharge);
				// printing output using printf to get the relevant details every booking
		}

		System.out.printf("%n%nStatistical Information for Yeppoon Caravan Park%n%n"); // statistical information output header followed by statistical statements below

		System.out.printf("%s has the minimum number of %d nights%n", minBookingName, min);
		System.out.printf("%s has the maximum number of %d nights%n", maxBookingName, max);
		System.out.printf("The average number of nights stay per booking is: %.2f nights%n" , average);
		System.out.printf("The total charges collected is $%.2f%n", totalCharge);

		System.out.printf("%n%n%nThank you for using Yeppoon Caravan Park Management System%n"); // end message
		System.out.printf("Program written by 12165410%n%n"); // my student ID

	}
}