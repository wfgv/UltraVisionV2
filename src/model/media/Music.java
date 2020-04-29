//@EdwardsJr 2018245//

package model.media;

public class Music extends Media {

	private String mediaBandName;

	public Music(int mediaID, String mediaName, String mediaType, int mediaReleaseYear, String mediaBandName) {
		super(mediaID, mediaName, mediaType, mediaReleaseYear);
		this.mediaType = Format.CD;
		this.mediaBandName = mediaBandName;
	}

	public String getMediaBandName() {
		return mediaBandName;
	}

	public void setMediaBandName(String mediaBandName) {
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
	
	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	@Override
	public String toString() {
		return "Music [mediaID=" + mediaID + ", mediaName=" + mediaName + ", mediaName=" + mediaName
				+ ", mediaType=" + mediaType + ", mediaReleaseYear=" + mediaReleaseYear + ", mediaBandName=" + mediaBandName + "]";
	}
	

}
