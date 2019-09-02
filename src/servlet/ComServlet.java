package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domian.comment;
import service.ComService;

@WebServlet("/ComServlet")
public class ComServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	ComService comService = new ComService();
	//获取所有评论
	public String getAllComments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<comment> allCom = comService.getAllCom();
			request.setAttribute("allCom", allCom);
			Collections.reverse(allCom);
			//转发到主页
			return "user/clothes.jsp";
			//request.getRequestDispatcher("user/clothes.jsp").forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	
	
	//增加评论
	public String AddComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		comment comment = new comment();
		try {
			BeanUtils.populate(comment, parameterMap);
			String com = new String(comment.getCcom().getBytes("ISO-8859-1"),"UTF-8");
			String name = new String(comment.getUsername().getBytes("ISO-8859-1"),"UTF-8");
			comment.setCcom(com);
			comment.setUsername(name);
			System.out.println(comment);
			comService.addComment(comment);
			return "/ComServlet?action=getAllComments";
		}catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}	
}
