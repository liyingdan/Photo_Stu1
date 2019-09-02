package service;

import java.sql.SQLException;
import Dao.PurchaseDao;
import domian.ClothesOrder;

public class PurchaseService {
	private PurchaseDao purchaseDao = new PurchaseDao();

	public void addCloOrder(ClothesOrder clothesOrder) throws SQLException {
		purchaseDao.addCloOrder(clothesOrder);
		
	}

}
