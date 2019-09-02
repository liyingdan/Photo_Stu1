package service;
import java.util.List;
import Dao.ClothesDao;
import domian.PageBean;
import domian.clothes;

public class ClothesService {
	
	ClothesDao ClothesDao = new ClothesDao();
	public List<clothes> getAllClothes() throws Exception {
		//�����ݿ��л�ȡ���е�����
		List<clothes> allClothes = ClothesDao.getAllClothes();
		return allClothes;
	}
	
	
	//ɾ���·�
	public void deleteClothes(String id) throws Exception {
		ClothesDao.delClothes(Integer.parseInt(id));

	}

	//����·�
	public void addClothes(clothes clothes) throws Exception {
		ClothesDao.addClothes(clothes);
		
	}


	public clothes getClothesWithId(String id) throws Exception {
		return ClothesDao.getClothesWithId(id);
		
	}


	public void updateClothes(clothes clothes) throws Exception {
		ClothesDao.updateClothes(clothes);
		
	}

	//��ȡҳ��
	public PageBean getPageBean(Integer currentPage) throws Exception {
		PageBean pageBean = new PageBean();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		//����������¼
		Long count = ClothesDao.getCount();
		pageBean.setTotalCount(count.intValue());
		//һҳչʾ����������
		Integer pageCount = 6;
		//��ҳ��
		double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / pageCount);
		pageBean.setTotalPage((int)totalPage);
		//��ǰҳ��ѯ�Ľű�
		Integer index = (pageBean.getCurrentPage() - 1)*pageCount;
		List<clothes> list = ClothesDao.getPageDate(index, pageCount);
		pageBean.setClothesList(list);
		return pageBean;
		
	}


}
