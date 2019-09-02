package Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domian.clothes;
import util.JdbcUtil;

public class ClothesDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	//1.从数据库中查询所有的租赁衣服列表
	public List<clothes> getAllClothes() throws SQLException{
		//1)查询操作
		String sql = "select * from clothes";
		//2)执行sql
		List<clothes> allClothes = null;
		allClothes = qr.query(sql, new BeanListHandler<clothes>(clothes.class));
		return allClothes;
	}
	
	//2.添加衣服到数据库中
	public void addClothes(clothes clothes) throws SQLException {
		//插入操作
		String sql ="insert into clothes(name,price,image) value(?,?,?)";
		qr.update(sql,clothes.getName(),clothes.getPrice(),clothes.getImage());
	}
	
	//3.根据id删除一件衣服
	public void delClothes(int id) throws SQLException {
		//删除操作
		String sql = "delete from clothes where id=?";
		qr.update(sql,id);
	}
	
	//4.传入一件衣服，到数据库中根据id更新该衣服
	public void updateClothes(clothes clothes) throws SQLException {
		//更新操作
		String sql = "update clothes set name=?,price=?,image=? where id=?";
		qr.update(sql,clothes.getName(),clothes.getPrice(),clothes.getImage(),clothes.getId());
	}
	
	
	//5.根据传入的id查找该衣服
	public clothes getClothesWithId(String id) throws Exception {
		return qr.query("select * from clothes where id=?", new BeanHandler<clothes>(clothes.class),Integer.parseInt(id));
		
	}


	public Long getCount() throws Exception {
		Long count = (Long)qr.query("select count(*) from clothes", new ScalarHandler());
		return count;

	}
	
	public List<clothes> getPageDate(Integer index, Integer pageCount) throws Exception {
		 return qr.query("select * from clothes limit ?,?", new BeanListHandler<clothes>(clothes.class),index,pageCount);
		
	}



}
