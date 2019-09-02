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
	//1.�����ݿ��в�ѯ���е������·��б�
	public List<clothes> getAllClothes() throws SQLException{
		//1)��ѯ����
		String sql = "select * from clothes";
		//2)ִ��sql
		List<clothes> allClothes = null;
		allClothes = qr.query(sql, new BeanListHandler<clothes>(clothes.class));
		return allClothes;
	}
	
	//2.����·������ݿ���
	public void addClothes(clothes clothes) throws SQLException {
		//�������
		String sql ="insert into clothes(name,price,image) value(?,?,?)";
		qr.update(sql,clothes.getName(),clothes.getPrice(),clothes.getImage());
	}
	
	//3.����idɾ��һ���·�
	public void delClothes(int id) throws SQLException {
		//ɾ������
		String sql = "delete from clothes where id=?";
		qr.update(sql,id);
	}
	
	//4.����һ���·��������ݿ��и���id���¸��·�
	public void updateClothes(clothes clothes) throws SQLException {
		//���²���
		String sql = "update clothes set name=?,price=?,image=? where id=?";
		qr.update(sql,clothes.getName(),clothes.getPrice(),clothes.getImage(),clothes.getId());
	}
	
	
	//5.���ݴ����id���Ҹ��·�
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
