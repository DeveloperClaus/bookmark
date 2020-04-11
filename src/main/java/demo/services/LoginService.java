package demo.services;

import org.osgl.aaa.AAA;
import org.osgl.aaa.NoAuthentication;
import org.osgl.inject.annotation.Provided;
import org.osgl.mvc.annotation.GetAction;

import act.app.ActionContext;
import act.util.Output;
import demo.models.Comment;

public class LoginService extends PublicServiceBase {

    @GetAction
    @NoAuthentication
    public void home(@Output @Provided Comment outputOfLogin) {

    	render("home.html");
    }
    
    @GetAction("login")
    public void login(@Output @Provided Comment outputOfLogin, ActionContext context) {
        
    	context.login("testFlowUser");
        
    	fillComment(outputOfLogin, "LOGIN clicked", context);
    	render("home.html");
    }

    @GetAction("check")
    public void check(@Output @Provided Comment outputOfLogin, ActionContext context) {
        
    	fillComment(outputOfLogin, "CHECK clicked", context);
    	render("home.html");
    }

    
    private void fillComment(Comment comment, String pUsedClick, ActionContext context) {

    	comment.setUsedClick(pUsedClick);
    	comment.setIsLoggedOn(""+context.isLoggedIn());
    	comment.setLoggedInUser(context.username());
    	if(AAA.hasPermission("defaultFlowPermission")) {
    		comment.setHasPermission("YES, with permission");
    	} else {
    		comment.setHasPermission("sorry, NO permission");
    	}
    }
    
}
