package application;

import java.time.LocalDate;
import java.util.Date;

import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import model.dao.FactoryDao;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = FactoryDao.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
	}

}
