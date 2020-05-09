package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.customer.Customer;
import model.customer.MembershipOptions;
import model.customer.MusicLover;
import model.customer.Premium;
import model.customer.TVLover;
import model.customer.VideoLover;
import model.media.BoxSet;
import model.media.Format;
import model.media.LiveConcert;
import model.media.Media;
import model.media.Movie;
import model.media.Music;
import rent.Rent;
//import rent.Rent;
import view.View;

public class Controller {

	private View view; // initialising the link between view and controller @WillianVoelz
	private List<Customer> customerList = new ArrayList<Customer>(); // arraylist of customers @WillianVoelz
	private int customerCount = 1; // counter for customer ID , it increases by 1 every customer added.
	private Scanner scannerCustomer; // @WillianVoelz
	boolean exitMainMenu = false; // boolean initialised for do while loop in the main Menu @WillianVoelz
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// declaring BufferedReader
																							// @Edwards
	private Scanner scannerMedia; // @Edwards
	private List<Media> mediaList = new ArrayList<Media>(); // @Edwards
	private List<Rent> rentedTitlesList = new ArrayList<Rent>();

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
		String email = "invalid"; // not the best solution, but that's what I could think about
		while (!isEmailValid(email)) { // so it calls the loop automatically
			System.out.println("Enter valid customer email:");
			email = scannerCustomer.nextLine();
		}
		System.out.println("Select subcription: ");
		view.printMembershipOptions(); // prompt membership options
		while (!scannerCustomer.hasNextInt()) { // while name is not correct, keep looping asking for letters
			// only
			System.out.println("Only 1-4 allowed ");
			view.printMembershipOptions();
			scannerCustomer.next();
		}
		int membershipOption = scannerCustomer.nextInt();

		if (membershipOption == 1) { // if statements, create different Customers according to subscription chosen
			customerList.add(new MusicLover(id, name, email, MembershipOptions.MUSICLOVER));

		} else if (membershipOption == 2) {
			customerList.add(new VideoLover(id, name, email, MembershipOptions.VIDEOLOVER));

		} else if (membershipOption == 3) {
			customerList.add(new TVLover(id, name, email, MembershipOptions.TVLOVER));

		} else if (membershipOption == 4) {
			customerList.add(new Premium(id, name, email, MembershipOptions.PREMIUM));
		} else {
			System.out.println("Subscription type not found: ");
			addCustomer();
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
			System.out.println("New Email: ");
			String newEmail = scannerCustomer.nextLine();
			while (!isEmailValid(newEmail)) { // so it calls the loop automatically
				System.out.println("Enter valid customer email:");
				newEmail = scannerCustomer.nextLine();
			}

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

	/*
	 * -------- From this point, all methods are related to Media manipulation. We
	 * had problems working with two different controllers, so the solution was put
	 * all the code in the same controller.
	 * 
	 * @EdwardsJr ---------
	 */

	// all the comments for "adding Media" methods in general are in the addMovie
	// method
	// only @EdwardsJr
	public void addMovie() {

		br = new BufferedReader(new InputStreamReader(System.in));
		int mediaID = mediaList.size() + 1;// checking the size of the array to create new ID
		String mediaName = null;
		Format mediaType = null;
		int mediaReleaseYear = 0;
		String mediaGenre = null;
		String mediaDirector = null;
		int choice = 0;

		try {
			scannerMedia = new Scanner(System.in);
			System.out.println("Enter movie title: ");
			mediaName = br.readLine().toUpperCase();

			do {
				System.out.println("Enter media format: \n1 - DVD \n2 - BluRay");
				choice = scannerMedia.nextInt();
				try {// validate user input for format
					if (choice == 1) {
						mediaType = Format.DVD;// defined by an enum
					} else if (choice == 2) {
						mediaType = Format.BluRay;// defined by an enum
					}
				} catch (Exception e) {
					System.out.println("Please choose one of the available formats");
				}
			} while ((choice < 1) || (choice > 2));

			while (true) {// validate user input for year
				try {
					System.out.println("Enter the release year: ");
					mediaReleaseYear = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Only numbers are allowed!");
				}
			}
			System.out.println("Enter the genre: ");
			mediaGenre = br.readLine().toUpperCase();
			System.out.println("Enter the director: ");
			mediaDirector = br.readLine().toUpperCase();
			System.out.println("");

		} catch (IOException e) {
			System.out.println("Something went wrong, please restart the application!");
		}
		mediaList.add(new Movie(mediaID, mediaName, mediaType, mediaReleaseYear, mediaGenre, mediaDirector,
				MembershipOptions.VIDEOLOVER));// creating new object and adding to the list

		System.out.println("\nMovie successfully created!");// printing the results
		System.out.println("ID Number: " + mediaID);
		System.out.println("Title: " + mediaName);
		System.out.println("Format: " + mediaType);
		System.out.println("Release Year: " + mediaReleaseYear);
		System.out.println("Genre: " + mediaGenre);
		System.out.println("Director: " + mediaDirector);

		view.addAnotherMediaDialog();// asking the user for further actions

	}

	public void addBoxSet() {// @EdwardsJr

		br = new BufferedReader(new InputStreamReader(System.in));
		int mediaID = mediaList.size() + 1;
		String mediaName = null;
		Format mediaType = null;
		int mediaReleaseYear = 0;
		int numberOfSeasons = 0;
		String mediaGenre = null;
		int choice = 0;

		try {
			scannerMedia = new Scanner(System.in);
			System.out.println("Enter TV Show title: ");
			mediaName = br.readLine().toUpperCase();

			do {
				System.out.println("Enter media format: \n1 - DVD \n2 - BluRay");
				choice = scannerMedia.nextInt();
				try {// validate user input for format
					if (choice == 1) {
						mediaType = Format.DVD;// defined by an enum
					} else if (choice == 2) {
						mediaType = Format.BluRay;// defined by an enum
					}
				} catch (Exception e) {
					System.out.println("Please choose one of the available formats");
				}
			} while ((choice < 1) || (choice > 2));

			while (true) {// validate user input for year
				try {
					System.out.println("Enter the release year: ");
					mediaReleaseYear = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Only numbers are allowed!");
				}
			}

			System.out.println("Enter the genre: ");
			mediaGenre = br.readLine().toUpperCase();

			while (true) {// validate user input for number of seasons
				try {
					System.out.println("Enter the number of seasons: ");
					mediaReleaseYear = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Only numbers are allowed!");
				}
			}
			System.out.println("");
		} catch (IOException e) {
			System.out.println("Something went wrong, please restart the application!");
		}
		mediaList.add(new BoxSet(mediaID, mediaName, mediaType, mediaReleaseYear, mediaGenre, numberOfSeasons,
				MembershipOptions.VIDEOLOVER));

		System.out.println("\nTV Show successfully created!");
		System.out.println("ID Number: " + mediaID);
		System.out.println("Title: " + mediaName);
		System.out.println("Format: " + mediaType);
		System.out.println("Release Year: " + mediaReleaseYear);
		System.out.println("Genre: " + mediaGenre);
		System.out.println("Number of Seasons: " + numberOfSeasons);

		view.addAnotherMediaDialog();

	}

	public void addMusic() {// @EdwardsJr

		br = new BufferedReader(new InputStreamReader(System.in));
		int mediaID = mediaList.size() + 1;
		String mediaName = null;
		int mediaReleaseYear = 0;
		String mediaBandName = null;

		try {
			scannerMedia = new Scanner(System.in);
			System.out.println("Enter a record name: ");
			mediaName = br.readLine().toUpperCase();

			while (true) {// validate user input for year
				try {
					System.out.println("Enter the release year: ");
					mediaReleaseYear = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Only numbers are allowed!");
				}
			}

			System.out.println("Enter an Artist/Band name: ");
			mediaBandName = br.readLine().toUpperCase();
			System.out.println("");
		} catch (IOException e) {
			System.out.println("Something went wrong, please restart the application!");
		}
		mediaList.add(new Music(mediaID, mediaName, mediaReleaseYear, mediaBandName, MembershipOptions.MUSICLOVER));

		System.out.println("\nMusic record successfully created!");
		System.out.println("ID Number: " + mediaID);
		System.out.println("Title: " + mediaName);
		System.out.println("Format: " + Format.CD);
		System.out.println("Release Year: " + mediaReleaseYear);
		System.out.println("Band/Artist: " + mediaBandName);

		view.addAnotherMediaDialog();

	}

	public void addLiveConcert() {// @EdwardsJr

		br = new BufferedReader(new InputStreamReader(System.in));
		int mediaID = mediaList.size() + 1;
		String mediaName = null;
		int mediaReleaseYear = 0;
		Format mediaType = null;
		String mediaBandName = null;
		int choice = 0;

		try {
			scannerMedia = new Scanner(System.in);
			System.out.println("Enter a record name: ");
			mediaName = br.readLine().toUpperCase();

			do {
				System.out.println("Enter media format: \n1 - DVD \n2 - BluRay");
				choice = scannerMedia.nextInt();
				try {// validate user input for format
					if (choice == 1) {
						mediaType = Format.DVD;// defined by an enum
					} else if (choice == 2) {
						mediaType = Format.BluRay;// defined by an enum
					}
				} catch (Exception e) {
					System.out.println("Please choose one of the available formats");
				}
			} while ((choice < 1) || (choice > 2));

			while (true) {// validate user input for year
				try {
					System.out.println("Enter the release year: ");
					mediaReleaseYear = Integer.parseInt(br.readLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Only numbers are allowed!");
				}
			}

			System.out.println("Enter an Artist/Band name: ");
			mediaBandName = br.readLine().toUpperCase();
			System.out.println("");
		} catch (IOException e) {
			System.out.println("Something went wrong, please restart the application!");
		}
		mediaList.add(new LiveConcert(mediaID, mediaName, mediaType, mediaReleaseYear, mediaBandName,
				MembershipOptions.MUSICLOVER));

		System.out.println("Movie was successfully created!\n");
		System.out.println("ID Number: " + mediaID);
		System.out.println("Title: " + mediaName);
		System.out.println("Format: " + mediaType);
		System.out.println("Release Year: " + mediaReleaseYear);
		System.out.println("Band/Artist: " + mediaBandName);

		view.addAnotherMediaDialog();

	}

	public void searchMediaName() {// @EdwardsJr

		Media searchedMedia = null;
		scannerMedia = new Scanner(System.in);
		System.out.println("Search Media by Name");
		String search = scannerMedia.nextLine();

		for (Media myMedia : mediaList) {
			if (myMedia.getMediaName() != null && myMedia.getMediaName().equalsIgnoreCase(search)) {
				searchedMedia = myMedia;
				System.out.println("Here are the results:\n");
				System.out.println("ID: " + searchedMedia.getMediaID());
				System.out.println("Title: " + searchedMedia.getMediaName());
				System.out.println("Year: " + searchedMedia.getMediaReleaseYear());
				System.out.println("Media Format: " + searchedMedia.getMediaType());
				System.out.println("Membership type: " + searchedMedia.getMembershipOptions());
				// TODO include a isAvailable return here and an option to rent the title from
				// here
				view.searchAnotherMedia();
			}
		}
		System.out.println("Media not found");
		view.searchAnotherMedia();
	}

	public void searchMediaID() {// @EdwardsJr

		scannerCustomer = new Scanner(System.in);
		System.out.println("Enter ID: ");
		int inputID = scannerCustomer.nextInt();
		Media result = null;

		for (Media resultID : mediaList) {
			if (inputID == resultID.getMediaID()) {
				result = resultID;
				System.out.println("Here are the results:\n");
				System.out.println("ID: " + result.getMediaID());
				System.out.println("Title: " + result.getMediaName());
				System.out.println("Year: " + result.getMediaReleaseYear());
				System.out.println("Media Format: " + result.getMediaType());
				System.out.println("Membership Type" + result.getMembershipOptions());
				// TODO include a isAvailable return here and an option to rent the title from
				// here
				view.searchAnotherMedia();
			}
		}
		System.out.println("Media not found");
		view.searchAnotherMedia();
	}

	// methods to fill the arrays with data
	public void fillMediaList() {// @EdwardsJr

		// the list handles all kinds of Media
		// no need to set format for Music objects, because it is defined in the
		// constructor -> can only be CD
		mediaList
				.add(new Movie(1, "BACURAU", Format.BluRay, 1995, "HORROR", "HITCHCOCK", MembershipOptions.VIDEOLOVER));
		mediaList.add(
				new Movie(2, "PARASITE", Format.DVD, 2019, "THRILLER", "PT ANDERSON", MembershipOptions.VIDEOLOVER));
		mediaList.add(new Movie(3, "MELANCHOLIA", Format.BluRay, 2015, "DRAMA", "LARS VON TRIER",
				MembershipOptions.VIDEOLOVER));
		mediaList.add(new Movie(4, "PSYCHO", Format.DVD, 1970, "HORROR", "Hitchcock", MembershipOptions.VIDEOLOVER));
		mediaList.add(
				new Movie(5, "SWALLOW", Format.BluRay, 1995, "COMEDY", "COFFIN JOE", MembershipOptions.VIDEOLOVER));
		mediaList.add(new Music(6, "EXTRAORDINARY MACHINE", 2000, "FIONA APPLE", MembershipOptions.MUSICLOVER));
		mediaList.add(new Music(7, "PARKLIVE", 2012, "BLUR", MembershipOptions.MUSICLOVER));
		mediaList.add(new Music(8, "THE ERASER", 2006, "THOM YORKE", MembershipOptions.MUSICLOVER));
		mediaList.add(new Music(9, "AMNESIAC", 2001, "RADIOHEAD", MembershipOptions.MUSICLOVER));
		mediaList.add(new Music(10, "UTOPIA", 2017, "BJORK", MembershipOptions.MUSICLOVER));
		mediaList.add(
				new LiveConcert(11, "MTV UNPLUGGED", Format.BluRay, 1993, "NIRVANA", MembershipOptions.MUSICLOVER));
		mediaList.add(new LiveConcert(12, "IN RAINBOWS", Format.DVD, 2015, "RADIOHEAD", MembershipOptions.MUSICLOVER));
		mediaList.add(new LiveConcert(13, "LIVE AT MONTEREY", Format.BluRay, 1970, "JIMI HENDRIX",
				MembershipOptions.MUSICLOVER));
		mediaList
				.add(new LiveConcert(14, "LIVE IN CUBA", Format.DVD, 2005, "AUDIOSLAVE", MembershipOptions.MUSICLOVER));
		mediaList.add(
				new LiveConcert(15, "UNPLUGGED", Format.BluRay, 2000, "ALICE IN CHAINS", MembershipOptions.MUSICLOVER));
		mediaList.add(new BoxSet(16, "FRIENDS", Format.DVD, 2005, "COMEDY", 5, MembershipOptions.TVLOVER));
		mediaList.add(new BoxSet(17, "DEXTER", Format.BluRay, 1997, "DRAMA", 6, MembershipOptions.TVLOVER));
		mediaList.add(new BoxSet(18, "LOST", Format.BluRay, 2015, "HORROR", 7, MembershipOptions.TVLOVER));
		mediaList.add(new BoxSet(19, "YEARS AND YEARS", Format.DVD, 1985, "DRAMA", 1, MembershipOptions.TVLOVER));
		mediaList.add(new BoxSet(20, "UNBELIEVABLE", Format.BluRay, 2000, "THRILLER", 2, MembershipOptions.TVLOVER));

	}

	public void viewMediaList() {// listing all the list elements using iterator @EdwardsJr

		Iterator<Media> litr = mediaList.iterator();
		System.out.println("Complete media list:");
		while (litr.hasNext()) {
			System.out.println(litr.next());
		}
		view.exitQuestion();
	}

	/*
	 * -------- From this point, all methods are related to Rent manipulation.
	 * 
	 * @EdwardsJr ---------
	 */

	public void fillRentList() {//just for test purposes

		Iterator<Rent> litr = rentedTitlesList.iterator();
		System.out.println("Complete rent list:");
		while (litr.hasNext()) {
			System.out.println(litr.next());
		}

	}

	public void addRent() {

		// Iterator<Media> mediaIterator = mediaList.iterator();
		// Iterator<Customer> customerIterator = customerList.iterator();

		LocalDate rentDate = LocalDate.now();// setting the date for now
		LocalDate returnDate = rentDate.plusDays(3);// adding 3 days to set the return

		scannerCustomer = new Scanner(System.in);
		System.out.println("Enter customer ID: ");
		int customerID = scannerCustomer.nextInt();

		for (Customer resultID : customerList) {
			if (customerID == resultID.getID()) {
				System.out.println("Customer ID: " + resultID.getID());
				System.out.println("Customer Name: " + resultID.getName());
			}
		}

		scannerMedia = new Scanner(System.in);
		System.out.println("Enter media ID: ");
		int mediaID = scannerCustomer.nextInt();

		for (Media resultID : mediaList) {
			if (mediaID == resultID.getMediaID()) {
				System.out.println("Media ID: " + resultID.getMediaID());
				System.out.println("Media Name " + resultID.getMediaName());
				System.out.println("Media Format: " + resultID.getMediaType());
			}
		}
		
		System.out.println("Date of rent: " + rentDate);
		System.out.println("Date of return: " + returnDate);
		

		rentedTitlesList.add(new Rent(1, customerID, mediaID, rentDate, returnDate, "customer status", isAvailable(false)));
		System.out.println(rentedTitlesList);
		//fillRentList();
		

		view.exitQuestion();
		//fillRentList();
		
	}
	

	public void returnRent() {

	}

	public void loyaltyPoints(int points) {

	}

	public boolean isAvailable(boolean b) {
		return false;
	}

	public void checkCustomerStatus() {
//		return true;
		// TODO: check if customer has a media rented and check the return date
	}

}
