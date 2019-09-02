package service;

import java.util.List;

import Dao.ProductDao;
import domian.product;

public class ProductService {
	private ProductDao productDao = new ProductDao();
	public List<product> getAllProducts() throws Exception {
		List<product> allProducts = productDao.getAllProducts();
		return allProducts;
		
	}

	public product getProductsWithId(String id) throws Exception {
		return productDao.getProductsWithId(id);
		
	}

	public void updateProduct(product product) throws Exception {
		productDao.updateProduct(product);
		
	}

}
