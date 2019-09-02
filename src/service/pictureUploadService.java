package service;

import java.sql.SQLException;
import java.util.List;

import Dao.pictureUploadDao;
import domian.picturefile;

public class pictureUploadService {
	
	pictureUploadDao pictureUploaddao = new pictureUploadDao();
	
	public void add(picturefile picturefile) throws SQLException {
		pictureUploaddao.add(picturefile);
		
	}

	public List<picturefile> getAllPicFile() throws SQLException {
		return pictureUploaddao.getAllPicFile();
		
	}

	public void deletePicFile(String id) throws SQLException {
		pictureUploaddao.deletePicFile(id);
		
	}

	public picturefile getPicFileWname(String cname) throws SQLException {
		return pictureUploaddao.getPicFileWname(cname);
		
	}

}
