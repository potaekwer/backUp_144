package yorizori.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import yorizori.domain.ImageFile;
import yorizori.domain.Procedure;
import yorizori.domain.Recipe;
import yorizori.domain.User;
import yorizori.service.CookbookService;
import yorizori.service.ServiceFactory;

//@MultipartConfig(
//		fileSizeThreshold = 1024 * 1024 *1,
//		maxFileSize = 1024 * 1024 *10,
//		maxRequestSize = 1024 * 1024 * 15,
//		location = "/upload"
//		)
@WebServlet("/recipe/register.do")
public class RecipeFormContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecipeFormContoller() {
		CookbookService service = ServiceFactory.getCookbookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("cbId", request.getParameter("cbId"));
		request.getRequestDispatcher("/views/recipeForm.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String savePath = getServletContext().getInitParameter("imagePath");
		int sizeLimt = 1024 * 1024 * 15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimt, "UTF-8",
				new DefaultFileRenamePolicy());// DefaultFileRenamePolicy 파일이름의
												// 중복을 방지하기위한 클래스 중복된이름이면 뒤에
												// 숫자붙이기
												//( 받는파라미터값 ,저장디렉토리주소, 업로드파일크기제한,인코딩형태,예외처리)
		String recipeName = multi.getParameter("recipeName");
		String recipeTime = multi.getParameter("recipeTime");
		String recipeIngredients = multi.getParameter("recipeIngredients");
		String procedures = multi.getParameter("recipeProcedure");
		List<Procedure> proList = new ArrayList<>();
		String pList[] = procedures.split("\n");
		for (int i = 0; i < pList.length; i++) {
			Procedure procedure = new Procedure();
			procedure.setProcedure(pList[i]);
			proList.add(procedure);
		}
		String fileName = multi.getFilesystemName("attachFile");
		String saveFname[] = fileName.split("\\.");

		ImageFile image = new ImageFile();
		image.setContentType("image/" + saveFname[1]);
		image.setFileName(fileName);

		int recipeLevel = Integer.parseInt(multi.getParameter("recipeLevel"));

		HttpSession session = request.getSession();

		Recipe recipe = new Recipe();

		recipe.setName(recipeName);
		recipe.setLevel(recipeLevel);
		recipe.setTime(Integer.parseInt(recipeTime));
		recipe.setIngredients(recipeIngredients);
		recipe.setProcedures(proList);
		recipe.setRecipeImage(image);
		recipe.setWriter((User) session.getAttribute("loginUser"));
		CookbookService service = ServiceFactory.getCookbookService();
		recipe.setCookbook(service.findCookbook(Integer.parseInt(multi.getParameter("cbId"))));
		service.registerRecipe(recipe);
		response.sendRedirect(request.getContextPath() + "/recipe/list.do?cbId=" + multi.getParameter("cbId"));

	}

}
