package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domian.picture;
import service.PictureService;

@WebServlet("/PicturesServlet")
public class PicturesServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	//根据id获得某期图片
	public String getpicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureService pictureService = new PictureService();
		String id = request.getParameter("id");
		System.out.println("商品id="+id);
		try {
			//根据id获得照片
			picture picture = pictureService.getPictureWithId(id);
			request.setAttribute("picture", picture);
			System.out.println(picture);
			return "/PicturesServlet?action=getAllDate";
			//request.getRequestDispatcher("/PictureUIServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	//获取所有期刊
	public String getAllDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureService pictureService = new PictureService();
		try {
			//获取所有照片
			List<picture> allPictures = pictureService.getAllPictures();
			Collections.reverse(allPictures);
			request.setAttribute("allPictures", allPictures);
			//System.out.println(allPictures);
			return "user/picture.jsp";
			//request.getRequestDispatcher("user/picture.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	

}
