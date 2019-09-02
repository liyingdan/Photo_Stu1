package Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import domian.admin;
import util.JdbcUtil;

public class AdminDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	//查看是否有该管理员，登录
	public admin checkAdmin(String name, String pwd) throws SQLException {
		
		String sql = "select * from admin where username=? and password=?";
		admin admin = null;
		admin = qr.query(sql, new BeanHandler<admin>(admin.class),name,pwd);
		return admin;
			
	}
	
	
	
	//得到所有管理员
	public List<admin> getAllAdmin() throws Exception {
		return qr.query("select * from admin", new BeanListHandler<admin>(admin.class));
		
	}


	//删除管理员
	public void deleteAdmin(String id) throws Exception {
		qr.update("delete from admin where id=?",id);
		
	}
	
	
	//2.添加管理员到数据库中
	public void addAdmin(admin admin) throws SQLException {
		//插入操作
		qr.update("insert into admin(username,password) value(?,?)",admin.getUsername(),admin.getPassword());
	}

	

}
