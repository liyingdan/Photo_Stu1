package service;
import java.util.List;

import Dao.AdminDao;
import domian.admin;

public class AdminService {
	private AdminDao adminDao = new AdminDao();
	public admin login(String name, String pwd) throws Exception {
		//����Ա��½
		admin admin = adminDao.checkAdmin(name,pwd);
		if(admin != null) {
			return admin;
		}
		else {
			throw new Exception("�û������������");
		}
	}

	//���й���Ա
	public List<admin> getAllAdmin() throws Exception {
		return adminDao.getAllAdmin();
		
	}

	//ɾ������Ա
	public void deleteAdmin(String id) throws Exception {
		adminDao.deleteAdmin(id);
		
	}
	//���ӹ���Ա
	public void addAdmin(admin admin) throws Exception {
		adminDao.addAdmin(admin);
		
	}



}
