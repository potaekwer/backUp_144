package lecture.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.domain.Lecture;
import lecture.service.LectureService;
import lecture.service.LectureServiceLogic;
@WebServlet("/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LectureService service;
	public ModifyController(){
		service = new LectureServiceLogic();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Lecture lec = service.find(id);
		request.setAttribute("lecture", lec);
		request.getRequestDispatcher("modify.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Lecture lec = new Lecture();
		lec.setId(request.getParameter("lectureId"));
		lec.setLectureName(request.getParameter("lectureName"));
		lec.setInstructor(request.getParameter("instructorName"));
		lec.setIntroduce(request.getParameter("lectureIntroduce"));
		service.modify(lec);
		response.sendRedirect("list.do");
	}
}
