//@EdwardsJr 2018245//

package model.media;

public class Music extends Media {

	private String mediaBandName;

	public Music(int mediaID, String mediaName, int mediaReleaseYear, String mediaBandName) {
		super(mediaID, mediaName, Format.CD , mediaReleaseYear);//from the parent constructor
		//format is defined here based on a ENUM -> music, in this scenario, can be only on a CD format
		this.mediaBandName = mediaBandName;
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

	//toString method
	@Override
	public String toString() {
		return "Music [mediaID=" + mediaID + ", mediaName=" + mediaName
				+ ", mediaType=" + Format.CD + ", mediaReleaseYear=" + mediaReleaseYear + ", mediaBandName=" + mediaBandName + "]";
	}
	

}
