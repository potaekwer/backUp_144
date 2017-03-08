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
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();		
		MemberServiceLogic service = new MemberServiceLogic();		
		int no = Integer.parseInt(req.getParameter("no"));		
		Member member = service.searchByNo(no);		
		out.println("<html>");
		out.println("<head><title>"+member.getName()+"님의 정보</title></head>");
		out.println("<body>");
		out.println("<hr>");
		out.println("<form action = 'list.do'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>이름</th><th>이메일</th><th>날짜</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>"+member.getName()+"</th><th>"+member.getEmail()+"</th><th>"+member.getRegDate()+"</th>");
		out.println("</tr>");
		out.println("</table>");		
		out.println("<input type ='submit' value ='목록'>");		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
