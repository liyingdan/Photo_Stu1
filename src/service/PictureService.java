package service;

import java.util.List;

import Dao.PictureDao;
import domian.picture;

public class PictureService {
	private PictureDao pictureDao = new PictureDao();
	public List<picture> getAllPictures() throws Exception {
		List<picture> allPictures = pictureDao.getAllPictures();
		return allPictures;
		
	}

	public picture getPictureWithId(String id) throws Exception {
		return pictureDao.getPictureWithId(id);
		
	}

}
