package application;


import model.dao.SellerDao;
import model.entities.Seller;

import java.util.List;

import model.dao.FactoryDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = FactoryDao.createSellerDao();
		System.out.println("===== TEST: 1: seller findById ======");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("=========== TEST: 2 seller findByDepar ===");
		Department dep1 = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(dep1);
		list.stream().forEach(System.out::println);
	}

}
