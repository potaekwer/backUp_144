package member.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.domain.Member;
import member.service.MemberServiceLogic;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		MemberServiceLogic service = new MemberServiceLogic();
		
		int no = Integer.parseInt(req.getParameter("no"));
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		Member member = new Member();
		
		member = service.searchByNo(no);
		
		
		out.println("<html>");
		out.println("<head><title>가입결과 페이지</title></head>");
		out.println("<body>");
		if(service.removeMember(no)){
			out.print("<h1>"+member.getName()+"님 삭제완료</h1>");
			
			
			
		}else{
			out.print("<h1>삭제 실패</h1>");
		}
		out.println("<form action = 'list.do'>");
		out.println("<input type = 'submit' value = '목록으로'>");
		out.println("</form>");	
		out.println("</body>");
		out.println("</html>");
	
	
	}

}
