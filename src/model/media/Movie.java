//@EdwardsJr 2018245//

package model.media;

public class Movie extends Media {

	private String mediaGenre;
	private String mediaDirector;

	public Movie(int mediaID, String mediaName, Format mediaType, int mediaReleaseYear, String mediaGenre,
			String mediaDirector) {
		super(mediaID, mediaName, mediaType, mediaReleaseYear);//from the parent constructor
		mediaID++;
		this.mediaGenre = mediaGenre;
		this.mediaDirector = mediaDirector;
	}

	//getters and setters
	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	public String getMediaName() {
		return this.mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public int getMediaReleaseYear() {
		return mediaReleaseYear;
	}

	public void setMediaReleaseYear(int mediaReleaseYear) {
		this.mediaReleaseYear = mediaReleaseYear;
	}

	public String getMediaGenre() {
		return mediaGenre;
	}

	public void setMediaGenre(String mediaGenre) {
		this.mediaGenre = mediaGenre;
	}

	public String getMediaDirector() {
		return mediaDirector;
	}

	public void setMediaDirector(String mediaDirector) {
		this.mediaDirector = mediaDirector;
	}

	//toString method
	@Override
	public String toString() {
		return "Media [mediaID=" + mediaID + ", mediaName=" + mediaName + ", mediaType=" + mediaType
				+ ", mediaReleaseYear=" + mediaReleaseYear + ", mediaGenre=" + mediaGenre + ", mediaDirector="
				+ mediaDirector + "]";
	}

}
