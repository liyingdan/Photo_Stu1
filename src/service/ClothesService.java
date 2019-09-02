package service;
import java.util.List;
import Dao.ClothesDao;
import domian.PageBean;
import domian.clothes;

public class ClothesService {
	
	ClothesDao ClothesDao = new ClothesDao();
	public List<clothes> getAllClothes() throws Exception {
		//从数据库中获取所有的数据
		List<clothes> allClothes = ClothesDao.getAllClothes();
		return allClothes;
	}
	
	
	//删除衣服
	public void deleteClothes(String id) throws Exception {
		ClothesDao.delClothes(Integer.parseInt(id));

	}

	//添加衣服
	public void addClothes(clothes clothes) throws Exception {
		ClothesDao.addClothes(clothes);
		
	}


	public clothes getClothesWithId(String id) throws Exception {
		return ClothesDao.getClothesWithId(id);
		
	}


	public void updateClothes(clothes clothes) throws Exception {
		ClothesDao.updateClothes(clothes);
		
	}

	//获取页码
	public PageBean getPageBean(Integer currentPage) throws Exception {
		PageBean pageBean = new PageBean();
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		//共多少条记录
		Long count = ClothesDao.getCount();
		pageBean.setTotalCount(count.intValue());
		//一页展示多少条数据
		Integer pageCount = 6;
		//总页数
		double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageCount);
		pageBean.setTotalPage((int)totalPage);
		//当前页查询的脚标
		Integer index = (pageBean.getCurrentPage() - 1)*pageCount;
		List<clothes> list = ClothesDao.getPageDate(index, pageCount);
		pageBean.setClothesList(list);
		return pageBean;
		
	}


}
