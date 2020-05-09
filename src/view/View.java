package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.Controller;

public class View {

	private Controller controller;

	boolean exitMainMenu = false; // boolean initialised for do while loop in the main Menu @WillianVoelz
	private Scanner myScanner;// @WillianVoelz

	private Scanner menuOption; // scanner to be used inside the switch menu @EdwardsJr

	public View(Controller controller) {
		this.controller = controller;
	}

//	}
	// ---------- Method responsible for ONLY printing the Menu Options--------
	// @WillianVoelz
	public void printMenu() {
		System.out.println("* Ultra Vision *");
		System.out.println("\nPlease select one of the following options");
		System.out.println("\n1 - Add Customer");
		System.out.println("2 - Search Customer");
		System.out.println("3 - Update Customer");
		System.out.println("4 - Add Title");
		System.out.println("5 - Search Title");
		System.out.println("6 - Rent Title");
		System.out.println("7 - Return Title");
		System.out.println("8 - Check Loyalty Points");
		System.out.println("9 - Exit");
	}

	// ------------ Method responsible for ONLY printing the Membership Options
	// @WillianVoelz

	public void printMembershipOptions() {
		System.out.println("1 - MUSIC lover");
		System.out.println("2 - VIDEO Lover");
		System.out.println("3 - TV Lover");
		System.out.println("4 - PREMIUM");
	}

	// - Method responsible for taking user Input and redirect to specific method
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
				case 1:
					System.out.println("Option 1: Add New Customer: ");
					controller.addCustomer();
					break;
				case 2:
					controller.viewCustomer();
					System.out.println("Option 2: Search for Customer: ");
					System.out.println("Please select Search: \n1- Name \n2- ID");
					choice = myScanner.nextInt();
					if (choice == 1 || choice == 01) {
						controller.searchCustomerByName();
					}
					if (choice == 2 || choice == 02) {
						controller.searchCustomerByID();
					}
					if (choice == 3 || choice == 03) {
						printMenu();
					} else {
						printMenu();
					}
					break;
				case 3:
					System.out.println("Option 3: Update Customer ");
					System.out.println(
							"Please select: \n1-Update customer Name: \n2-Update customer Email: \n3- Update customer Subscription: ");
					choice = myScanner.nextInt();
					if (choice == 1 || choice == 01) {
						controller.updateCustomerName();
					}
					if (choice == 2 || choice == 02) {
						controller.updateCustomerEmail();
					}
					if (choice == 3 || choice == 03) {
						controller.updateSubscription();
					} else {
						printMenu();
					}
					break;
				case 4:// add media @EdwardsJr
					System.out.println(
							"Please select the type of media to be added:  \n1 - Movie \n2 - Music \n3 - Live Concert \n4 - BoxSet \n5 - Return to Main Menu");
					int option = menuOption.nextInt();
					if (option == 1) {
						controller.addMovie();
					} else if (option == 2) {
						controller.addMusic();
					} else if (option == 3) {
						controller.addLiveConcert();
					} else if (option == 4) {
						controller.addBoxSet();
					} else if (option == 5) {
						printMenu();
					}
					break;
				case 5:// search media @EdwardsJr
					System.out.println("Please choose the kind of search: \n1 - Title \n2 - ID \n3 - List all available Media");
					int option1 = menuOption.nextInt();
					if (option1 == 1) {
						controller.searchMediaName();
					} else if (option1 == 2) {
						controller.searchMediaID();
					} else {
						controller.viewMediaList();
					}
					break;
				case 6:
					System.out.println("Rent Title");
					controller.addRent();
					break;
				case 7:
					System.out.println("Return Title");
					break;
				case 8:
					System.out.println("Membership Options");
					controller.checkLoyaltyPoints();
					break;
				case 9:
					System.out.println("Ultra Vision terminated");
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

	// Simple if statement method that takes input from user to go ahead with
	// operations.
	// this method is designed to pause the Menu do/while loop and let customer
	// decide to go ahead.
	// @WillianVoelz
	public void exitQuestion() {

		System.out.println("\nPress:\n1 - Return to Main Menu ");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();
		if (choice == 1 || choice == 01) {
			Menu();
		} else {
			exitQuestion();
		}
	}

	// Add another customer while still in the addCustomer Method
	// @WillianVoelz
	public void addAnotherCustomerQuestion() {
		System.out.println("\nPress: \n1 to Menu \n2 to Add Another Customer");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();

		if (choice == 1 || choice == 01) {
			Menu();
		}
		if (choice == 2 || choice == 02) {
			controller.addCustomer();

		} else {
			exitQuestion();
		}

	}

	// Search another customer or go back to Menu
	// @WillianVoelz
	public void searchAnotherCustomer() {

		System.out.println(
				"\nPress: \n1 to Menu  \n2 to search Another Customer by Name \n3 Search another customer by ID ");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();

		if (choice == 1 || choice == 01) {
			Menu();

		} else if (choice == 2 || choice == 02) {

			controller.searchCustomerByName();
		} else if (choice == 3 || choice == 03) {

			controller.searchCustomerByID();
		} else {
			searchAnotherCustomer();
		}

	}

	// add another media or go back to menu
	// @EdwardsJr
	public void addAnotherMediaDialog() {
		System.out.println("\nChoose: \n1 Menu \n2 Add Movie \n3 Add Music \n4 Add Live Concert \n5 Add Box Set");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();

		if (choice == 1 || choice == 01) {
			Menu();
		}
		if (choice == 2 || choice == 02) {
			controller.addMovie();
		}
		if (choice == 3 || choice == 03) {
			controller.addMusic();
		}
		if (choice == 4 || choice == 04) {
			controller.addLiveConcert();
		}
		if (choice == 5 || choice == 05) {
			controller.addBoxSet();
		} else {
			exitQuestion();
		}

	}

	// search another media or go back to menu
	// @EdwardsJr
	public void searchAnotherMedia() {

		System.out.println("\nChoose: \n1 Menu \n2 Search Media by Name \n3 Search Media by ID");
		myScanner = new Scanner(System.in);
		int choice = myScanner.nextInt();

		if (choice == 1 || choice == 01) {
			Menu();
		}
		if (choice == 2 || choice == 02) {
			controller.searchMediaName();
		} else if (choice == 3 || choice == 03) {
			controller.searchMediaID();
		} else {
			searchAnotherMedia();
		}

	}

}
