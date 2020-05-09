//@EdwardsJr 2018245//

package model.media;

import model.customer.MembershipOptions;

public class Movie extends Media {

	private String mediaGenre;
	private String mediaDirector;

	//default constructor
	public Movie(int mediaID, String mediaName, Format mediaType, int mediaReleaseYear, String mediaGenre,
			String mediaDirector, MembershipOptions membershipOptions, boolean isAvailable) {
		super(mediaID, mediaName, mediaType, mediaReleaseYear, isAvailable);//from the parent constructor
		this.mediaGenre = mediaGenre;
		this.mediaDirector = mediaDirector;
		this.membershipOptions = membershipOptions;
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
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Movie [mediaID=" + mediaID + ", mediaName=" + mediaName + ", mediaType=" + mediaType
				+ ", mediaReleaseYear=" + mediaReleaseYear + ", membershipOptions=" + membershipOptions
				+ ", isAvailable=" + isAvailable + ", mediaGenre=" + mediaGenre + ", mediaDirector=" + mediaDirector
				+ "]";
	}
	
	
	//toString method


}
