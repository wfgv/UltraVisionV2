package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.customer.Customer;

public class Controller {

	private List<Customer> customerList = new ArrayList<>();
	boolean stop = false;
	Scanner option;

	public Controller() {
		Menu();

	}

	public void printMenu() {
		System.out.println("* Ultra Vision *");
		System.out.println("\nPlease select one of the following options");
		System.out.println("\n0 - Add Customer");
		System.out.println("1 - Update Customer");
		System.out.println("2 - Search Customer");
		System.out.println("3 - Add Title");
		System.out.println("4 - Update Title");
		System.out.println("5 - Search Title");
		System.out.println("6 - Rent Title");
		System.out.println("7 - Return Title");
		System.out.println("8 - Membership Options");
		System.out.println("9 - Exit");
	}

	public void Menu() {

		do {

			try {
				printMenu();

				int choice;

				option = new Scanner(System.in);

				choice = option.nextInt();
				stop = false;

				switch (choice) {
				case 0:
					System.out.println("Option 0");

					addCustomer();

					break;

				case 1:
					System.out.println("Option 1");
					viewCustomer();

					break;

				case 2:
					System.out.println("Option 2");

					break;

				case 3:
					System.out.println("Option 3");
					break;

				case 4:
					System.out.println("Option 4");
					break;

				case 5:
					System.out.println("Option 5");
					break;

				case 6:
					System.out.println("Option 6");
					break;

				case 7:
					System.out.println("Option 7");
					break;

				case 8:
					System.out.println("Option 8");
					break;

				case 9:
					System.out.println("Option 9");
					stop = true;
					break;
				default:
					System.out.println("Please enter a valid number");
					break;

				}

			} catch (InputMismatchException e) {
				System.out.println("Only numbers 1 to 9 - Please, try again");
				Menu();
			}
		} while (!stop);

	}

	public void addCustomer() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter customer ID: ");
		int id = Integer.parseInt(input.nextLine());
		System.out.println("Enter customer Name: ");
		String name = input.nextLine();
		System.out.println("Enter customer email: ");
		String email = input.nextLine();

		Customer c1 = new Customer(id, name, email);
		customerList.add(c1);

		System.out.println(name + " was succesfully added as a customer!");
		System.out.println("ID Number: " + id);
		System.out.println("email: " + email);

	}

	public void viewCustomer() {
		System.out.println(customerList);
	}

}
