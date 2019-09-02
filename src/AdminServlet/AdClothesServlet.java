package AdminServlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import domian.PageBean;
import domian.clothes;
import lombok.Setter;
import service.ClothesService;
import servlet.BaseServlet;


@WebServlet("/AdClothesServlet")
public class AdClothesServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	//获取到所有的衣服
	public String getAllClothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.调用服务层
		ClothesService ClothesService = new ClothesService();
		try {
			List<clothes> allClothes = ClothesService.getAllClothes();
			Collections.reverse(allClothes);
			//把数据写到request域
			request.setAttribute("allClothes", allClothes);
			//转发
			return "admin/AClothes.jsp";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//根据id删除衣服
	public String DelClothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收id
		String id = request.getParameter("id");
		//删除商品
		ClothesService ClothesService = new ClothesService();
		try {
			ClothesService.deleteClothes(id);
			return "/AdClothesServlet?action=getPageDate&currentPage=1";
			//return "/AdClothesServlet?action=getAllClothes";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//修改衣服前期（显示要修改衣服的原来信息）
	public String AlterUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("clothesid="+id);
		
		try {
			ClothesService clothesService = new ClothesService();
			clothes clothes = clothesService.getClothesWithId(id);
			request.setAttribute("clothes", clothes);
			return "admin/ClothesAlter.jsp";
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//修改衣服
	public String AlterClothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		clothes clothes = new clothes();
		try {
			BeanUtils.populate(clothes, parameterMap);
			String name=new String(clothes.getName().getBytes("ISO-8859-1"),"UTF-8");
			clothes.setName(name);
			ClothesService clothesService = new ClothesService();
			clothes.setImage("c3.jpg");
			clothesService.updateClothes(clothes);
			return "/AdClothesServlet?action=getPageDate&currentPage=1";
			//return "/AdClothesServlet?action=getAllClothes";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	//增加衣服

	public String AddClothes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add--------");
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		clothes clothes = new clothes();
		try {
			BeanUtils.populate(clothes, parameterMap);
			String name=new String(clothes.getName().getBytes("ISO-8859-1"),"UTF-8");
			clothes.setName(name);
			//添加图片暂时这样写
			clothes.setImage("c8.jpg");
			//System.out.println(clothes);
			ClothesService clothesService = new ClothesService();
			clothesService.addClothes(clothes);
			return "/AdClothesServlet?action=getPageDate&currentPage=1";
			//return "/AdClothesServlet?action=getAllClothes";			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return null;
	}
	

	//获取页码
	public String getPageDate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			//获取当前页码
			String currentPage = request.getParameter("currentPage");
			ClothesService clothesService = new ClothesService();
			PageBean pageBean = clothesService.getPageBean(Integer.parseInt(currentPage));
			List<clothes> clothesList = pageBean.getClothesList();
			Collections.reverse(clothesList);
			pageBean.setClothesList(clothesList);
			request.setAttribute("pageBean", pageBean);
			return "admin/AClothes.jsp";	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
