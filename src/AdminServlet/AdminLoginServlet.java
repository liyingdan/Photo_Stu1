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
		
		//���õ�¼ҵ��
		AdminService adminService = new AdminService();
		try {
			admin admin = adminService.login(name,pwd);
			//�����û�
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			System.out.println(admin);
			//�ض���
			response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
		} 
		catch (Exception e) {
			if(e.getMessage().equals("�û������������")) {
				//���ص�¼ҳ��,���Դ�����Ϣ
				request.setAttribute("err", e.getMessage());
				//ת��
				request.getRequestDispatcher("admin/admin_login.jsp").forward(request, response);
			}
			else {
				e.printStackTrace();
			}
			
		}
	}

}
