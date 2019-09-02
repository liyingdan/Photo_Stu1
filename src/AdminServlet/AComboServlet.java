package AdminServlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import domian.PageBean;
import domian.combo;
import domian.product;
import service.ComboService;

import service.ProductService;
import servlet.BaseServlet;

@WebServlet("/AComboServlet")
public class AComboServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private ComboService comboService = new ComboService();
	public String getAllCombo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<combo> allCombos = comboService.findAllCombos();
			Collections.reverse(allCombos);
			HttpSession session = request.getSession();
			session.setAttribute("allCombos", allCombos);
			return "admin/Acase.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	public String AddComUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductService productService = new ProductService();
			List<product> allProducts = productService.getAllProducts();
			//存域
			request.setAttribute("allProducts", allProducts);
			//转发到主页
			return "admin/CaseAdd.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	//增加套餐
	public String AddCombo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		combo combo = new combo();
		try {
			BeanUtils.populate(combo, parameterMap);
			String name = new String(combo.getName().getBytes("ISO-8859-1"),"UTF-8");
			String camerist = new String(combo.getCamerist().getBytes("ISO-8859-1"),"UTF-8");
			String type = new String(combo.getType().getBytes("ISO-8859-1"),"UTF-8");
			combo.setName(name);
			combo.setCamerist(camerist);
			combo.setType(type);
			combo.setImage("4d.jpg");
			comboService.addCombo(combo);
			return "/AComboServlet?action=getPageDate&currentPage=1";
			//return "/AComboServlet?action=getAllCombo";	
			
		}catch (Exception e) {
			e.printStackTrace();
		}

			return null;
		}
	
	
	
	//根据id删除套餐
	public String DelCombo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			comboService.deleteCombo(id);
			return "/AComboServlet?action=getPageDate&currentPage=1";
			//return "/AComboServlet?action=getAllCombo";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//修改套餐前期（显示要修改套餐的原来信息）
	public String AlterUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			//获取当前套餐
			combo combo = comboService.getComboWithId(id);
			request.setAttribute("combo", combo);
			//获取套餐分类
			ProductService productService = new ProductService();
			List<product> allProducts = productService.getAllProducts();
			request.setAttribute("allProducts", allProducts);
			
			return "admin/CaseAlter.jsp";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//修改套餐
	public String AlterCombo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		combo combo = new combo();
		try {
			BeanUtils.populate(combo, parameterMap);
			String name = new String(combo.getName().getBytes("ISO-8859-1"),"UTF-8");
			String camerist = new String(combo.getCamerist().getBytes("ISO-8859-1"),"UTF-8");
			String type = new String(combo.getType().getBytes("ISO-8859-1"),"UTF-8");
			combo.setName(name);
			combo.setCamerist(camerist);
			combo.setType(type); 
			combo.setImage("4d.jpg");
			comboService.updateCombo(combo);
			return "/AComboServlet?action=getPageDate&currentPage=1";
			//return "/AComboServlet?action=getAllCombo";
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	//获取页码
	public String getPageDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//获取当前页码
			String currentPage = request.getParameter("currentPage");
			PageBean pageBean = comboService.getPageBean(Integer.parseInt(currentPage));
			
			List<combo> comboList = pageBean.getComboList();
			Collections.reverse(comboList);
			pageBean.setComboList(comboList);
			
			request.setAttribute("pageBean", pageBean);
			return "admin/Acase.jsp";	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
