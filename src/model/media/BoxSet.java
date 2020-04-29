//@EdwardsJr 2018245//

package model.media;

public class BoxSet extends Media {

	private String mediaBSBrand;

	public BoxSet(int mediaID, String mediaName, String mediaType, int mediaReleaseYear, String mediaBSBrand) {
		super(mediaID, mediaName, mediaType, mediaReleaseYear);
		this.mediaBSBrand = mediaBSBrand;
	}

	public String getMediaBSBrand() {
		return mediaBSBrand;
	}

	public void setMediaBSBrand(String mediaBSBrand) {
		this.mediaBSBrand = mediaBSBrand;
	}

	

	
	
}
