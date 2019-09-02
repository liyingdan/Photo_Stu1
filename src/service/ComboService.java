package service;

import java.util.List;

import Dao.ComboDao;
import domian.PageBean;
import domian.combo;

public class ComboService {
	private ComboDao comboDao = new ComboDao();
	public List<combo> findAllCombos() throws Exception {
		return comboDao.findAllCombos();
	}
	public void addCombo(combo combo) throws Exception {
		comboDao.addCombo(combo);
		
	}
	public void deleteCombo(String id) throws Exception {
		comboDao.deleteCombo(id);
		
	}
	public combo getComboWithId(String id) throws Exception {
		return comboDao.getComboWithId(id);
		
	}
	public void updateCombo(combo combo) throws Exception {
		comboDao.updateCombo(combo);
		
	}
	
	
	
	
	//页码
	public PageBean getPageBean(Integer currentPage) throws Exception {
		PageBean pageBean = new PageBean();
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		//共多少条记录
		Long count = comboDao.getCount();
		pageBean.setTotalCount(count.intValue());
		//一页展示多少条数据
		Integer pageCount = 6;
		//总页数
		double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageCount);
		pageBean.setTotalPage((int)totalPage);
		//当前页查询的脚标
		Integer index = (pageBean.getCurrentPage() - 1)*pageCount;
		List<combo> list = comboDao.getPageDate(index, pageCount);
		pageBean.setComboList(list);;
		return pageBean;
	}


}
