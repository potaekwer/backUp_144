package yorizori.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import yorizori.domain.User;


@WebListener
public class UserAccessLoginListener implements HttpSessionAttributeListener {
	
	private static final String session_attribute_name = "loginUser";
	

    public void attributeAdded(HttpSessionBindingEvent se)  { //정의할때
    
    
    	if(session_attribute_name.equals(se.getName())){
    		User user = (User)se.getValue();
    		System.out.println(user.getName() + "is login.");
    	}
    	
    	
    
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { //없어질때
    
    	if(session_attribute_name.equals(se.getName())){
    		User user = (User)se.getValue();
    		System.out.println(user.getName() + "is logout.");
    	}
    	
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 

    	
    	
    	
    }
	
}
