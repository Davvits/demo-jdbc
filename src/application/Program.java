package application;

import java.time.LocalDate;

import model.entities.Department;
import model.entities.Seller;


public class Program {

	public static void main(String[] args) {
		Department d = new Department(1,"seinen");
		Seller x = new Seller(1,"davi","dada@amil.com",LocalDate.now(),2000.0,d);
		System.out.println(x);
	}

}
