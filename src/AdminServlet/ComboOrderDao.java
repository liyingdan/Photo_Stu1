package AdminServlet;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domian.ComboOrder;
import util.JdbcUtil;

public class ComboOrderDao {
	private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	public List<ComboOrder> getAllcomboOrder() throws SQLException {
		return qr.query("select * from ComboOrder", new BeanListHandler<ComboOrder>(ComboOrder.class));
		
		
	}

}
