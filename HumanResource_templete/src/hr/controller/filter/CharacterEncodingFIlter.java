package hr.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFIlter implements Filter {
	
	
	private static final String ECODING = "utf-8";
	private static final String CONTENT_TYPE = "text/html";
	
	
	

	public void init(FilterConfig fConfig) throws ServletException {

	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding(ECODING);
		response.setCharacterEncoding(ECODING);
		response.setContentType(CONTENT_TYPE);
		
		chain.doFilter(request, response);
		
	}
	public void destroy() {
		
		
	}

	
	

}
