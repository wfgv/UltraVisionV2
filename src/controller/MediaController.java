//EdwardsJr - 2018245//

package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.customer.Customer;
import model.customer.MembershipOptions;
import model.media.BoxSet;
import model.media.Format;
import model.media.LiveConcert;
import model.media.Media;
import model.media.Movie;
import model.media.Music;
import view.View;

public class MediaController {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// declaring BufferedReader
																							// to be accessible to all
																							// methods // to be
	private Controller controller;																						// accessible to all
	private static Scanner scanner = new Scanner(System.in);// declaring Scanner to be accessible to all methods
	private List<Media> mediaList = new ArrayList<Media>();
	private List<Movie> movieList;// movie arraylist
	private List<Music> musicList = new ArrayList<>();// music arraylist
	private List<LiveConcert> liveConcertList = new ArrayList<>();// live concert arraylist
	private List<BoxSet> boxSetList = new ArrayList<>();// boxset arraylist
	 private List<List<Media>> allMediaList = new ArrayList<>();
	Movie movie;// variable to handle movie objects
	Music music;// variable to handle music objects
	LiveConcert liveConcert;// variable to handle live concert objects
	BoxSet boxSet;// variable to handle boxset objects
	//View view = new View(controller, null);
	// Media allMedia;
	int counter = 0;
	
	public MediaController() {
		//view = new View (controller, this);
		fillMovieList();
		//view.Menu();
	}

	public void addMusic() {

		// local variables
		br = new BufferedReader(new InputStreamReader(System.in));
		int mediaID = counter++;// increasing the ID
		String mediaName = "";
		int mediaReleaseYear = 0;
		String mediaBandName = "";

		mediaID = +mediaID;// increase ID number
		try {
			System.out.println("Enter a record name: ");
			mediaName = br.readLine();
			System.out.println("Enter the release year: ");
			mediaReleaseYear = Integer.parseInt(br.readLine());
			System.out.println("Enter a band/artist name: ");
			mediaBandName = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		music = new Music(mediaID, mediaName, mediaReleaseYear, mediaBandName);// creating a new object music
		musicList.add(music);// adding the object to the arraylist

		System.out.println("Music record succesfully added!");
		System.out.println("ID Number " + mediaID);
		System.out.println("Record name: " + mediaName);
		System.out.println("Release year: " + mediaReleaseYear);
		System.out.println("Band/Artist: " + mediaBandName);

	}

	public void addMovie() {

		//movieList = fillMovieList();//bring the populated array

		br = new BufferedReader(new InputStreamReader(System.in));
		int mediaID = counter;// increasing the ID
		String mediaName = null;
		Format mediaType = null;
		int mediaReleaseYear = 0;
		String mediaGenre = null;
		String mediaDirector = null;
		int choice = 0;

		try {
			System.out.println("Enter movie name: ");
			mediaName = br.readLine();

			try {
				System.out.println("Enter media type: \n1 - DVD \n2 - BluRay");
				choice = scanner.nextInt();
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
		mediaList.add(new Movie(mediaID, mediaName, mediaType, mediaReleaseYear, mediaGenre,mediaDirector, MembershipOptions.VIDEOLOVER));
		//movieList.add(movie);
		mediaList.add((mediaID + 1), movie);

		// ask to confirm object creation
		System.out.println("Movie was successfully created!\n");
		System.out.println("ID Number: " + movie.getMediaID());
		System.out.println("Title: " + movie.getMediaName());
		System.out.println("Format: " + mediaType.getDescription());
		System.out.println("Release Year: " + movie.getMediaReleaseYear());
		System.out.println("Genre: " + movie.getMediaGenre());
		System.out.println("Director: " + movie.getMediaDirector());
		System.out.println(mediaList);
		//view.exitQuestion();
		

	}
	public void viewMediaList() {
		System.out.println(mediaList);
		//view.exitQuestion();
		
	}

	public LiveConcert addLiveConcert() {

		br = new BufferedReader(new InputStreamReader(System.in));
		scanner = new Scanner(System.in);
		int mediaID = counter++;// increasing the ID
		String mediaName = null;
		Format mediaType = null;
		int mediaReleaseYear = 0;
		String mediaBandName = null;
		int choice = 0;

		try {
			mediaID = +mediaID;
			System.out.println("Enter Live Concert name: ");
			mediaName = br.readLine();

			try {
				System.out.println("Enter media type: \n1 - DVD \n2 - BluRay");
				choice = scanner.nextInt();
				if (choice == 1) {
					mediaType = Format.DVD;
				} else if (choice == 2) {
					mediaType = Format.BluRay;
				}
			} catch (Exception e) {
				System.out.println("Please, use one of the options");
			}

			System.out.println("Enter the release year ");
			mediaReleaseYear = Integer.parseInt(br.readLine());
			System.out.println("Enter a band/artist name: ");
			mediaBandName = br.readLine();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		liveConcert = new LiveConcert(mediaID, mediaName, mediaType, mediaReleaseYear, mediaBandName);
		liveConcertList.add(liveConcert);

		System.out.println("Live Concert " + mediaName + " was succesfully created");
		System.out.println(liveConcert);
		return liveConcert;

	}

	public BoxSet addBoxSet() {

		br = new BufferedReader(new InputStreamReader(System.in));
		// scanner = new Scanner(System.in);
		int mediaID = counter++;// increasing the ID
		String mediaName = null;
		Format mediaType = null;
		int mediaReleaseYear = 0;
		String mediaGenre = null;
		int numberOfSeasons = 0;
		int choice = 0;

		try {
			mediaID = +mediaID;
			System.out.println("Enter box set name: ");
			mediaName = br.readLine();

			try {
				System.out.println("Enter media type: \n1 - DVD \n2 - BluRay");
				choice = scanner.nextInt();
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
			System.out.println("Enter the number os seasons: ");
			numberOfSeasons = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		boxSet = new BoxSet(mediaID, mediaName, mediaType, mediaReleaseYear, mediaGenre, numberOfSeasons);
		boxSetList.add(boxSet);

		System.out.println("Box Set: " + mediaName + " was succesfully created!");
		System.out.println(boxSet);

		return boxSet;
	}

	public Movie searchMovie() {

		Movie searchedMovie = null;
		//movieList = fillMovieList();
		System.out.println("Search movies by Name, Genre ou Director: ");
		String search = scanner.nextLine();

		for (Movie myMovie : movieList) {
			if (myMovie.getMediaName() != null && myMovie.getMediaName().equalsIgnoreCase(search)
					&& myMovie.getMediaName().matches("^[a-zA-Z]*$")
					|| (myMovie.getMediaGenre() != null) && myMovie.getMediaGenre().equalsIgnoreCase(search)
							&& myMovie.getMediaGenre().matches("^[a-zA-Z]*$")
					|| (myMovie.getMediaDirector() != null && myMovie.getMediaDirector().equalsIgnoreCase(search)
							&& myMovie.getMediaDirector().matches("^[a-zA-Z]*$"))) {
				searchedMovie = myMovie;
				System.out.println("Here are the results:\n");
				System.out.println("ID: " + searchedMovie.getMediaID());
				System.out.println("Title: " + searchedMovie.getMediaName().toString());
//				System.out.println("Format: " + searchedMovie.getMediaType();
				System.out.println("Genre " + searchedMovie.getMediaGenre().toString());
				System.out.println("Director " + searchedMovie.getMediaDirector().toString());
				System.out.println("");
			}
		}
		return searchedMovie;
	}

	public Music searchMusic() {

		Music searchedMusic = null;
		musicList = fillMusicList();
		System.out.println("Search music by Artist Name or Title: ");
		String search = scanner.nextLine();

		for (Music myMusic : musicList) {
			if (myMusic.getMediaName() != null && myMusic.getMediaName().equalsIgnoreCase(search)
					&& myMusic.getMediaName().matches("^[a-zA-Z]*$")
					|| (myMusic.getMediaBandName() != null && myMusic.getMediaBandName().equalsIgnoreCase(search)
							&& myMusic.getMediaBandName().matches("^[a-zA-Z]*$"))) {
				searchedMusic = myMusic;
				System.out.println("Here are the results:\n");
				System.out.println("ID: " + searchedMusic.getMediaID());
				System.out.println("Artist/Band: " + searchedMusic.getMediaBandName().toString());
				System.out.println("Album name: " + searchedMusic.getMediaName().toString());
				System.out.println("");
			}
		}
		return searchedMusic;
	}

	public LiveConcert searchLiveConcert() {

		LiveConcert searchedLiveConcert = null;
		liveConcertList = fillLiveConcertList();
		System.out.println("Search Live Concerts by Artist Name or Title:  ");
		String search = scanner.nextLine();

		for (LiveConcert myLiveConcert : liveConcertList) {
			if (myLiveConcert.getMediaName() != null && myLiveConcert.getMediaName().equalsIgnoreCase(search)
					&& myLiveConcert.getMediaName().matches("^[a-zA-Z]*$")
					|| (myLiveConcert.getMediaBandName() != null
							&& myLiveConcert.getMediaBandName().equalsIgnoreCase(search)
							&& myLiveConcert.getMediaBandName().matches("^[a-zA-Z]*$"))) {
				searchedLiveConcert = myLiveConcert;
				System.out.println("Here are the results:\n");
				System.out.println("ID: " + searchedLiveConcert.getMediaID());
				System.out.println("Artist/Band: " + searchedLiveConcert.getMediaBandName().toString());
				System.out.println("Album name: " + searchedLiveConcert.getMediaName().toString());
				System.out.println("");
			}
		}
		return searchedLiveConcert;
	}

	public BoxSet searchBoxSet() {

		BoxSet searchedBoxSet = null;
		boxSetList = fillBoxSetList();
		System.out.println("Seach TV Shows by Title or Genre: ");
		String search = scanner.nextLine();

		for (BoxSet myBoxSet : boxSetList) {
			if (myBoxSet.getMediaName() != null && myBoxSet.getMediaName().equalsIgnoreCase(search)
					&& myBoxSet.getMediaName().matches("^[a-zA-Z]*$")
					|| (myBoxSet.getMediaGenre() != null && myBoxSet.getMediaGenre().equalsIgnoreCase(search)
							&& myBoxSet.getMediaGenre().matches("^[a-zA-Z]*$"))) {
				searchedBoxSet = myBoxSet;
				System.out.println("Here are the results:\n");
				System.out.println("ID: " + searchedBoxSet.getMediaID());
				System.out.println("Title: " + searchedBoxSet.getMediaName().toString());
				System.out.println("Genre: " + searchedBoxSet.getMediaGenre().toString());
				System.out.println("Number os Seasons " + searchedBoxSet.getnumberOfSeasons());
			}
		}
		return searchedBoxSet;
	}

	// methods to fill the arrays with data
	public List<Music> fillMusicList() {

		List<Music> musicList = new ArrayList<>();
		Music music1 = new Music(001, "Extraordinay Machine", 2000, "Fiona Apple");
		Music music2 = new Music(002, "Parklive", 2012, "Blur");
		Music music3 = new Music(003, "The Eraser", 2006, "Thom Yorke");
		Music music4 = new Music(004, "Amnesiac", 2001, "Radiohead");
		Music music5 = new Music(005, "Utopia", 2017, "Bjork");

		musicList.add(music1);
		musicList.add(music2);
		musicList.add(music3);
		musicList.add(music4);
		musicList.add(music5);

		return musicList;

	}

	public List<LiveConcert> fillLiveConcertList() {

		List<LiveConcert> liveMusicList = new ArrayList<>();
		LiveConcert liveConcert1 = new LiveConcert(001, "MTV Unplugged", Format.BluRay, 1993, "Nirvana");
		LiveConcert liveConcert2 = new LiveConcert(002, "In Rainbows", Format.DVD, 2015, "Radiohead");
		LiveConcert liveConcert3 = new LiveConcert(003, "Live at Monterey", Format.BluRay, 1970, "Jimi Hendrix");
		LiveConcert liveConcert4 = new LiveConcert(004, "Live in Cuba", Format.DVD, 2005, "AudioSlave");
		LiveConcert liveConcert5 = new LiveConcert(005, "Unplugged", Format.BluRay, 2000, "Alice In Chains");

		liveMusicList.add(liveConcert1);
		liveMusicList.add(liveConcert2);
		liveMusicList.add(liveConcert3);
		liveMusicList.add(liveConcert4);
		liveMusicList.add(liveConcert5);

		return liveMusicList;
	}

	public List<BoxSet> fillBoxSetList() {

		List<BoxSet> boxSetList = new ArrayList<>();
		BoxSet boxSet1 = new BoxSet(001, "Friends", Format.DVD, 2005, "Comedy", 5);
		BoxSet boxSet2 = new BoxSet(002, "Dexter", Format.BluRay, 1997, "Drama", 6);
		BoxSet boxSet3 = new BoxSet(003, "Lost", Format.BluRay, 2015, "Horror", 7);
		BoxSet boxSet4 = new BoxSet(004, "Years and Years", Format.DVD, 1985, "Drama", 1);
		BoxSet boxSet5 = new BoxSet(005, "Teste04", Format.BluRay, 2000, "Thiller", 2);

		boxSetList.add(boxSet1);
		boxSetList.add(boxSet2);
		boxSetList.add(boxSet3);
		boxSetList.add(boxSet4);
		boxSetList.add(boxSet5);

		return boxSetList;
	}

	public void fillMovieList() {

		//List<Media> mediaList = new ArrayList<>();
		Movie movie1 = new Movie(001, "Bacurau", Format.BluRay, 1995, "Horror", "Hitchcock", MembershipOptions.VIDEOLOVER);
		Movie movie2 = new Movie(002, "Parasite", Format.DVD, 2019, "Thriller", "PT Anderson", MembershipOptions.VIDEOLOVER);
		Movie movie3 = new Movie(003, "Melancholia", Format.BluRay, 2015, "Drama", "Lars Von Trier", MembershipOptions.VIDEOLOVER);
		Movie movie4 = new Movie(004, "Psycho", Format.DVD, 1970, "Horror", "Hitchcock", MembershipOptions.VIDEOLOVER);
		Movie movie5 = new Movie(005, "Swallow", Format.BluRay, 1995, "Comedy", "Coffin Joe", MembershipOptions.VIDEOLOVER);

		mediaList.add(movie1);
		mediaList.add(movie2);
		mediaList.add(movie3);
		mediaList.add(movie4);
		mediaList.add(movie5);

	//	return movieList;

	}

	public List<Media> fillAllMedia() {

		List<Media> allMediaList = new ArrayList<>();
		List<Movie> movieList = new ArrayList<>();
		List<Music> musicList = new ArrayList<>();
		List<LiveConcert> liveConcertList = new ArrayList<>();
		List<BoxSet> boxSetList = new ArrayList<>();

		fillMovieList();
		fillBoxSetList();
		fillLiveConcertList();
		fillMusicList();

		allMediaList.addAll(liveConcertList);
		allMediaList.addAll(musicList);
		allMediaList.addAll(movieList);
		allMediaList.addAll(boxSetList);

		System.out.println(allMediaList);
		return allMediaList;

	}

//	public List<Movie> getMovieList() {
//		return fillMovieList();
//	}
//
//	public void setMovieList(List<Movie> movieTest) {
//		this.movieList = movieTest;
//	}

}
