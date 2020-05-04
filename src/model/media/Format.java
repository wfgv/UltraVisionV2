//@EdwardsJr 2018245//

package model.media;

public enum Format {

	//enum to handle the media format and it's description
	CD ("CD - Compatc Disc"),
	DVD ("DVD - Digital Video Disc"),
	BluRay ("BR - Bluray Disc");
	
	private String description;
	
	Format (String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
