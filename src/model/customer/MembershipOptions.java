package model.customer;

// simple enum that stores subscription options 
//@WillianVoelz
public enum MembershipOptions {
	
	MUSICLOVER(" Music CDs and Live Concert Videos "),
	VIDEOLOVER(" Movies, excluding Live Concert Videos "),
	TVLOVER(" Box Sets only "),
	PREMIUM(" Any title ")
	
	;
	
	private final String condition;
	
	MembershipOptions(String condition) {
		this.condition = condition;
	}
	public String getCondition() {
		return this.condition;
	}
	

}
