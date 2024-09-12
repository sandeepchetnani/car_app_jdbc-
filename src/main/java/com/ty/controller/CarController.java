package com.ty.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.ty.dao.CarDao;
import com.ty.dto.Car;

public class CarController {

	public static void save(Scanner scanner) throws SQLException {
		Car car = new Car();
		CarDao cardao=new CarDao();
		System.out.println("enter your id");
		int id = scanner.nextInt();
		System.out.println("enter your name");
		String name = scanner.next();
		System.out.println("enter your brand");
		String brand = scanner.next();
		System.out.println("enter your cost");
		int cost = scanner.nextInt();
		System.out.println("enter your manufacturingyear");
		int year = scanner.nextInt();
		car.setId(id);
		car.setBrand(brand);
		car.setCost(cost);
		car.setManufactureYear(year);
		car.setName(name);
		cardao.saveCar(car);
		System.out.println("saved succesfull");

	}

	public static void update(Scanner scanner) throws SQLException {
		Car car = new Car();
		CarDao cardao=new CarDao();
		System.out.println("enter your id");
		int id = scanner.nextInt();
		System.out.println("enter your name");
		String name = scanner.next();
		System.out.println("enter your brand");
		String brand = scanner.next();
		System.out.println("enter your cost");
		int cost = scanner.nextInt();
		System.out.println("enter your manufacturingyear");
		int year = scanner.nextInt();
		car.setId(id);
		car.setBrand(brand);
		car.setCost(cost);
		car.setManufactureYear(year);
		car.setName(name);
		cardao.updateCar(car);
		System.out.println("update succesfull");

	}

	public static void findById(Scanner scanner) throws SQLException {
		Car car = new Car();
		CarDao cardao = new CarDao();
		System.out.println("enter your id");
		int id = scanner.nextInt();
		car.setId(id);
		System.out.println(cardao.findByIdCar(car.getId()));

	}

	public static void findAll(Scanner scanner) throws SQLException {
		CarDao cardao = new CarDao();
		Car car = new Car();
		System.out.println(cardao.displayCar(car));

	}

	public static void delete(Scanner scanner) throws SQLException {
		Car car = new Car();
		CarDao cardao = new CarDao();
		System.out.println("enter your id");
		int id = scanner.nextInt();
		car.setId(id);
		if (cardao.deleteCar(car.getId())) {
			System.out.println("deleted successfully");
		} else {
			System.out.println("data not present");
		}

	}

	public static void main(String[] args) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		boolean check = true;
		while (check) {
			System.out.println("Welcome to car");
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