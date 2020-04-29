//@EdwardsJr 2018245//

package model.media;

public class LiveConcert extends Media {

	private String mediaBandName;

	public LiveConcert(int mediaID, String mediaName, String mediaType, int mediaReleaseYear, String mediaBandName) {
		super(mediaID, mediaName, mediaType, mediaReleaseYear);
		this.mediaBandName = mediaBandName;
	}

	public String getMediaBandName() {
		return mediaBandName;
	}

	public void setMediaBandName(String mediaBandName) {
		this.mediaBandName = mediaBandName;
	}

	

	
	
}
