package Dao;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domian.combo;
import util.JdbcUtil;

public class ComboDao {
	
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	
	public List<combo> findAllCombos() throws Exception {
		String sql = "select * from combo";
		return qr.query(sql, new BeanListHandler<combo>(combo.class));	
		
	}
	public void addCombo(combo combo) throws Exception {
		String sql = "insert into combo(name,price,image,camerist,type) value(?,?,?,?,?)";
		qr.update(sql, combo.getName(),combo.getPrice(),combo.getImage(),combo.getCamerist(),combo.getType());
		
	}
	public void deleteCombo(String id) throws Exception {
		qr.update("delete from combo where id=?",id);
		
	}
	public combo getComboWithId(String id) throws Exception {
		return qr.query("select * from combo where id=?", new BeanHandler<combo>(combo.class),Integer.parseInt(id));
		
	}
	public void updateCombo(combo combo) throws Exception {
		String sql = "update combo set name=?,price=?,image=?,camerist=?,type=? where id=?";
		qr.update(sql,combo.getName(),combo.getPrice(),combo.getImage(),combo.getCamerist(),combo.getType(),combo.getId());
	}
	
	public Long getCount() throws Exception {
		Long count = (Long)qr.query("select count(*) from combo", new ScalarHandler());
		return count;

	}
	
	public List<combo> getPageDate(Integer index, Integer pageCount) throws Exception {
		 return qr.query("select * from combo limit ?,?", new BeanListHandler<combo>(combo.class),index,pageCount);
		
	}

}
