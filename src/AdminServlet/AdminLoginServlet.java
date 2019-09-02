package AdminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domian.admin;
import service.AdminService;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		//调用登录业务
		AdminService adminService = new AdminService();
		try {
			admin admin = adminService.login(name,pwd);
			//保存用户
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			System.out.println(admin);
			//重定向
			response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
		} 
		catch (Exception e) {
			if(e.getMessage().equals("用户名或密码错误")) {
				//返回登录页面,回显错误信息
				request.setAttribute("err", e.getMessage());
				//转发
				request.getRequestDispatcher("admin/admin_login.jsp").forward(request, response);
			}
			else {
				e.printStackTrace();
			}
			
		}
	}

}
