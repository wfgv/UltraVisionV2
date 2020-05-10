//@EdwardsJr 2018245//

package model.media;

import model.customer.MembershipOptions;

public class BoxSet extends Media {

	private String mediaGenre;
	private int numberOfSeasons;

	//default constructor
	public BoxSet(int mediaID, String mediaName, Format mediaType, int mediaReleaseYear, 
			String mediaGenre, int numberOfSeasons, MembershipOptions membershipOptions, boolean isAvaiable) {
		super(mediaID, mediaName, mediaType, mediaReleaseYear, isAvaiable);//from the parent constructor
		this.mediaGenre = mediaGenre;
		this.numberOfSeasons = numberOfSeasons;
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
		return mediaName;
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
	
	public int getnumberOfSeasons() {
		return numberOfSeasons;
	}

	public void setnumberOfSeasons(int numberOfSeasons) {
		this.numberOfSeasons = numberOfSeasons;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	//toString method
	@Override
	public String toString() {
		return "\nMedia Type: BoxSet \nID: " + mediaID + "\nTitle: " + mediaName + "\nFormat: " + mediaType
				+ "\nRelease Year: " + mediaReleaseYear + "\nGenre: " + mediaGenre + "\nNumber Of Seasons: " + numberOfSeasons
				+ "\nMembership Type: " + membershipOptions + "\nAvailability: " + isAvailable + "";
	}
	
}
