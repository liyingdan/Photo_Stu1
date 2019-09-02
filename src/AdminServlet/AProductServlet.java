package AdminServlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import domian.product;
import service.ProductService;
import servlet.BaseServlet;

@WebServlet("/AProductServlet")
public class AProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = new ProductService();
	
	//获取所有产品
	public String getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<product> allProducts = productService.getAllProducts();
			//存域
			request.setAttribute("allProducts", allProducts);
			//转发到主页
			return "admin/AProduct.jsp";
			//request.getRequestDispatcher("admin/AProduct.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	//根据id获得商品（修改准备工作）
	public String AlterUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		try {
			product product = productService.getProductsWithId(id);
			System.out.println(product);
			request.setAttribute("product", product);
			return "admin/ProductAlter.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public String AlterProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		product product = new product();
		try {
			BeanUtils.populate(product, parameterMap);
			String type = new String(product.getPtype().getBytes("ISO-8859-1"),"UTF-8");
			String pdesc1 = new String(product.getPdesc1().getBytes("ISO-8859-1"),"UTF-8");
			String pdesc2 = new String(product.getPdesc2().getBytes("ISO-8859-1"),"UTF-8");
			product.setPtype(type);
			product.setPdesc1(pdesc1);
			product.setPdesc2(pdesc2);
			product.setPimage("9590777.jpg");
			productService.updateProduct(product);
			return "/AProductServlet?action=getAllProducts";
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	


}
