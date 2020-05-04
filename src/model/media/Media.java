//@EdwardsJr 2018245//

package model.media;

public abstract class Media {//higher abstract class for all media types
	
	//variable declaration
	protected int mediaID;
	protected String mediaName;
	protected Format mediaType;
	protected int mediaReleaseYear;
		
	
	//default constructor using all fields
	public Media(int mediaID, String mediaName, Format mediaType, int mediaReleaseYear) {
		super();
		this.mediaID = mediaID;
		this.mediaName = mediaName;
		this.mediaType = mediaType;
		this.mediaReleaseYear = mediaReleaseYear;

	}
	
	//blank constructor using no parameters
	public Media() {

	}
	
	//Getters and Setters
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
	
	public Format getMediaType() {
		return mediaType;
	}

	public void setMediaType(Format mediaType) {
		this.mediaType = mediaType;
	}

	//toString method
	@Override
	public String toString() {
		return "Media [mediaID=" + mediaID + ", mediaName=" + mediaName + ", mediaType=" + mediaType
				+ ", mediaReleaseYear=" + mediaReleaseYear + "]";
	}
	
	

	
	

}
