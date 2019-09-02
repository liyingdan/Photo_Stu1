package Dao;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domian.clothes;
import domian.picturefile;
import util.JdbcUtil;

public class pictureUploadDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	//获取所有上传的文件
	public List<picturefile> getAllPicFile() throws SQLException{
		return qr.query("select * from picturefile", new BeanListHandler<picturefile>(picturefile.class));
	}

	//上传图片压缩包(添加)
	public void add(picturefile picturefile) throws SQLException {
		qr.update("insert into picturefile(file_add,username,filename) value(?,?,?)",picturefile.getFile_add(),picturefile.getUsername(),picturefile.getFilename());
		
		
	}

	public void deletePicFile(String id) throws SQLException {
		/*String sql = "delete from clothes where id=?";
		qr.update(sql,id);*/
		qr.update("delete from picturefile where fid=?",id);
		
	}

	public picturefile getPicFileWname(String cname) throws SQLException {
		return qr.query("select * from picturefile where username=?", new BeanHandler<picturefile>(picturefile.class),cname);
		
		
	}

}
