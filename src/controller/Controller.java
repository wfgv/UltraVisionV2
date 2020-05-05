package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.customer.Customer;
import model.customer.MembershipOptions;
import model.customer.MusicLover;
import model.customer.Premium;
import model.customer.TVLover;
import model.customer.VideoLover;
import model.media.Format;
import model.media.Media;
import model.media.Movie;
import model.media.Music;
import view.View;

public class Controller {

	private View view; // initialising the link between view and controller
	private List<Customer> customerList = new ArrayList<Customer>(); // arraylist of customers @WillianVoelz
	private int customerCount = 1; // counter for customer ID , it increases by 1 every customer added.
	private Scanner scannerCustomer; // @WillianVoelz
	boolean exitMainMenu = false; // boolean initialised for do while loop in the main Menu @WillianVoelz
//---------------------Edwards--------------
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// declaring BufferedReader
	private Scanner scannerMedia;
	private List<Media> mediaList = new ArrayList<Media>();
	private int mediaCounter = 1;

	public Controller() {
		view = new View(this);
		fillCustomerList();
		fillMediaList();
		view.Menu();
	}

	// -------------------------- New Customer Registration
	// --------------------------
	// @WillianVoelz
	public void addCustomer() {

		scannerCustomer = new Scanner(System.in);

		int id = customerCount;
		System.out.println("Enter customer Name: ");
		while (!scannerCustomer.hasNext("[a-zA-Z]+")) { // while name is not correct, keep looping asking for letters
														// only
			System.out.println("Please use only letters! \nEnter Customer Name: ");
			scannerCustomer.nextLine();
		}
		String name = scannerCustomer.nextLine();
		System.out.println("Enter customer email: ");
		String email = scannerCustomer.nextLine();
		while (!isEmailValid(email)) {
			System.out.println("Email Invalid \nEnter valid email:");
			scannerCustomer.nextLine();
		}
		scannerCustomer.nextLine();
		System.out.println("Select subcription: ");
		view.printMembershipOptions(); // prompt membership options
		int membershipOption = scannerCustomer.nextInt();
		if (membershipOption == 1) { // if statements, create different Customers according to subscription chosen

			customerList.add(new MusicLover(id, name, email, MembershipOptions.MUSICLOVER));
			// musicLoverList.add(ml);
		} else if (membershipOption == 2) {
			customerList.add(new VideoLover(id, name, email, MembershipOptions.VIDEOLOVER));

		} else if (membershipOption == 3) {
			customerList.add(new TVLover(id, name, email, MembershipOptions.TVLOVER));

		} else if (membershipOption == 4) {
			customerList.add(new Premium(id, name, email, MembershipOptions.PREMIUM));

		}

		System.out.println(name + " was succesfully added as a customer!");
		System.out.println("ID Number: " + id);
		System.out.println("email: " + email);
		// System.out.println("Subscription: " + ml.getMembership());

		customerCount = customerCount + 1; // add +1 for the ID variable each new customer created.

		view.addAnotherCustomerQuestion(); // method that doesn't let the Menu loop back instantly
		// it requires user permission beforehand.

	}

	static boolean isEmailValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);

		// /^\\S+@\\S+\\.\\S+$/
	}

	// ----------------- View Customer - print arrayList with all details (test
	// purposes )--------------------------
	// @WillianVoelz
	public void viewCustomer() {

		System.out.println("All customers registered:");
		System.out.println(customerList);
	}

	// -------------- Search customer by NAME ------------------
	// @WillianVoelz
	public void searchCustomerByName() {

		scannerCustomer = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String inputName = scannerCustomer.nextLine();
		Customer result = null;

		for (Customer c : customerList) {
			if (inputName.equalsIgnoreCase(c.getName())) {
				result = c;
				System.out.println("Customer found: ");
				System.out.println(result);
				view.searchAnotherCustomer();
			}
		}
		System.out.println("Customer not found");
		view.searchAnotherCustomer();
	}

	// -------------- Search customer by NAME ------------------
	// @WillianVoelz
	public void searchCustomerByID() {

		scannerCustomer = new Scanner(System.in);
		System.out.println("Enter ID: ");
		int inputID = scannerCustomer.nextInt();
		Customer result = null;

		for (Customer c : customerList) {
			if (inputID == c.getID()) {
				result = c;
				System.out.println("Customer found: ");
				System.out.println(result);
				view.searchAnotherCustomer();

			}
		}
		System.out.println("Customer not found");
		view.searchAnotherCustomer();

	}

	public boolean isCustomerRegistered(int ID) {

		for (Customer c : customerList) {
			if (ID == c.getID()) {

				return true;

			}
		}

		return false;

	}

	// -------------- Update customer Subscription using customer ID
	// ------------------
	// @WillianVoelz
	public void updateSubscription() {
		scannerCustomer = new Scanner(System.in);
		System.out.println("Input Member ID: ");
		int customerID = scannerCustomer.nextInt();
		if (!isCustomerRegistered(customerID)) {
			System.out.println("Customer not found.\n");
			view.exitQuestion();
		} else {

			System.out.println("Update to: \n1-Music Lover \n2-VideoLover \n3-TVLover \n4-Premium");
			int newSubscription = scannerCustomer.nextInt();

			if (newSubscription == 1) {
				customerList.get(customerID - 1).setMembership(MembershipOptions.MUSICLOVER);
			} else if (newSubscription == 2) {
				customerList.get(customerID - 1).setMembership(MembershipOptions.VIDEOLOVER);
			} else if (newSubscription == 3) {
				customerList.get(customerID - 1).setMembership(MembershipOptions.TVLOVER);
			} else if (newSubscription == 4) {
				customerList.get(customerID - 1).setMembership(MembershipOptions.PREMIUM);
			}

			System.out.println("Customer subscription updated");
			view.exitQuestion();
		}
	}

	public void updateCustomerName() {
		scannerCustomer = new Scanner(System.in);
		System.out.println("Input Member ID to change Name: ");
		int customerID = scannerCustomer.nextInt();

		if (!isCustomerRegistered(customerID)) {
			System.out.println("Customer not found.\n");
			view.exitQuestion();
		} else if (isCustomerRegistered(customerID)) {
			scannerCustomer = new Scanner(System.in);
			System.out.println("New name: ");
			String newName = scannerCustomer.nextLine();

			customerList.get(customerID - 1).setName(newName);

			System.out.println("Customer Name updated");
			view.exitQuestion();
		}
	}

	public void updateCustomerEmail() {
		scannerCustomer = new Scanner(System.in);
		System.out.println("Input Member ID to change Email: ");
		int customerID = scannerCustomer.nextInt();

		if (!isCustomerRegistered(customerID)) {
			System.out.println("Customer not found.\n");
			view.exitQuestion();
		} else if (isCustomerRegistered(customerID)) {
			scannerCustomer = new Scanner(System.in);
			System.out.println("New name: ");
			String newEmail = scannerCustomer.nextLine();

			customerList.get(customerID - 1).setEmail(newEmail);

			System.out.println("Customer Email updated");
			view.exitQuestion();
		}
	}

	// methods to fill the arrays with data
	public void fillCustomerList() {

		Customer musicLover1 = new MusicLover(20, "Renan", "renan@cct.ie", MembershipOptions.MUSICLOVER);
		Customer videoLover1 = new VideoLover(21, "Jorge", "jorge@cct.ie", MembershipOptions.VIDEOLOVER);
		Customer TVLover1 = new TVLover(22, "Marta", "marta@cct.ie", MembershipOptions.TVLOVER);
		Customer premium1 = new Premium(23, "Leyla", "leyla@cct.ie", MembershipOptions.PREMIUM);

		customerList.add(musicLover1);
		customerList.add(videoLover1);
		customerList.add(TVLover1);
		customerList.add(premium1);

	}

// 
	// Methods split ------------------------------------------------
	public void addMovie() {

		br = new BufferedReader(new InputStreamReader(System.in));

		int mediaID = mediaCounter;// increasing the ID
		String mediaName = null;
		Format mediaType = null;
		int mediaReleaseYear = 0;
		String mediaGenre = null;
		String mediaDirector = null;
		int choice = 0;
		Movie movie = null;

		try {
			scannerMedia = new Scanner(System.in);
			System.out.println("Enter movie name: ");
			mediaName = br.readLine();

			try {
				System.out.println("Enter media type: \n1 - DVD \n2 - BluRay");
				choice = scannerMedia.nextInt();
				if (choice == 1) {
					mediaType = Format.DVD;
				} else if (choice == 2) {
					mediaType = Format.BluRay;
				}
			} catch (Exception e) {
				System.out.println("Please, use one of the options");
			}

			System.out.println("Enter the release year: ");
			mediaReleaseYear = Integer.parseInt(br.readLine());
			System.out.println("Enter the genre: ");
			mediaGenre = br.readLine();
			System.out.println("Enter the director: ");
			mediaDirector = br.readLine();
			System.out.println("");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mediaList.add(new Movie(mediaID, mediaName, mediaType, mediaReleaseYear, mediaGenre, mediaDirector,
				MembershipOptions.VIDEOLOVER));
		// movieList.add(movie);
//			mediaList.add((mediaID + 1), movie);

		// ask to confirm object creation
		System.out.println("Movie was successfully created!\n");
		System.out.println("ID Number: " + mediaID);
		System.out.println("Title: " + mediaName);
		System.out.println("Format: " + mediaType);
		System.out.println("Release Year: " + mediaReleaseYear);
		System.out.println("Genre: " + mediaGenre);
		System.out.println("Director: " + mediaDirector);
		System.out.println(mediaList);

		mediaCounter = mediaCounter + 1;
		view.exitQuestion();

	}

	public void searchMedia() {

		Media searchedMovie = null;
		scannerMedia = new Scanner(System.in);
		System.out.println("Search movies by Name, Genre ou Director: ");
		String search = scannerMedia.nextLine();

		for (Media myMedia : mediaList) {
			if (myMedia.getMediaName() != null && myMedia.getMediaName().equalsIgnoreCase(search)
					&& myMedia.getMediaName().matches("^[a-zA-Z-]*$")) {
				searchedMovie = myMedia;
				System.out.println("Here are the results:\n");
				System.out.println(searchedMovie);
				//view.exitQuestion();
			}
			

		}
		System.out.println("Media not found");
		view.exitQuestion();
		
		// TODO : create new Method in View searchAnotherMedia( ) ;
		// return searchedMovie;
	}

	// methods to fill the arrays with data
	public void fillMediaList() {

		// List<Media> mediaList = new ArrayList<>();
		Movie movie1 = new Movie(199, "Bacurau", Format.BluRay, 1995, "Horror", "Hitchcock",
				MembershipOptions.VIDEOLOVER);
		Movie movie2 = new Movie(198, "Parasite", Format.DVD, 2019, "Thriller", "PT Anderson",
				MembershipOptions.VIDEOLOVER);
		Movie movie3 = new Movie(197, "Melancholia", Format.BluRay, 2015, "Drama", "Lars Von Trier",
				MembershipOptions.VIDEOLOVER);
		Movie movie4 = new Movie(196, "Psycho", Format.DVD, 1970, "Horror", "Hitchcock", MembershipOptions.VIDEOLOVER);
		Movie movie5 = new Movie(195, "Swallow", Format.BluRay, 1995, "Comedy", "Coffin Joe",
				MembershipOptions.VIDEOLOVER);

		mediaList.add(movie1);
		mediaList.add(movie2);
		mediaList.add(movie3);
		mediaList.add(movie4);
		mediaList.add(movie5);

		// return movieList;

	}

	public void viewMediaList() { // just testing purposes (Option 6)
		System.out.println(mediaList);
		view.exitQuestion();

	}
}
