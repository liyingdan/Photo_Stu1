package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domian.combo;
import service.ComboService;

@WebServlet("/ComboServlet")
public class ComboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ComboService comboService = new ComboService();
			List<combo> allCombos;
			allCombos = comboService.findAllCombos();
			HttpSession session = request.getSession();
			session.setAttribute("allCombos", allCombos);
			request.getRequestDispatcher("user/case.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
	}

}
