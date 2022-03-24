package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n=== TEST 1: deparment insert ====");
		Department newDepartment = new Department(null, "Toys");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n=== TEST 2: deparment delete ====");
		System.out.println("Enter Department id for delete");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Departmente Deleted!");

		System.out.println("\n=== TEST 4: deparment findById ====");
		newDepartment = departmentDao.findById(3);
		System.out.println(newDepartment);

		System.out.println("\n=== TEST 4: deparment update ====");
		System.out.println("Enter Department for update");
		id = sc.nextInt();
		newDepartment = departmentDao.findById(id);
		newDepartment.setName("Brinquedos");
		departmentDao.update(newDepartment);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 5: deparment findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		sc.close();
	}

}
