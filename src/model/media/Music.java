//@EdwardsJr 2018245//

package model.media;

import model.customer.MembershipOptions;

public class Music extends Media {

	private String mediaBandName;

	public Music(int mediaID, String mediaName, int mediaReleaseYear, String mediaBandName, MembershipOptions membershipOptions, boolean isAvailable) {
		super(mediaID, mediaName, Format.CD , mediaReleaseYear, isAvailable);//from the parent constructor
		//format is defined here based on a ENUM -> music, in this scenario, can be only on a CD format
		this.mediaBandName = mediaBandName;
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
	
	public String getMediaBandName() {
		return mediaBandName;
	}

	public void setMediaBandName(String mediaBandName) {
		this.mediaBandName = mediaBandName;
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
		return "Music [mediaID=" + mediaID + ", mediaName=" + mediaName + ", mediaType=" + mediaType
				+ ", mediaReleaseYear=" + mediaReleaseYear + ", membershipOptions=" + membershipOptions
				+ ", isAvailable=" + isAvailable + ", mediaBandName=" + mediaBandName + "]";
	}



	

	

}
