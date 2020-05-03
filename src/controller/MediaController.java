//EdwardsJr - 2018245//

package controller;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.w3c.dom.css.Counter;

import model.media.BoxSet;
import model.media.Format;
import model.media.LiveConcert;
import model.media.Media;
import model.media.Movie;
import model.media.Music;

public class MediaController {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// declaring BufferedReader to be accessible to all methods																							// to be accessible to all
	private static Scanner scanner = new Scanner(System.in);// declaring Scanner to be accessible to all methods
	private List<Movie> movieList = new ArrayList<>();// movie arraylist
	private List<Music> musicList = new ArrayList<>();// music arraylist
	private List<LiveConcert> liveConcertList = new ArrayList<>();// live concert arraylist
	private List<BoxSet> boxSetList = new ArrayList<>();// boxset arraylist
	private List<List<Media>> allMediaList = new ArrayList<>();
	Movie movie;// variable to handle movie objects
	Music music;// variable to handle music objects
	LiveConcert liveConcert;// variable to handle live concert objects
	BoxSet boxSet;// variable to handle boxset objects
	Media allMedia;
	int counter = 0;

	public Music addMusic() {

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
		System.out.println("Record: " + mediaName + " was succesfully created!");
		System.out.println(music);

		return music;
	}

	public Movie addMovie() {

		br = new BufferedReader(new InputStreamReader(System.in));
		int mediaID = counter++;// increasing the ID
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
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		movie = new Movie(mediaID, mediaName, mediaType, mediaReleaseYear, mediaGenre, mediaDirector);
		movieList.add(movie);
		//System.out.println(movieList.toString());

		
		// ask to confirm object creation
		System.out.println("Movie: " + movie.getMediaName() + " was succesfully created!");//change to look like the customer method
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
		//scanner = new Scanner(System.in);
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

	public void searchMedia() {

		scanner = new Scanner(System.in);
		int choice;
		System.out.println("Please, choose which kind of media you would like to search for:");
		System.out.println("\n1 - Movie \n2 - Music \n3 - Live Concert \n4 - Box Set \n5 - All Media");// add option to search for ALL MEDIA
		choice = scanner.nextInt();
		if (choice == 1) {
			Scanner sc1 = new Scanner(System.in);
			Movie searchedMovie = null;
			movieList = fillMovieList();
			System.out.println("Type the name of the movie: ");
			String search = sc1.nextLine();

			for (Movie myMovie : movieList) {
				if (myMovie.getMediaName() != null && myMovie.getMediaName().equals(search)) {
					searchedMovie = myMovie;
					System.out.println("Here are the results:\n");
					System.out.println(searchedMovie.toString());

				}
				
			}
		} else if (choice == 2) {
			Music searchedMusic = null;
			musicList = fillMusicList();
			System.out.println("Type the name of the album: ");
			String search = scanner.nextLine();

			for (Music myMusic : musicList) {
				if (myMusic.getMediaName() != null && myMusic.getMediaName().equals(search)) {
					searchedMusic = myMusic;
					System.out.println("Here are the results:\n");
					System.out.println(searchedMusic.toString());
				}
				// if statement to (1) make another search or (2) return to menu --> inside a external method view.method();
			}
		} else if (choice == 3) {
			LiveConcert searchedLiveConcert = null;
			liveConcertList = fillLiveConcertList();
			System.out.println("Type the name of the live concert music/video ");
			String search = scanner.nextLine();

			for (LiveConcert myLiveConcert : liveConcertList) {
				if (myLiveConcert.getMediaName() != null && myLiveConcert.getMediaName().equals(search)) {
					searchedLiveConcert = myLiveConcert;
					System.out.println("Here are the results:\n");
					System.out.println(searchedLiveConcert.toString());
				}
				// return searchedLiveConcert;
			}
		} else if (choice == 4) {
			BoxSet searchedBoxSet = null;
			boxSetList = fillBoxSetList();
			System.out.println("Type the name of the TV show ");
			String search = scanner.nextLine();

			for (BoxSet myBoxSet : boxSetList) {
				if (myBoxSet.getMediaName() != null && myBoxSet.getMediaName().equals(search)) {
					searchedBoxSet = myBoxSet;
					System.out.println("Here are the results:\n");
					System.out.println(searchedBoxSet.toString());
				}
				// return searchedBoxSet;
			}
		} else if (choice == 5) {
			//Media searchedAllMedia = null;
			allMediaList = fillAllMedia();
			System.out.println(allMediaList);
//			System.out.println("Type the name: ");
//			String search = scanner.nextLine();
			
//			for (List<Media> myMedia : allMediaList) {
//				if(myMedia(search)) {
//					searchedAllMedia = myMedia;
//					
//				}
			}
			
			
		}

		// return null;
		//List<List<Media>> allMediaList = new ArrayList<>();

	

	// updateMovie(searchMovie());
	// public Movie updateMovie(Movie movie)
	public Movie searchMovie() {

		Movie searchedMovie = null;
		movieList = fillMovieList();
		//int option = 0;
		System.out.println("Search movies by Name, Genre ou Director: ");
		String searchString = scanner.nextLine();

		for (Movie myMovie : movieList) {
			if (myMovie.getMediaName() != null && myMovie.getMediaName().equals(searchString)
					|| (myMovie.getMediaGenre() != null) && myMovie.getMediaGenre().equals(searchString)
					|| (myMovie.getMediaDirector() != null) && myMovie.getMediaDirector().equals(searchString)) {
				searchedMovie = myMovie;
				System.out.println("Here are the results:\n");
				System.out.println(searchedMovie.toString());
				System.out.println("");
				System.out.println("Choose: \n1 - Make another search \n2 - Update selected \n3 - Delete selected");
				int option = scanner.nextInt();
				if (option == 1) {
					searchMovie();
				} else if (option == 2) {
					updateMovie(searchMovie());
				} else if (option == 3) {
					movieList.remove(searchedMovie);
					//deleteMovie(searchMovie());
					System.out.println("The movie was deleted!");
				}
			}
		}
		return searchedMovie;

	}

	public void deleteMovie(Movie movie) {
		//System.out.println("Enter the movie ID: ");
		//int nameID = scanner.nextInt();
		//scanner.next();
		movieList.remove(searchMovie());
		//movieList.remove(searchMovie());
		

		System.out.println("Movie " + searchMovie() + " was sucessfully removed");
		//return movie;

	}

	public void updateMovie(Movie movie) {
		
		
		
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

	public List<Movie> fillMovieList() {

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

		return movieList;

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

}
