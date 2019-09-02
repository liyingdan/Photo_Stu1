package service;

import Dao.LoginDao;
import domian.user;

public class LoginService {

	public user login(String name, String psd) throws Exception {
		LoginDao loginDao = new LoginDao();
		user user = loginDao.login(name,psd);
		
		if(user != null) {
			return user;
		}
		else {
			throw new Exception("用户名或密码错误");
		}
	}

}
