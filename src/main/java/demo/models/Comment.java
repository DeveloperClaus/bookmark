package demo.models;


public class Comment  {
	public String usedClick="";
	public String isLoggedOn="";
	public String hasPermission="";
	public String loggedInUser="";
	
	public String getUsedClick() {
		return usedClick;
	}
	public void setUsedClick(String usedClick) {
		this.usedClick = usedClick;
	}
	public String getIsLoggedOn() {
		return isLoggedOn;
	}
	public void setIsLoggedOn(String isLoggedOn) {
		this.isLoggedOn = isLoggedOn;
	}
	public String getHasPermission() {
		return hasPermission;
	}
	public void setHasPermission(String hasPermission) {
		this.hasPermission = hasPermission;
	}
	public String getLoggedInUser() {
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
}
