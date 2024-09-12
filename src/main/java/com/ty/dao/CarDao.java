package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ty.dto.Car;

public class CarDao {
	static Connection connection = null;
	{

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/car_app", "postgres", "admin");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Car saveCar(Car car) throws SQLException {
		String sql = "Insert into car values (?,?,?,?,?)";
		PreparedStatement pstm = connection.prepareStatement(sql);
		pstm.setInt(1, car.getId());
		pstm.setString(2, car.getName());
		pstm.setString(3, car.getBrand());
		pstm.setInt(4, car.getCost());
		pstm.setInt(5, car.getManufactureYear());
		if (pstm.executeUpdate() == 1) {
			connection.close();
			return car;
		} else {
			connection.close();
			return null;
		}

	}

	public Car updateCar(Car car) throws SQLException {
		String sql = "update car set name=?,brand=?,cost=?,manufactureyear=? where id=?";
		PreparedStatement pstm = connection.prepareStatement(sql);
		pstm.setInt(5, car.getId());
		pstm.setString(1, car.getName());
		pstm.setString(2, car.getBrand());
		pstm.setInt(3, car.getCost());
		pstm.setInt(4, car.getManufactureYear());
		if (pstm.executeUpdate() == 1) {
			connection.close();
			return car;
		} else {
			connection.close();
			return null;
		}

	}

	public boolean deleteCar(int id) throws SQLException {
		//Car car=new Car();
		String sql = "delete from car where id="+id;
		Statement stm = connection.createStatement();
		if (stm.executeUpdate(sql) > 0) {
			connection.close();
			return true;
		} else {
			connection.close();
			return false;
		}

	}

	public Car findByIdCar(int id) throws SQLException {
		String sql = "select * from car where id="+id;
		Statement stm=connection.createStatement();
		ResultSet resultset=stm.executeQuery(sql);
		if(resultset.next())
		{
			Car car=new Car();
			car.setId(resultset.getInt(1));
			car.setName(resultset.getString(2));
			car.setBrand(resultset.getString(3));
			car.setCost(resultset.getInt(4));
			car.setManufactureYear(resultset.getInt(5));
			connection.close();
			return car;
		}
		
		else {
			connection.close();
			return null;
		}
		

	}

	public List<Car> displayCar(Car car) throws SQLException {
		String sql = "select * from car";
		Statement stm=connection.createStatement();
		ResultSet resultset=stm.executeQuery(sql);
		List<Car> list=new ArrayList<Car>();
		while(resultset.next())
		{
			car.setId(resultset.getInt(1));
			car.setName(resultset.getString(2));
			car.setBrand(resultset.getString(3));
			car.setCost(resultset.getInt(4));
			car.setManufactureYear(resultset.getInt(5));
			list.add(car);
		}
		connection.close();
		return list;
		
	}

}
