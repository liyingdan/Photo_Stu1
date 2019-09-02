package Dao;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;

import domian.ClothesOrder;
import util.JdbcUtil;

public class PurchaseDao {
	
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	
	//Ìí¼Ó¶©µ¥
	public void addCloOrder(ClothesOrder clothesOrder) throws SQLException {
		String sql ="insert into ClothesOrder(username,clothesname,price) value(?,?,?)";
		qr.update(sql,clothesOrder.getUsername(),clothesOrder.getClothesname(),clothesOrder.getPrice());

	}
	

}
