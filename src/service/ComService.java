package service;

import java.util.List;

import Dao.ComDao;
import domian.comment;

public class ComService {
	ComDao comDao = new ComDao();
	
	public List<comment> getAllCom() throws Exception {
		return comDao.getAllCom();
	}
	
	
	public void delComment(String id) throws Exception {
		comDao.delComment(Integer.parseInt(id));

	}


	public void addComment(comment comment) throws Exception {
		comDao.addComment(comment);
		
	}

}
