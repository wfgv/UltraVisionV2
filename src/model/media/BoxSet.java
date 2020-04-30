//@EdwardsJr 2018245//

package model.media;

public class BoxSet extends Media {

	private String mediaGenre;
	private int numberOfSeasons;

	public BoxSet(int mediaID, String mediaName, Format mediaType, int mediaReleaseYear, 
			String mediaGenre, int numberOfSeasons) {
		super(mediaID, mediaName, mediaType, mediaReleaseYear);//from the parent constructor
		this.mediaGenre = mediaGenre;
		this.numberOfSeasons = numberOfSeasons;
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

	//toString method
	@Override
	public String toString() {
		return "BoxSet [mediaID=" + mediaID + ", mediaName=" + mediaName + ", mediaType=" + mediaType
				+ ", mediaReleaseYear=" + mediaReleaseYear +  ", mediaGenre=" + mediaGenre + ", numberOfSeasons=" + numberOfSeasons + "]";
	}

	

	
	
}
