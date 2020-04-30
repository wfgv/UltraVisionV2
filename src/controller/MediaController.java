//EdwardsJr - 2018245//

package controller;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.media.BoxSet;
import model.media.Format;
import model.media.LiveConcert;
import model.media.Media;
import model.media.Movie;
import model.media.Music;

public class MediaController {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// declaring BufferedReader
																							// to be accessible to all
																							// methods
	private static Scanner scanner = new Scanner(System.in);// declaring Scanner to be accessible to all methods
	private List<Movie> movieList = new ArrayList<>();// movie arraylist
	private List<Music> musicList = new ArrayList<>();// music arraylist
	private List<LiveConcert> liveConcertList = new ArrayList<>();// live concert arraylist
	private List<BoxSet> boxSetList = new ArrayList<>();// boxset arraylist
	Movie movie;// variable to handle movie objects
	Music music;// variable to handle music objects
	LiveConcert liveConcert;// variable to handle live concert objects
	BoxSet boxSet;// variable to handle boxset objects

	public Music addMusic() {

		// local variables
		br = new BufferedReader(new InputStreamReader(System.in));
		int mediaID = 1;
		String mediaName = "";
//		String mediaType;
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
		System.out.println("Record: " + mediaName + " was succesfully created!");
		System.out.println(music);

		return music;
	}

	public Movie addMovie() {

		br = new BufferedReader(new InputStreamReader(System.in));
		int mediaID = 1;
		mediaID = +mediaID;
		String mediaName = null;
		Format mediaType = null;
		int mediaReleaseYear = 0;
		String mediaGenre = null;
		String mediaDirector = null;
		int choice = 0;

		try {
//			mediaID = +mediaID;
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
				// TODO Auto-generated catch block
				System.out.println("Please, use one of the options");
			}

			System.out.println("Enter the release year: ");
			mediaReleaseYear = Integer.parseInt(br.readLine());
			System.out.println("Enter the genre: ");
			mediaGenre = br.readLine();
			System.out.println("Enter the director: ");
			mediaDirector = br.readLine();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		movie = new Movie(mediaID, mediaName, mediaType, mediaReleaseYear, mediaGenre, mediaDirector);
		movieList.add(movie);
		System.out.println(movieList.toString());

		System.out.println("Movie: " + mediaName + " was succesfully created!");
		System.out.println(movie);
		System.out.println("");
		System.out.println("Would you like to add another movie? \n1 - Yes \n2 - No");
		choice = scanner.nextInt();
		if (choice == 1) {
			addMovie();
			
		} else if (choice == 2) {
			new Menu();
		}
		return movie;
	}

	public LiveConcert addLiveConcert() {

		br = new BufferedReader(new InputStreamReader(System.in));
		scanner = new Scanner(System.in);
		int mediaID = 1;
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
		scanner = new Scanner(System.in);
		int mediaID = 1;
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
				// TODO Auto-generated catch block
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

	//updateMovie(searchMovie());
	//public Movie updateMovie(Movie movie)
	public Movie searchMovie() {
	Movie searchedMovie =  null;
		movieList = fillArrays();
		System.out.println(movieList.toString());
		
		System.out.println("Type the name of the movie: ");
		String searchString = scanner.nextLine();
		
		
		for(Movie myMovie : movieList) {
		    if(myMovie.getMediaName() != null && myMovie.getMediaName().equals(searchString)) {
		        //Process data do whatever you want
		    	searchedMovie = myMovie;
		    	System.out.println(searchedMovie.toString());
		     }
		    
		    
//		}
//		if (movieList.equals(searchString)) {
//			System.out.println("Found " + searchString + " in the movie list");
//		} else {
//			System.out.println(searchString + " is not available.");
		}
		return searchedMovie;

	}

	public Movie deleteMovie() {
		System.out.println("Enter the movie ID: ");
		int nameID = scanner.nextInt();
		scanner.next();
		movieList.remove(nameID);
		System.out.println("Movie " + nameID + " was sucessfully removed");
		return movie;

	}

	public Movie updateMovie() {
		return null;

	}

	public void updateMovies(List<Media> movieList) {
		
	}

	public List<Movie> fillArrays(){
		
		List<Movie> movieList = new ArrayList<>();
		Movie movie1 = new Movie(001, "Bacurau", Format.BluRay, 1995, "Horror", "Hitchcock");
		Movie movie2 = new Movie(002, "Parasite", Format.DVD, 2019, "Thriller", "PT Anderson");
		Movie movie3 = new Movie(003, "Melancholia", Format.BluRay, 2015, "Drama", "Lars Von Trier");
		Movie movie4 = new Movie(004, "Psycho", Format.DVD, 1970, "Horror", "Hitchcock");
		Movie movie5 = new Movie(005, "Swallow", Format.BluRay, 1995, "Comedy", "Coffin Joe");

		movieList.add(movie1);
		movieList.add(movie2);
		movieList.add(movie3);
		movieList.add(movie4);
		movieList.add(movie5);
		

//		List<Media> musicList = new ArrayList<>();
//		Music music1 = new Music(001, "Extraordinay Machine", "CD", 2000, "Fiona Apple");
//		Music music2 = new Music(002, "Parklive", "CD", 2012, "Blur");
//		Music music3 = new Music(003, "The Eraser", "CD", 2006, "Thom Yorke");
//		Music music4 = new Music(004, "Amnesiac", "CD", 2001, "Radiohead");
//		Music music5 = new Music(005, "Utopia", "CD", 2017, "Bjork");
//
//		musicList.add(music1);
//		musicList.add(music2);
//		musicList.add(music3);
//		musicList.add(music4);
//		musicList.add(music5);
//
//		List<Media> liveMusicList = new ArrayList<>();
//		LiveConcert liveConcert1 = new LiveConcert(001, "MTV Unplugged", "DVD", 1993, "Nirvana");
//		LiveConcert liveConcert2 = new LiveConcert(002, "In Rainbows", "DVD", 2015, "Radiohead");
//		LiveConcert liveConcert3 = new LiveConcert(003, "Live at Monterey", "DVD", 1970, "Jimi Hendrix");
//		LiveConcert liveConcert4 = new LiveConcert(004, "Live in Cuba", "DVD", 2005, "AudioSlave");
//		LiveConcert liveConcert5 = new LiveConcert(005, "Unplugged", "DVD", 2000, "Alice In Chains");
//
//		liveMusicList.add(liveConcert1);
//		liveMusicList.add(liveConcert2);
//		liveMusicList.add(liveConcert3);
//		liveMusicList.add(liveConcert4);
//		liveMusicList.add(liveConcert5);
//
//		List<Media> boxSetList = new ArrayList<>();
//		BoxSet boxSet1 = new BoxSet(001, "Season1", "BluRay", 2005, "Tech");
//		BoxSet boxSet2 = new BoxSet(002, "Teste03", "DVD", 1997, "Tech1");
//		BoxSet boxSet3 = new BoxSet(003, "Teste02", "DVD", 2015, "Tech2");
//		BoxSet boxSet4 = new BoxSet(004, "Teste03", "BluRay", 1985, "Tech3");
//		BoxSet boxSet5 = new BoxSet(005, "Teste04", "BluRay", 2000, "Tech4");
//
//		boxSetList.add(boxSet1);
//		boxSetList.add(boxSet2);
//		boxSetList.add(boxSet3);
//		boxSetList.add(boxSet4);
//		boxSetList.add(boxSet5);
		
		return movieList;

	}

	public List<Media> createMusicList() {

		List<Media> musicList = new ArrayList<>();
		Music music1 = new Music(001, "Extraordinay Machine", "CD", 2000, "Fiona Apple");
		Music music2 = new Music(002, "Parklive", "CD", 2012, "Blur");
		Music music3 = new Music(003, "The Eraser", "CD", 2006, "Thom Yorke");
		Music music4 = new Music(004, "Amnesiac", "CD", 2001, "Radiohead");
		Music music5 = new Music(005, "Utopia", "CD", 2017, "Bjork");

		musicList.add(music1);
		musicList.add(music2);
		musicList.add(music3);
		musicList.add(music4);
		musicList.add(music5);

		return musicList;
	}

	public List<Media> createLiveConcertList() {

		List<Media> liveMusicList = new ArrayList<>();
		LiveConcert liveConcert1 = new LiveConcert(001, "MTV Unplugged", "DVD", 1993, "Nirvana");
		LiveConcert liveConcert2 = new LiveConcert(002, "In Rainbows", "DVD", 2015, "Radiohead");
		LiveConcert liveConcert3 = new LiveConcert(003, "Live at Monterey", "DVD", 1970, "Jimi Hendrix");
		LiveConcert liveConcert4 = new LiveConcert(004, "Live in Cuba", "DVD", 2005, "AudioSlave");
		LiveConcert liveConcert5 = new LiveConcert(005, "Unplugged", "DVD", 2000, "Alice In Chains");

		liveMusicList.add(liveConcert1);
		liveMusicList.add(liveConcert2);
		liveMusicList.add(liveConcert3);
		liveMusicList.add(liveConcert4);
		liveMusicList.add(liveConcert5);

		return liveMusicList;

	}

	public List<Media> createBoxSetList() {

		List<Media> boxSetList = new ArrayList<>();
		BoxSet boxSet1 = new BoxSet(001, "Season1", "BluRay", 2005, "Tech");
		BoxSet boxSet2 = new BoxSet(002, "Teste03", "DVD", 1997, "Tech1");
		BoxSet boxSet3 = new BoxSet(003, "Teste02", "DVD", 2015, "Tech2");
		BoxSet boxSet4 = new BoxSet(004, "Teste03", "BluRay", 1985, "Tech3");
		BoxSet boxSet5 = new BoxSet(005, "Teste04", "BluRay", 2000, "Tech4");

		boxSetList.add(boxSet1);
		boxSetList.add(boxSet2);
		boxSetList.add(boxSet3);
		boxSetList.add(boxSet4);
		boxSetList.add(boxSet5);

		return boxSetList;

	}

}
