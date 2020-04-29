package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.media.BoxSet;
import model.media.LiveConcert;
import model.media.Media;
import model.media.Movie;
import model.media.Music;

public class MediaController {

	private static Scanner scanner = new Scanner(System.in);//declaring Scanner to be accessible to all methods
	private List<Movie> movieList = new ArrayList<>();//movie arraylist
	private List<Music> musicList = new ArrayList<>();//music arraylist
	Movie movie;//variable to handle the movie object
	Music music;//variable to handle the music object

	public Music addMusic() {

		scanner = new Scanner(System.in);
		int mediaID = 1;
		String mediaName;
		String mediaType;
		int mediaReleaseYear;
		String mediaBandName;

		mediaID = +mediaID;
		System.out.println("Enter a record name: ");
		mediaName = scanner.nextLine();
		System.out.println("Enter media type: \n1 - DVD \n2 - CD\n3 - BluRay");
		mediaType = scanner.nextLine();
		System.out.println(mediaType);
		System.out.println("Enter the release year: ");
		mediaReleaseYear = scanner.nextInt();
		System.out.println(mediaReleaseYear);
		System.out.println("Enter a band/artist name: ");
		mediaBandName = scanner.nextLine();

		music = new Music(mediaID, mediaName, mediaType, mediaReleaseYear, mediaBandName);
		musicList.add(music);
		System.out.println("Record: " + mediaName + " was succesfully created!");
		System.out.println(music);

		return music;
	}

	public Movie addMovie() {

		scanner = new Scanner(System.in);
		int mediaID = 1;
		String mediaName;
		String mediaType;
		int mediaReleaseYear;
		String mediaGenre;
		String mediaDirector;

		do {
			int choice = 0;
			mediaID = +mediaID;
			System.out.println("Enter movie name: ");
			mediaName = scanner.nextLine();
			System.out.println(mediaName);

			System.out.println("Enter media type: \n1 - DVD \n2 - CD\n3 - BluRay");
			mediaType = scanner.nextLine();
			System.out.println(mediaType);
			System.out.println("Enter the release year: ");
			mediaReleaseYear = scanner.nextInt();
			System.out.println(mediaReleaseYear);

//			try {
//				System.out.println("Enter media type: \n1 - DVD \n2 - CD\n3 - BluRay");
//				choice = input.nextInt();
//				if (choice == 1) {
//					mediaType = Format.DVD.toString();
//				} else if (choice == 2) {
//					mediaType = Format.CD.toString();
//				} else if (choice == 3) {
//					mediaType = Format.BluRay.toString();
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				System.out.println("Please, use one of the options");
//			} 

			System.out.println("Enter the genre: ");
			mediaGenre = scanner.nextLine();
			System.out.println(mediaGenre);
			System.out.println("Enter the director: ");
			mediaDirector = scanner.nextLine();
			System.out.println(mediaDirector);

			movie = new Movie(mediaID, mediaName, mediaType, mediaReleaseYear, mediaGenre, mediaDirector);
			movieList.add(movie);

			System.out.println("Movie: " + mediaName + " was succesfully created!");
			System.out.println(movie);
		} while (movie == null);

		return movie;
	}

	public Movie searchMovie() {
		System.out.println("Type the name of the movie: ");
		String searchString = scanner.nextLine();
		if (movieList.equals(searchString)) {
			System.out.println("Found " + searchString + " in the movie list");
		} else {
			System.out.println(searchString + " is not available.");
		}
		return movie;

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

//	public void updateMovies(List<Media> movieList) {
//		
//	}
//
////	public ArrayList<Media> fillArrays(){
////		
////		List<Media> movieList = new ArrayList<>();
////		Movie movie1 = new Movie(001, "Bacurau", 1995, "Horror", "Hitchcock");
////		Movie movie2 = new Movie(002, "Parasite", 2019, "Thriller", "PT Anderson");
////		Movie movie3 = new Movie(003, "Melancholia", 2015, "Drama", "Lars Von Trier");
////		Movie movie4 = new Movie(004, "Psycho", 1970, "Horror", "Hitchcock");
////		Movie movie5 = new Movie(005, "Swallow", 1995, "Comedy", "Coffin Joe");
////
////		movieList.add(movie1);
////		movieList.add(movie2);
////		movieList.add(movie3);
////		movieList.add(movie4);
////		movieList.add(movie5);
////
////		List<Media> musicList = new ArrayList<>();
////		Music music1 = new Music(001, "Extraordinay Machine", "CD", 2000, "Fiona Apple");
////		Music music2 = new Music(002, "Parklive", "CD", 2012, "Blur");
////		Music music3 = new Music(003, "The Eraser", "CD", 2006, "Thom Yorke");
////		Music music4 = new Music(004, "Amnesiac", "CD", 2001, "Radiohead");
////		Music music5 = new Music(005, "Utopia", "CD", 2017, "Bjork");
////
////		musicList.add(music1);
////		musicList.add(music2);
////		musicList.add(music3);
////		musicList.add(music4);
////		musicList.add(music5);
////
////		List<Media> liveMusicList = new ArrayList<>();
////		LiveConcert liveConcert1 = new LiveConcert(001, "MTV Unplugged", "DVD", 1993, "Nirvana");
////		LiveConcert liveConcert2 = new LiveConcert(002, "In Rainbows", "DVD", 2015, "Radiohead");
////		LiveConcert liveConcert3 = new LiveConcert(003, "Live at Monterey", "DVD", 1970, "Jimi Hendrix");
////		LiveConcert liveConcert4 = new LiveConcert(004, "Live in Cuba", "DVD", 2005, "AudioSlave");
////		LiveConcert liveConcert5 = new LiveConcert(005, "Unplugged", "DVD", 2000, "Alice In Chains");
////
////		liveMusicList.add(liveConcert1);
////		liveMusicList.add(liveConcert2);
////		liveMusicList.add(liveConcert3);
////		liveMusicList.add(liveConcert4);
////		liveMusicList.add(liveConcert5);
////
////		List<Media> boxSetList = new ArrayList<>();
////		BoxSet boxSet1 = new BoxSet(001, "Season1", "BluRay", 2005, "Tech");
////		BoxSet boxSet2 = new BoxSet(002, "Teste03", "DVD", 1997, "Tech1");
////		BoxSet boxSet3 = new BoxSet(003, "Teste02", "DVD", 2015, "Tech2");
////		BoxSet boxSet4 = new BoxSet(004, "Teste03", "BluRay", 1985, "Tech3");
////		BoxSet boxSet5 = new BoxSet(005, "Teste04", "BluRay", 2000, "Tech4");
////
////		boxSetList.add(boxSet1);
////		boxSetList.add(boxSet2);
////		boxSetList.add(boxSet3);
////		boxSetList.add(boxSet4);
////		boxSetList.add(boxSet5);
////
////	}

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
