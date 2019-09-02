package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domian.clothes;
import service.ClothesService;

@WebServlet("/ClothesServlet")
public class ClothesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClothesService clothesService = new ClothesService(); 
		List<clothes> allClothes;
		
		
		try {
			allClothes = clothesService.getAllClothes();
			Collections.reverse(allClothes);
			HttpSession session = request.getSession();
			session.setAttribute("allClothes", allClothes);
			request.getRequestDispatcher("/ComServlet?action=getAllComments").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	
		

	}

}
