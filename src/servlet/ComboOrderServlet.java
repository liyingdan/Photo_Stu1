package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domian.ComboOrder;
import service.ComboOrderService;

@WebServlet("/ComboOrderServlet")
public class ComboOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String getAllComboOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ì×²ÍÔ¤Ô¼");
		ComboOrderService comboOrderService = new ComboOrderService();
		try {
			List<ComboOrder> allcomboOrder = comboOrderService.getAllcomboOrder();
			Collections.reverse(allcomboOrder);
			HttpSession session = request.getSession();
			session.setAttribute("allcomboOrder",allcomboOrder);
			return "admin/Aorder.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
