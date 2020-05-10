//@EdwardsJr 2018245//

package model.media;

import model.customer.MembershipOptions;

public class Media {

	// variable declaration
	protected int mediaID;
	protected String mediaName;
	protected Format mediaType;
	protected int mediaReleaseYear;
	protected MembershipOptions membershipOptions;
	protected boolean isAvailable;

	// default constructor using all fields
	public Media(int mediaID, String mediaName, Format mediaType, int mediaReleaseYear, boolean isAvailable) {
		super();
		this.mediaID = mediaID;
		this.mediaName = mediaName;
		this.mediaType = mediaType;
		this.mediaReleaseYear = mediaReleaseYear;
		this.isAvailable = isAvailable;

	}

	// Getters and Setters
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

	public MembershipOptions getMembershipOptions() {
		return membershipOptions;
	}

	public void setMembershipOptions(MembershipOptions membershipOptions) {
		this.membershipOptions = membershipOptions;
	}

	public boolean isAvailable() {
		return this.isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	// toString method
	@Override
	public String toString() {
		return "Media [mediaID=" + mediaID + ", mediaName=" + mediaName + ", mediaType=" + mediaType
				+ ", mediaReleaseYear=" + mediaReleaseYear + ", membershipOptions=" + membershipOptions
				+ ", isAvailable=" + isAvailable + "]";
	}

}
