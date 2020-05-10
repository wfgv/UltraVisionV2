package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
import view.View;

public class Controller {

	private View view; // initialising the link between view and controller @WillianVoelz
	private List<Customer> customerList = new ArrayList<Customer>(); // arraylist of customers @WillianVoelz
	// private int customerCount = 1; // counter for customer ID , it increases by 1
	// every customer added.
	private Scanner scannerCustomer; // @WillianVoelz
	boolean exitMainMenu = false; // boolean initialised for do while loop in the main Menu @WillianVoelz
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// declaring BufferedReader
																							// @Edwards
	private Scanner scannerMedia; // @Edwards
	private List<Media> mediaList = new ArrayList<Media>(); // @Edwards
	private List<Rent> rentedTitlesList = new ArrayList<Rent>();
	private Customer customer;
	private Media media;

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

		int id = customerList.size() + 1;
		System.out.println("Enter customer Name: ");
		while (!scannerCustomer.hasNext("[a-zA-Z]+")) { // while name is not correct, keep looping asking for letters
														// only
			System.out.println("Please use only letters! \nEnter Customer Name: ");
			scannerCustomer.nextLine().toUpperCase();
		}
		String name = scannerCustomer.nextLine().toUpperCase();
		;
		String email = "invalid"; // not the best solution, but that's what I could think about
		while (!isEmailValid(email)) { // so it calls the loop automatically
			System.out.println("Enter valid customer email:");
			email = scannerCustomer.nextLine().toUpperCase();
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
			customerList.add(new MusicLover(id, name, email, MembershipOptions.MUSICLOVER, 0));

		} else if (membershipOption == 2) {
			customerList.add(new VideoLover(id, name, email, MembershipOptions.VIDEOLOVER, 0));

		} else if (membershipOption == 3) {
			customerList.add(new TVLover(id, name, email, MembershipOptions.TVLOVER, 0));

		} else if (membershipOption == 4) {
			customerList.add(new Premium(id, name, email, MembershipOptions.PREMIUM, 0));
		} else {
			System.out.println("Subscription type not found: ");
			addCustomer();
		}

		System.out.println(name + " was succesfully added as a customer!");
		System.out.println("ID Number: " + id);
		System.out.println("email: " + email);
		// System.out.println("Subscription: " + ml.getMembership());

		// customerCount = customerCount + 1; // add +1 for the ID variable each new
		// customer created.

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
			String newName = scannerCustomer.nextLine().toUpperCase();

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
			String newEmail = scannerCustomer.nextLine().toUpperCase();
			while (!isEmailValid(newEmail)) { // so it calls the loop automatically
				System.out.println("Enter valid customer email:");
				newEmail = scannerCustomer.nextLine().toUpperCase();
			}

			customerList.get(customerID - 1).setEmail(newEmail);

			System.out.println("Customer Email updated");
			view.exitQuestion();
		}
	}

	// methods to fill the arrays with data
	public void fillCustomerList() {

		Customer musicLover1 = new MusicLover(1, "RENAN", "RENAN@CCT.IE", MembershipOptions.MUSICLOVER, 0);
		Customer videoLover1 = new VideoLover(2, "JORGE", "JORGE@CCT.IE", MembershipOptions.VIDEOLOVER, 0);
		Customer TVLover1 = new TVLover(3, "MARTA", "MARTA@CCT.IE", MembershipOptions.TVLOVER, 0);
		Customer premium1 = new Premium(4, "LEYLA", "LEYLA@CCT.IE", MembershipOptions.PREMIUM, 90);

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
				MembershipOptions.VIDEOLOVER, true));// creating new object and adding to the list

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
				MembershipOptions.VIDEOLOVER, true));

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
		mediaList.add(
				new Music(mediaID, mediaName, mediaReleaseYear, mediaBandName, MembershipOptions.MUSICLOVER, true));

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
				MembershipOptions.MUSICLOVER, true));

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
		mediaList.add(new Movie(1, "BACURAU", Format.BluRay, 1995, "HORROR", "HITCHCOCK", MembershipOptions.VIDEOLOVER,
				true));
		mediaList.add(new Movie(2, "PARASITE", Format.DVD, 2019, "THRILLER", "PT ANDERSON",
				MembershipOptions.VIDEOLOVER, true));
		mediaList.add(new Movie(3, "MELANCHOLIA", Format.BluRay, 2015, "DRAMA", "LARS VON TRIER",
				MembershipOptions.VIDEOLOVER, true));
		mediaList.add(
				new Movie(4, "PSYCHO", Format.DVD, 1970, "HORROR", "Hitchcock", MembershipOptions.VIDEOLOVER, true));
		mediaList.add(new Movie(5, "SWALLOW", Format.BluRay, 1995, "COMEDY", "COFFIN JOE", MembershipOptions.VIDEOLOVER,
				true));
		mediaList.add(new Music(6, "EXTRAORDINARY MACHINE", 2000, "FIONA APPLE", MembershipOptions.MUSICLOVER, true));
		mediaList.add(new Music(7, "PARKLIVE", 2012, "BLUR", MembershipOptions.MUSICLOVER, true));
		mediaList.add(new Music(8, "THE ERASER", 2006, "THOM YORKE", MembershipOptions.MUSICLOVER, true));
		mediaList.add(new Music(9, "AMNESIAC", 2001, "RADIOHEAD", MembershipOptions.MUSICLOVER, true));
		mediaList.add(new Music(10, "UTOPIA", 2017, "BJORK", MembershipOptions.MUSICLOVER, true));
		mediaList.add(new LiveConcert(11, "MTV UNPLUGGED", Format.BluRay, 1993, "NIRVANA", MembershipOptions.MUSICLOVER,
				true));
		mediaList.add(
				new LiveConcert(12, "IN RAINBOWS", Format.DVD, 2015, "RADIOHEAD", MembershipOptions.MUSICLOVER, true));
		mediaList.add(new LiveConcert(13, "LIVE AT MONTEREY", Format.BluRay, 1970, "JIMI HENDRIX",
				MembershipOptions.MUSICLOVER, true));
		mediaList.add(new LiveConcert(14, "LIVE IN CUBA", Format.DVD, 2005, "AUDIOSLAVE", MembershipOptions.MUSICLOVER,
				true));
		mediaList.add(new LiveConcert(15, "UNPLUGGED", Format.BluRay, 2000, "ALICE IN CHAINS",
				MembershipOptions.MUSICLOVER, true));
		mediaList.add(new BoxSet(16, "FRIENDS", Format.DVD, 2005, "COMEDY", 5, MembershipOptions.TVLOVER, true));
		mediaList.add(new BoxSet(17, "DEXTER", Format.BluRay, 1997, "DRAMA", 6, MembershipOptions.TVLOVER, true));
		mediaList.add(new BoxSet(18, "LOST", Format.BluRay, 2015, "HORROR", 7, MembershipOptions.TVLOVER, true));
		mediaList.add(new BoxSet(19, "YEARS AND YEARS", Format.DVD, 1985, "DRAMA", 1, MembershipOptions.TVLOVER, true));
		mediaList.add(
				new BoxSet(20, "UNBELIEVABLE", Format.BluRay, 2000, "THRILLER", 2, MembershipOptions.TVLOVER, true));

	}

	public void viewMediaList() {// listing all the elements using iterator @EdwardsJr

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
	 * @EdwardsJr AND @WillianVoelz---------
	 *
	 */

	public void fillRentList() {// just for test purposes

		Iterator<Rent> litr = rentedTitlesList.iterator();
		System.out.println("Complete rent list:");
		while (litr.hasNext()) {
			System.out.println(litr.next());
		}

	}

	public void addRent() {

		LocalDate rentDate = LocalDate.now();// setting the date for now
		LocalDate returnDate = rentDate.plusDays(3);// adding 3 days to set the return

		scannerCustomer = new Scanner(System.in);
		System.out.println("Enter customer ID: ");
		int customerID = scannerCustomer.nextInt();

		for (Customer resultID : customerList) {
			if (customerID == resultID.getID()) {
				System.out.println("Customer ID: " + resultID.getID());
				System.out.println("Customer Name: " + resultID.getName());
				System.out.println("Membership type: " + resultID.getMembership());

				// new instance of the object CUSTOMER, so we can use all the details inside
				// this method
				customer = new Customer(resultID.getID(), resultID.getName(), resultID.getEmail(),
						resultID.getLoyaltyPoints());
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
				System.out.println("Media Type: " + resultID.getClass());

				// new instance of the object MEDIA, so we can use all the details inside this
				// method
				media = new Media(resultID.getMediaID(), resultID.getMediaName(), resultID.getMediaType(),
						resultID.getMediaReleaseYear(), resultID.isAvailable());
			}
		}

		if (media.isAvailable() == false) {
			System.out.println("Sorry, media is not available at the moment!");
			view.exitQuestion();
		}

		// method that check the customer subscription with the type of media that is
		// being rented
		if (!isMatchSubscription(mediaID, customerID)) {
			System.out.println("Subscription doesn't match with media Membership Option");
			view.exitQuestion();
		}
		// Method to check if customer has 100 loyalty points
		if (freeRent(customerID)) {
			System.out.println("Free rent! There is no need to pay for this one");
		}

		System.out.println(
				"Rent media " + media.getMediaName() + " to customer " + customer.getName() + " ? \n1 Yes \n2 No");
		int option = scannerCustomer.nextInt();
		if (option == 1) {

			int total = getNumberOfTitlesRented();

			if (total > 4) {
				System.out.println(
						"Sorry, you have reached your limit of titles per customer. Please return a title in order to rent another one");
			}

			else {
				// method located inside Customer class, it increases the loyaltyPoints int;
				customerList.get(customerID - 1).add10PointsPerRent();
				customer.setMediaRented(media);

				System.out.println("\nMedia Rent confirmation: \nCustomer: " + customerID + "\nMedia: " + mediaID
						+ "\nRent Date: " + rentDate + "\nReturn Date: " + returnDate + "\nLoyalty Points: "
						+ customer.getLoyaltyPoints());
				
				media.setAvailable(false);// setting the availability to false after rent confirmation
				rentedTitlesList.add(new Rent(mediaID = rentedTitlesList.size() + 1, customerID, customer.getName(),
						mediaID, media.getMediaName(), rentDate, returnDate, setMediaRented(media.getMediaID())));
				
				//adding the results to a new array, to collect only the rented titles and setting the media availability to FALSE
				//rentedTitlesList.add(new Rent(mediaID = rentedTitlesList.size() + 1, customer.getID(), customer.getName(), media.getMediaID(), media.getMediaName(), rentDate, returnDate, false));

				view.exitQuestion();
			}
			view.exitQuestion();
		}
	}

	public int getNumberOfTitlesRented() {

		/*
		 * Starts the counter at one ignoring the index which starts in zero search for
		 * a specific customer ID in the rentedArrayList and every time the ID is found
		 * the counter proceeds one step forward. Also, when found it changes the value
		 * of the boolean found to true. Finally, it returns the sum of count.
		 */
		int count = 1;
		boolean found = false;
		for (int i = 0; i < rentedTitlesList.size(); i++) {

			if (rentedTitlesList.contains(customer.getID()))
				;
			{
				found = true;
				count++;
			}
			found = false;
		}
		return count;
	}

	private boolean setMediaRented(int id) {
		boolean available = true;
		for (Media resultID : mediaList) {
			if (id == resultID.getMediaID()) {
				resultID.setAvailable(false);
				// available = false;
			} else {
			}
		}
		return available;
	}

	// matches two parameters and return true(go ahead) or false(print exitMenu())
	public boolean isMatchSubscription(int mediaID, int customerID) {
		MembershipOptions customerSubscription = customerList.get(customerID - 1).getMembership();
		MembershipOptions mediaCategory = mediaList.get(mediaID - 1).getMembershipOptions();

		if (customerSubscription == MembershipOptions.PREMIUM) {
			return true;
		} else if (customerSubscription == mediaCategory) {
			return true;
		}
		return false;
	}

	// if loyaltyPoints is equal or bigger than 100 - display free rent and set
	// counter to zero;
	public boolean freeRent(int customerID) {
		int loyaltyPoints = customerList.get(customerID - 1).getLoyaltyPoints();
		if (loyaltyPoints >= 100) {
			customerList.get(customerID - 1).setLoyaltyPoints(-10);// I had to set it to -10 cause the add10Points
																	// method runs anyway after the freeRent is deducted
			return true;
		}
		return false;
	}

	public void returnRent() {

		fillRentList();
		
//		System.out.println("Please inform your Name");
//		String customerName = scannerCustomer.next();
		
		System.out.println("Please insert the name of the title your want to return:");
		String mediaName = scannerMedia.next();
		
		for (Rent resultRent : rentedTitlesList) {
			if(mediaName == resultRent.getMediaName()) {
				rentedTitlesList.remove(resultRent);
			}
		}

//		for (Rent result : rentedTitlesList) {
//			if (mediaName == result.getMediaName() && customerName == result.getCustumerName()) {
//				System.out.println("Media Name = " + result.getMediaName());
//				System.out.println("Rented Date = " + result.getRentDate());
//				System.out.println("Customer name: " + result.getCustumerName());
//				
//				result.setAvailable(true);
//			}

		fillRentList();
			
		}
		
	// option 8 in the Menu (it returns loyaltyPoints of the requested customerID;
	public void checkLoyaltyPoints() {
		scannerCustomer = new Scanner(System.in);
		System.out.println("Input customer ID:");
		int customerID = scannerCustomer.nextInt();
		int loyaltyPoints = customerList.get(customerID - 1).getLoyaltyPoints();
		System.out.println("CustomerID : " + customerID + " has " + loyaltyPoints + " Loyalty points!");
		view.exitQuestion();
	}

}
