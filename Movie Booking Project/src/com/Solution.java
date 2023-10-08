package com;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args)  {

		Scanner scan=new Scanner(System.in);
		BookMyShow bms=new BookMyShowImpl();

		bms.addMovie();

		int choice=1;
		while(choice==1) {

			bms.displayMovie();
			bms.bookMovie();
			System.out.println("Press 1 to continue  ");
			System.out.println("any othe number to checkout");
			choice=scan.nextInt();
			System.out.println("--------------------------------");
		}
		bms.checkout();
	}
}
