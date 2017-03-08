package yorizori.common.exception;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class YzRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = -4078839765402111721L;
	private String redirectURL;
	
	public YzRuntimeException(String massage) {
		
	super(massage);
	}
	public String getRedirectURL(){
		return redirectURL;
	}
	public void setRedirectURL(String redirectURL){
		this.redirectURL = redirectURL;
	}
	

}
