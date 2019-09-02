package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domian.product;
import service.ProductService;

@WebServlet("/ProductServlet")
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = new ProductService();
		try {
			List<product> allProducts = productService.getAllProducts();
			//存域
			request.setAttribute("allProducts", allProducts);
			//转发到主页
			return "user/Homepage1.jsp";
			//request.getRequestDispatcher("user/Homepage1.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getAllProducts2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		ProductService productService = new ProductService();
		try {
			List<product> allProducts = productService.getAllProducts();
			//存域
			request.setAttribute("allProducts", allProducts);
			//转发到主页
			return "user/Homepage1.jsp";
			//request.getRequestDispatcher("user/Homepage1.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

/*	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = new ProductService();
		try {
			List<product> allProducts = productService.getAllProducts();
			//存域
			request.setAttribute("allProducts", allProducts);
			System.out.println(allProducts);
			//转发到主页
			request.getRequestDispatcher("user/Homepage1.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/

}
