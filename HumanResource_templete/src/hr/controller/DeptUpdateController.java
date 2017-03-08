package hr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/dept/update.do")
public class DeptUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HumanResourceService service = new HumanResourceServiceLogic();

		Employee emp = new Employee();

		emp = service.findEmployee(request.getParameter("empNo"));
		emp.setDeptNo(request.getParameter("deptNo"));

		service.modify(emp);
		response.sendRedirect(request.getContextPath() + "/dept/list.do");
	}
}
