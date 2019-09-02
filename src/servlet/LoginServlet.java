package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domian.user;
import service.LoginService;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
			//获取用户名和密码
			String name = request.getParameter("username");
			String psd = request.getParameter("password");
			System.out.println(name+psd);

			LoginService loginService = new LoginService();
			try {
				user user = loginService.login(name,psd);
				//保存用户
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/ProductServlet?action=getAllProducts");
	
			} catch (Exception e) {
				if(e.getMessage().equals("用户名或密码错误")) {
					//返回登陆页面，回显错误信息
					request.setAttribute("err", e.getMessage());
					request.getRequestDispatcher("user/login.jsp").forward(request, response);
				}
				else {
					e.printStackTrace();
					
				}
				
			}
  }

}
