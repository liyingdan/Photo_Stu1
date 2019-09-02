package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			Class clazz = this.getClass();
			Method method = clazz.getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			if(method != null) {
				String desPath = (String)method.invoke(this, request,response);
				if(desPath != null){
					request.getRequestDispatcher(desPath).forward(request, response);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}


}
