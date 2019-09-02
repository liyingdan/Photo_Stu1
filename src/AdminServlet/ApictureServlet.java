package AdminServlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domian.picture;
import service.PictureService;

@WebServlet("/ApictureServlet")
public class ApictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureService pictureService = new PictureService();
		try {
			//获取所有照片
			List<picture> allPictures = pictureService.getAllPictures();
			Collections.reverse(allPictures);
			request.setAttribute("allPictures", allPictures);
			//System.out.println(allPictures);
			request.getRequestDispatcher("admin/Apicture.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
