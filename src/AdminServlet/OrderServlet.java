package AdminServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domian.ClothesOrder;
import service.OrderService;
import servlet.BaseServlet;

@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	OrderService orderService = new OrderService();
	//ЛёШЁЫљгаЖЉЕЅ
	public String getAllClothesorders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("АЅ  пепепепепепе");
		try {
			List<ClothesOrder> allClothesOrder = orderService.getAllOrder();
			System.out.println(allClothesOrder);
			HttpSession session = request.getSession();
			session.setAttribute("allClothesOrder", allClothesOrder);
			return "ComboOrderServlet?action=getAllComboOrder";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
