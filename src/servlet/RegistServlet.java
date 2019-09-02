package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import domian.user;
import util.JdbcUtil;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��ȡ��֤��
		String code = request.getParameter("code");
		
		//��ȡ���������ɵ���֤��
		String ecode = (String)request.getSession().getAttribute("checkcode");
		
		if(code.equals(ecode)) {
			//1)�������в���
			Map<String, String[]> parameterMap = request.getParameterMap();
			user u = new user();
			//2���ѽ��յĲ�����װ��user����
			try {
				BeanUtils.populate(u, parameterMap);
			} 
			catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			System.out.println(u);
			
			//3)д�����ݿ�
			QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
			String sql = "insert into user value(?,?,?)";
			try {
				qr.update(sql,u.getUsername(),u.getPassword(),u.getPhone());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.getWriter().write("�û�ע��ɹ�");
			response.sendRedirect(request.getContextPath()+"/user/login.jsp");
		}
		else {
			response.getWriter().write("��֤�����");
			request.getRequestDispatcher("user/regist.jsp").forward(request, response);
		}
			
			
	}
		
}
