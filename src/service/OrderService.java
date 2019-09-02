package service;
import java.util.List;

import Dao.OrderDao;
import domian.ClothesOrder;

public class OrderService {
	
	OrderDao orderDao = new OrderDao();
	public List<ClothesOrder> getAllOrder() throws Exception {
		return orderDao.getAllOrder();
		
	}

}
