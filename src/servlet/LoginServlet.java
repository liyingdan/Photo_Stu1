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
			//��ȡ�û���������
			String name = request.getParameter("username");
			String psd = request.getParameter("password");
			System.out.println(name+psd);

			LoginService loginService = new LoginService();
			try {
				user user = loginService.login(name,psd);
				//�����û�
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath()+"/ProductServlet?action=getAllProducts");
	
			} catch (Exception e) {
				if(e.getMessage().equals("�û������������")) {
					//���ص�½ҳ�棬���Դ�����Ϣ
					request.setAttribute("err", e.getMessage());
					request.getRequestDispatcher("user/login.jsp").forward(request, response);
				}
				else {
					e.printStackTrace();
					
				}
				
			}
  }

}
