package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

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
		// Movie movie = null;

		try {
			scannerMedia = new Scanner(System.in);
			System.out.println("Enter movie title: ");
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

	public void addBoxSet() {

		br = new BufferedReader(new InputStreamReader(System.in));

		int mediaID = mediaCounter;// increasing the ID
		String mediaName = null;
		Format mediaType = null;
		int mediaReleaseYear = 0;
		int numberOfSeasons = 0;
		String mediaGenre = null;
		int choice = 0;

		try {
			scannerMedia = new Scanner(System.in);
			System.out.println("Enter TV Show title: ");
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
			System.out.println("Enter the number of seasons: ");
			numberOfSeasons = Integer.parseInt(br.readLine());
			System.out.println("");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mediaList.add(new BoxSet(mediaID, mediaName, mediaType, mediaReleaseYear, mediaGenre, numberOfSeasons,
				MembershipOptions.VIDEOLOVER));

		System.out.println("Movie was successfully created!\n");
		System.out.println("ID Number: " + mediaID);
		System.out.println("Title: " + mediaName);
		System.out.println("Format: " + mediaType);
		System.out.println("Release Year: " + mediaReleaseYear);
		System.out.println("Genre: " + mediaGenre);
		System.out.println("Number of Seasons: " + numberOfSeasons);
		System.out.println(mediaList);

		mediaCounter = mediaCounter + 1;
		view.exitQuestion();

	}

	public void addMusic() {

		br = new BufferedReader(new InputStreamReader(System.in));

		int mediaID = mediaCounter;// increasing the ID
		String mediaName = null;
		int mediaReleaseYear = 0;
		String mediaBandName = null;

		try {
			scannerMedia = new Scanner(System.in);
			System.out.println("Enter a record name: ");
			mediaName = br.readLine();
			System.out.println("Enter the release year: ");
			mediaReleaseYear = Integer.parseInt(br.readLine());
			System.out.println("Enter an Artist/Band name: ");
			mediaBandName = br.readLine();
			System.out.println("");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mediaList.add(new Music(mediaID, mediaName, mediaReleaseYear, mediaBandName, MembershipOptions.MUSICLOVER));

		System.out.println("Movie was successfully created!\n");
		System.out.println("ID Number: " + mediaID);
		System.out.println("Title: " + mediaName);
		System.out.println("Release Year: " + mediaReleaseYear);
		System.out.println("Band/Artist: " + mediaBandName);
		System.out.println(mediaList);

		mediaCounter = mediaCounter + 1;
		view.exitQuestion();

	}
	
	public void addLiveConcert() {
		
		br = new BufferedReader(new InputStreamReader(System.in));

		int mediaID = mediaCounter;// increasing the ID
		String mediaName = null;
		int mediaReleaseYear = 0;
		Format mediaType = null;
		String mediaBandName = null;
		int choice = 0;

		try {
			scannerMedia = new Scanner(System.in);
			System.out.println("Enter a record name: ");
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
			System.out.println("Enter an Artist/Band name: ");
			mediaBandName = br.readLine();
			System.out.println("");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mediaList.add(new LiveConcert(mediaID, mediaName, mediaType, mediaReleaseYear, mediaBandName, MembershipOptions.MUSICLOVER));

		System.out.println("Movie was successfully created!\n");
		System.out.println("ID Number: " + mediaID);
		System.out.println("Title: " + mediaName);
		System.out.println("Format: " + mediaType);
		System.out.println("Release Year: " + mediaReleaseYear);
		System.out.println("Band/Artist: " + mediaBandName);
		System.out.println(mediaList);

		mediaCounter = mediaCounter + 1;
		view.exitQuestion();
		
	}

	public void searchMedia() {

		Media searchedMedia = null;
		scannerMedia = new Scanner(System.in);
		System.out.println("Search movies by Name, Genre ou Director: ");
		String search = scannerMedia.nextLine();

		for (Media myMedia : mediaList) {
			if (myMedia.getMediaName() != null && myMedia.getMediaName().equalsIgnoreCase(search)
					&& myMedia.getMediaName().matches("^[a-zA-Z-]*$")) {
				searchedMedia = myMedia;
				System.out.println("Here are the results:\n");
				System.out.println("ID: " + searchedMedia.getMediaID());
				System.out.println("Title: " + searchedMedia.getMediaName());
				System.out.println("Membership type: " + searchedMedia.getMembershipOptions());
				// view.exitQuestion();
			}

		}
		System.out.println("Media not found");
		view.exitQuestion();

		// TODO : create new Method in View searchAnotherMedia( ) ;
	}

	// methods to fill the arrays with data
	public void fillMediaList() {
		
		mediaList.add(new Movie(199, "Bacurau", Format.BluRay, 1995, "Horror", "Hitchcock",	MembershipOptions.VIDEOLOVER));
		mediaList.add(new Movie(198, "Parasite", Format.DVD, 2019, "Thriller", "PT Anderson",MembershipOptions.VIDEOLOVER));
		mediaList.add(new Movie(197, "Melancholia", Format.BluRay, 2015, "Drama", "Lars Von Trier",	MembershipOptions.VIDEOLOVER));
		mediaList.add(new Movie(196, "Psycho", Format.DVD, 1970, "Horror", "Hitchcock", MembershipOptions.VIDEOLOVER));
		mediaList.add(new Movie(195, "Swallow", Format.BluRay, 1995, "Comedy", "Coffin Joe", MembershipOptions.VIDEOLOVER));
		
		mediaList.add(new Music(299, "Extraordinary Machine", 2000, "Fiona Apple", MembershipOptions.MUSICLOVER));
		mediaList.add(new Music(298, "Parklive", 2012, "Blur", MembershipOptions.MUSICLOVER));
		mediaList.add(new Music(297, "The Eraser", 2006, "Thom Yorke", MembershipOptions.MUSICLOVER));
		mediaList.add(new Music(296, "Amnesiac", 2001, "Radiohead", MembershipOptions.MUSICLOVER));
		mediaList.add(new Music(295, "Utopia", 2017, "Bjork", MembershipOptions.MUSICLOVER));
		
		mediaList.add(new LiveConcert(399, "MTV Unplugged", Format.BluRay, 1993, "Nirvana", MembershipOptions.MUSICLOVER));
		mediaList.add(new LiveConcert(398, "In Rainbows", Format.DVD, 2015, "Radiohead", MembershipOptions.MUSICLOVER));
		mediaList.add(new LiveConcert(397, "Live at Monterey", Format.BluRay, 1970, "Jimi Hendrix", MembershipOptions.MUSICLOVER));
		mediaList.add(new LiveConcert(396, "Live in Cuba", Format.DVD, 2005, "AudioSlave", MembershipOptions.MUSICLOVER));
		mediaList.add(new LiveConcert(395, "Unplugged", Format.BluRay, 2000, "Alice In Chains", MembershipOptions.MUSICLOVER));
		
		mediaList.add(new BoxSet(499, "Friends", Format.DVD, 2005, "Comedy", 5, MembershipOptions.TVLOVER));
		mediaList.add(new BoxSet(498, "Dexter", Format.BluRay, 1997, "Drama", 6, MembershipOptions.TVLOVER));
		mediaList.add(new BoxSet(497, "Lost", Format.BluRay, 2015, "Horror", 7, MembershipOptions.TVLOVER));
		mediaList.add(new BoxSet(496, "Years and Years", Format.DVD, 1985, "Drama", 1, MembershipOptions.TVLOVER));
		mediaList.add(new BoxSet(495, "Unbelievable", Format.BluRay, 2000, "Thiller", 2, MembershipOptions.TVLOVER));

	}

	public void viewMediaList() { // just testing purposes (Option 6)
		System.out.println(mediaList);
		view.exitQuestion();

	}
}
