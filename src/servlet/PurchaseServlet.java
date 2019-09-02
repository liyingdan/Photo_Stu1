package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domian.ClothesOrder;
import domian.clothes;
import service.ClothesService;
import service.PurchaseService;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	PurchaseService purchaseService = new PurchaseService();
	//加购物车
	public String getAllPurchases(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ClothesService clothesService = new ClothesService();
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<clothes> clothesList = (ArrayList<clothes>) session.getAttribute("Pclothes");
		if(clothesList == null) {
			//System.out.println("session又为空啦");
			clothesList = new ArrayList<clothes>();
		}
		try {
			clothes Pclothes = clothesService.getClothesWithId(id);
			clothesList.add(Pclothes);
			session.setAttribute("Pclothes", clothesList);
			System.out.println("clothesList:"+clothesList);
			return "/ClothesServlet";
			//request.getRequestDispatcher("/ClothesServlet").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

	//租衣服(提交订单)
	public String AddOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("租衣服呀");
		String id = request.getParameter("id");
		ClothesOrder clothesOrder = new ClothesOrder();
		ClothesService clothesService = new ClothesService();
		try {
			clothes Pclothes = clothesService.getClothesWithId(id);
			System.out.println(Pclothes);
			clothesOrder.setClothesname(Pclothes.getName());
			clothesOrder.setPrice(Pclothes.getPrice());
			clothesOrder.setUsername("李应丹");
			System.out.println(clothesOrder);
			purchaseService.addCloOrder(clothesOrder);
			return "/ClothesServlet";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//添加摄影套餐
	public String addComboOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("想预约呀");
		
		return null;
	}
	
	
	
}
