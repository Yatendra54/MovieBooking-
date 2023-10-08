package com;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookMyShowImpl  implements BookMyShow{

	Scanner scan = new Scanner(System.in);
	Map<Integer,Movie> db=new LinkedHashMap<Integer,Movie>();
	int totalCost=0;

	@Override
	public void addMovie() {
		db.put(1, new Movie("dhool ", 500, 150));
		db.put(2, new Movie("OMG ", 400, 250));
		db.put(3, new Movie("MI", 600, 350));

	}

	@Override
	public void displayMovie() {
		Set<Integer>keys=db.keySet();
		for(int key:keys) {
			Movie m=db.get(key);
			System.out.println("Enter  "+key+ "to Book Tickets for "+m.getName());
			System.out.println("Available Ticket: "+m.getTickets());
			System.out.println("Cost: Rs."+m.getCost());
			System.out.println("------------------------");
		}
	}

	@Override
	public void bookMovie() {
		System.out.println("Enter Choice:");//choice - >key
		int choice=scan.nextInt();

		Movie movie=db.get(choice);//Movie movie=Movie Object - >KGF-1

		if(movie!=null) {
			System.out.println("Selected Movie is: "+movie.getName());
			System.out.println("Enter Number of Tickets:");
			int tickets=scan.nextInt();

			if(tickets<=movie.getTickets()) {
				System.out.println("Ticket Available");
				// Calculating Current Ticket Cost
				int currentCost=tickets * movie.getCost();

				//Updating New Tickets Available
				movie.setTickets(movie.getCost()-tickets);

				//Adding current cost to totalCost - > totalCost += currentCost;
				totalCost=totalCost+currentCost;//totalCost+=currentCost

				System.out.println("Booking successful");
				System.out.println("******************");
				System.out.println("Movie Name: "+movie.getName());
				System.out.println("No of Tickets Booked: "+tickets);
				System.out.println("Movie Ticket Cost: "+currentCost);
				System.out.println("*******************************");
			}
			else {
				System.out.println("Tckect is Not Available");
			}

		}
		else {
			System.out.println("Invalid Choice");
		}


	}

	@Override
	public void checkout() {
		System.out.println("Your Toal Ticket Cost: Rs. "+totalCost);

	}

}
