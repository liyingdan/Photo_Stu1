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
	//�鿴�Ƿ��иù���Ա����¼
	public admin checkAdmin(String name, String pwd) throws SQLException {
		
		String sql = "select * from admin where username=? and password=?";
		admin admin = null;
		admin = qr.query(sql, new BeanHandler<admin>(admin.class),name,pwd);
		return admin;
			
	}
	
	
	
	//�õ����й���Ա
	public List<admin> getAllAdmin() throws Exception {
		return qr.query("select * from admin", new BeanListHandler<admin>(admin.class));
		
	}


	//ɾ������Ա
	public void deleteAdmin(String id) throws Exception {
		qr.update("delete from admin where id=?",id);
		
	}
	
	
	//2.��ӹ���Ա�����ݿ���
	public void addAdmin(admin admin) throws SQLException {
		//�������
		qr.update("insert into admin(username,password) value(?,?)",admin.getUsername(),admin.getPassword());
	}

	

}
