package member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.domain.Member;
import member.service.MemberServiceLogic;

public class SearchNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		
		MemberServiceLogic service = new MemberServiceLogic();
		
		String name = req.getParameter("name");
		
		List<Member> list = service.searchByName(name);
		
		out.println("<html>");
		out.println("<head><title>검색 결과 </title></head>");
		out.println("<body>");
		out.println("<hr>");
		
		for(Member m : list){
			out.println("<span>"+m.toString()+"</span>");
			
		}
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
	}

}
