package service;
import java.util.List;

import Dao.AdminDao;
import domian.admin;

public class AdminService {
	private AdminDao adminDao = new AdminDao();
	public admin login(String name, String pwd) throws Exception {
		//管理员登陆
		admin admin = adminDao.checkAdmin(name,pwd);
		if(admin != null) {
			return admin;
		}
		else {
			throw new Exception("用户名或密码错误");
		}
	}

	//所有管理员
	public List<admin> getAllAdmin() throws Exception {
		return adminDao.getAllAdmin();
		
	}

	//删除管理员
	public void deleteAdmin(String id) throws Exception {
		adminDao.deleteAdmin(id);
		
	}
	//增加管理员
	public void addAdmin(admin admin) throws Exception {
		adminDao.addAdmin(admin);
		
	}



}
