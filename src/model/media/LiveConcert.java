//@EdwardsJr 2018245//

//this class look exactly the same as Music class, there is only one small difference: the format. With
//music class, the format will be always CD, although here, the format can be either DVD or BluRay

package model.media;

public class LiveConcert extends Media {

	private String mediaBandName;

	public LiveConcert(int mediaID, String mediaName, Format mediaType, int mediaReleaseYear, String mediaBandName) {
		super(mediaID, mediaName, mediaType, mediaReleaseYear);//from the parent constructor
		this.mediaBandName = mediaBandName;
	}

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

	@Override
	public String toString() {
		return "LiveConcert [mediaID=" + mediaID + ", mediaName=" + mediaName + ", mediaType=" + mediaType
				+ ", mediaReleaseYear=" + mediaReleaseYear + ", mediaBandName=" + mediaBandName + "]";
	}
	
	

	
	
	

	
	
}
