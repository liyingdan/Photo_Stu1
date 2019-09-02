package Dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domian.ClothesOrder;
import util.JdbcUtil;

public class OrderDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	public List<ClothesOrder> getAllOrder() throws Exception {
		String sql = "select * from ClothesOrder";
		return qr.query(sql, new BeanListHandler<ClothesOrder>(ClothesOrder.class));	
	}
	

}
