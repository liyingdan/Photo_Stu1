package Dao;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domian.picture;
import util.JdbcUtil;

public class PictureDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	//获取所有商品
	public List<picture> getAllPictures() throws Exception {
		return qr.query("select * from picture", new BeanListHandler<picture>(picture.class));

		
	}
	//根据id查询一个商品
	public picture getPictureWithId(String id) throws Exception {
		return qr.query("select * from picture where pid=?", new BeanHandler<picture>(picture.class),Integer.parseInt(id));
		
	}

}
