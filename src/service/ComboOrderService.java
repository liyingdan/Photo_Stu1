package service;

import java.sql.SQLException;
import java.util.List;

import AdminServlet.ComboOrderDao;
import domian.ComboOrder;

public class ComboOrderService {

	ComboOrderDao comboOrderDao = new ComboOrderDao();
	public List<ComboOrder> getAllcomboOrder() throws SQLException {
		return comboOrderDao.getAllcomboOrder();
		
	}

}
