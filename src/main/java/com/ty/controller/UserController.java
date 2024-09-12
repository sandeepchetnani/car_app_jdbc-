package com.ty.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.ty.dao.UserDao;
import com.ty.dto.User;

public class UserController {
	public static void save(Scanner scanner) throws SQLException {
		User user = new User();
		UserDao userdao=new UserDao();
		System.out.println("enter your id");
		int id = scanner.nextInt();
		System.out.println("enter your name");
		String name = scanner.next();
		System.out.println("enter your email");
		String email = scanner.next();
		System.out.println("enter your password");
		String password = scanner.next();
		System.out.println("enter your phonenumber");
		String phonenumber = scanner.next();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phonenumber);
		userdao.saveUser(user);
		System.out.println("saved succesfull");

	}

	public static void update(Scanner scanner) throws SQLException {
		User user = new User();
		UserDao userdao=new UserDao();
		System.out.println("enter your id");
		int id = scanner.nextInt();
		System.out.println("enter your name");
		String name = scanner.next();
		System.out.println("enter your email");
		String email = scanner.next();
		System.out.println("enter your password");
		String password = scanner.next();
		System.out.println("enter your phonenumber");
		String phonenumber = scanner.next();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phonenumber);
		userdao.updateUser(user);
		System.out.println("update succesfull");

	}

	public static void findById(Scanner scanner) throws SQLException {
		User car = new User();
		UserDao userdao = new UserDao();
		System.out.println("enter your id");
		int id = scanner.nextInt();
		car.setId(id);
		System.out.println(userdao.findByIdUser(car.getId()));

	}

	public static void findAll(Scanner scanner) throws SQLException {
		UserDao userdao = new UserDao();
		User user = new User();
		System.out.println(userdao.displayUser(user));

	}

	public static void delete(Scanner scanner) throws SQLException {
		User user = new User();
		UserDao userdao = new UserDao();
		System.out.println("enter your id");
		int id = scanner.nextInt();
		user.setId(id);
		if (userdao.deleteUser(user.getId())) {
			System.out.println("deleted successfully");
		} else {
			System.out.println("data not present");
		}

	}

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		boolean check = true;
		while (check) {
			System.out.println("Welcome to User");
			System.out.println("Enter your choice");
			System.out.println("1 for save");
			System.out.println("2 for update");
			System.out.println("3 for findby id");
			System.out.println("4 for findall");
			System.out.println("5 for delete");
			System.out.println("0 for exist");
			int choice = scanner.nextInt();
			if (choice == 0) {
				check = false;
				break;
			}
			switch (choice) {
			case 1: {
				save(scanner);
				break;
			}
			case 2: {
				update(scanner);
				break;
			}
			case 3: {
				findById(scanner);
				break;
			}
			case 4: {
				findAll(scanner);
				break;
			}
			case 5: {
				delete(scanner);
				break;
			}
			default: {
				System.out.println("Invalid choice");
			}
			}
		}
	}

}
