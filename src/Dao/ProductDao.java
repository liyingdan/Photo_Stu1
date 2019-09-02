package Dao;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domian.product;
import util.JdbcUtil;

public class ProductDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	
	public List<product> getAllProducts() throws Exception {
		return qr.query("select * from product", new BeanListHandler<product>(product.class));
		
	}

	public product getProductsWithId(String id) throws Exception {
		return qr.query("select * from product where pid=?", new BeanHandler<product>(product.class),Integer.parseInt(id));
		
	}
	//¸üÐÂ
	public void updateProduct(product product) throws Exception {
		String sql = "update product set ptype=?,pimage=?,pdesc1=?,pdesc2=? where pid=?";
		qr.update(sql, product.getPtype(),product.getPimage(),product.getPdesc1(),product.getPdesc2(),product.getPid());
		
	}
	

}
