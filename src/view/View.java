package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.Controller;
import controller.MediaController;
import model.customer.Customer;
import model.media.Movie;
import model.media.Music;

public class View {

	private Controller controller; // @WillianVoelz
	private Scanner myScanner;
	boolean exitMainMenu = false; // boolean initialised for do while loop in the main Menu @WillianVoelz
	private Scanner menuOption; // scanner to be used inside the switch menu @EdwardsJr
	private MediaController mc; // instantiating MediaController class @EdwardsJr

	// UNUSED VARIABLES/ATTRIBUTES
	// private List<Customer> customerList = new ArrayList<>(); // arraylist of
	// customers @WillianVoelz
	// private List<Movie> movieList = new ArrayList<>();
	// private List<Music> musicList = new ArrayList<>();
	// private int customerCount = 0; // counter for customer ID , it increases by 1
	// every customer added.

	public View(Controller controller) {
		this.controller = controller;
		// controller = new Controller();

	}
	// ---------- Method responsible for ONLY printing the Menu Options--------

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

	// -------------------------- Method responsible for ONLY printing the
	// Membership Options --------------------------
//		@WillianVoelz
	public void printMembershipOptions() {
		System.out.println("1 - MUSIC lover");
		System.out.println("2 - VIDEO Lover");
		System.out.println("3 - TV Lover");
		System.out.println("4 - PREMIUM");
	}

	// ------------------- Method responsible for taking user Input and redirect to
	// specific method ------------
	public void Menu() {

		do { // do while loop to keep the menu showing up until the Exit option is being
				// called. - Bug prevention loop. (Program never stops)

			try {
				printMenu(); // prompt
				int choice; // used to store user choice
				myScanner = new Scanner(System.in); // initialise Scanner called option
				choice = myScanner.nextInt(); // nextInt to take user input and store in choice variable
				exitMainMenu = false; // boolean set to false, it stops the program once true;
				menuOption = new Scanner(System.in);// initialise Scanner for options inside the switch menu @EdwardsJr

				switch (choice) {
				case 0:
					System.out.println("Option 0");
					controller.addCustomer();
					break;
				case 1:
					System.out.println("Option 1");
					controller.viewCustomer();
					break;
				case 2:
					System.out.println("Option 2");
					controller.searchCustomerByName();
					break;
				case 3:
					System.out.println("Option 3");// add media
					mc = new MediaController();
					System.out.println(
							"Please select the type of media to be added:  \n1 - Movie \n2 - Music \n3 - Live Concert \n4 - BoxSet \n5 - Return to Main Menu");
					int option = menuOption.nextInt();
					if (option == 1) {
						System.out.println("Adding a Movie record: ");
						mc.addMovie();
						// printMenu();
					} else if (option == 2) {
						System.out.println("Adding a Music record: ");
						mc.addMusic();
					} else if (option == 3) {
						System.out.println("Adding a Live Concert record: ");
						mc.addLiveConcert();
					} else if (option == 4) {
						System.out.println("Adding a Box Set record: ");
						mc.addBoxSet();
					} else if (option == 5) {
						printMenu();
					}
					break;
				case 4:
					System.out.println("Option 4");// update media
					// if statement here to choose which type of media to update
					break;
				case 5:
					System.out.println("Option 5");// search
					// if statement here to choose which type of media to search
					mc = new MediaController();
					mc.searchMovie();
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
					exitMainMenu = true;
					break;
				default:
					System.out.println("Please enter a valid number");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Only numbers 1 to 9 - Please, try again"); // catch letters or anything except
																				// numbers
				Menu();
			}
		} while (!exitMainMenu); // !exitMainMenu = true .. if true = kills program before loop

	}

	public void exitQuestion() { // Simple if statement method that takes input from user to go ahead with
									// operations.
		// this method is designed to stop the Menu do/while loop. @WillianVoelz
		System.out.println("\nPress: \n1 to menu ");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();

		if (choice == 1 || choice == 01) {
			Menu();
		} else {

			exitQuestion();
		}

	}

	public void searchAnotherCustomer() { //  @WillianVoelz
		
		System.out.println("\nPress: \n1 to Menu  \n2 to search Another Customer ");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();

		if (choice == 1 || choice == 01) {
			Menu();
		
		} else if( choice == 2 ||choice == 02){

			controller.searchCustomerByName();
		}else {
			searchAnotherCustomer();
		}

	}

}
