package application;


import model.dao.SellerDao;
import model.entities.Seller;

import java.util.Date;
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
		
		System.out.println();
		
		System.out.println("=========== TEST: 2 seller findAll ===");
		List<Seller> list2 = sellerDao.findAll();
		list2.stream().forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("=========== TEST: INSERT l ===");
		Seller s = new Seller(null,"Davi","kali@kalie.com",new Date(),4000.0,dep1);
		sellerDao.insert(s);
		System.out.println("Inserted! new ID "+s.getId());
		
		System.out.println();
		
		System.out.println("=========== TEST: UPDATE l ===");
		Seller s2 = sellerDao.findById(10);
		s2.setEmail("lhemamaei@gmail.com");
		sellerDao.update(s2);;
		System.out.println("Update! new news "+s2);
		
		
	}

}
