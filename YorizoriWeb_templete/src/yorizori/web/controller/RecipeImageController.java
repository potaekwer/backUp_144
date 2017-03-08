package yorizori.web.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yorizori.domain.ImageFile;
import yorizori.domain.Recipe;
import yorizori.service.CookbookService;
import yorizori.service.ServiceFactory;

@WebServlet("/recipe/image.do")
public class RecipeImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int recipeId = Integer.parseInt(request.getParameter("recipeId"));

		CookbookService service = ServiceFactory.getCookbookService();

		Recipe recipe = service.findRecipeById(recipeId);
		ImageFile rImage = recipe.getRecipeImage();

		String fileName = null;
		InputStream in = null;

		if (rImage != null) {
			response.setContentType(rImage.getContentType());
			String imagePath = getServletContext().getInitParameter("imagePath");
			fileName = imagePath + "/" + rImage.getFileName();

			in = new BufferedInputStream(new FileInputStream(fileName));
		}
		
		OutputStream out = response.getOutputStream();
		
		byte [] buf = new byte[8096];
		int readByte = 0;
		while((readByte = in.read(buf))>-1){
			out.write(buf, 0, readByte);
			
		}
		in.close();
		out.close();

	}

}
