package AdminServlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domian.comment;
import service.ComService;
import servlet.BaseServlet;

@WebServlet("/AComServlet")
public class AComServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	ComService comService = new ComService();
	//获取所有评论
	public String getAllComments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<comment> allCom = comService.getAllCom();
			request.setAttribute("allCom", allCom);
			Collections.reverse(allCom);
			//System.out.println(allCom);
			//转发到主页
			return "admin/Acomment.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//根据id删除评论
	public String DelComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		System.out.println(id);
		try {
			comService.delComment(id);
			return "/AComServlet?action=getAllComments";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
