package AdminServlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domian.admin;
import service.AdminService;
import servlet.BaseServlet;

@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminService adminService = new AdminService();
	//�õ����й���Ա
	public String getAlladmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<admin> allAdmin = adminService.getAllAdmin();
			Collections.reverse(allAdmin);
			request.setAttribute("allAdmin", allAdmin);
			return "admin/Admin.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	//����idɾ������Ա
	public String DelAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����id
		String id = request.getParameter("id");
		//ɾ����Ʒ
		try {
			adminService.deleteAdmin(id);
			return "/AdminServlet?action=getAlladmin";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	//���ӹ���Ա
	public String addAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		admin admin = new admin();
		try {
			BeanUtils.populate(admin, parameterMap);
			String username = new String(admin.getUsername().getBytes("ISO-8859-1"),"UTF-8");
			admin.setUsername(username);
			adminService.addAdmin(admin);
			return "/AdminServlet?action=getAlladmin";
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
}
