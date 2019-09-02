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
	
	
	
	
	//ҳ��
	public PageBean getPageBean(Integer currentPage) throws Exception {
		PageBean pageBean = new PageBean();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		//����������¼
		Long count = comboDao.getCount();
		pageBean.setTotalCount(count.intValue());
		//һҳչʾ����������
		Integer pageCount = 6;
		//��ҳ��
		double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageCount);
		pageBean.setTotalPage((int)totalPage);
		//��ǰҳ��ѯ�Ľű�
		Integer index = (pageBean.getCurrentPage() - 1)*pageCount;
		List<combo> list = comboDao.getPageDate(index, pageCount);
		pageBean.setComboList(list);;
		return pageBean;
	}


}
