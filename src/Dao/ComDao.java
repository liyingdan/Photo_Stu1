package Dao;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import domian.comment;
import util.JdbcUtil;

public class ComDao {
	
	QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	public List<comment> getAllCom() throws Exception {
		return qr.query("select * from comment", new BeanListHandler<comment>(comment.class));
		
	}
	
	public void delComment(int id) throws SQLException {
		qr.update("delete from comment where cid=?",id);
		
	}

	public void addComment(comment comment) throws Exception {
		qr.update("insert into comment(username,ccom,cdate) value(?,?,?)", comment.getUsername(),comment.getCcom(),comment.getCdate());
		
	}

}
