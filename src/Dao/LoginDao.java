package Dao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import domian.user;
import util.JdbcUtil;

public class LoginDao {

	public user login(String name, String psd) throws Exception {
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		return qr.query("select * from user where username=? and password=?",new BeanHandler<user>(user.class),name,psd);
		
	}
	
	
	

}

