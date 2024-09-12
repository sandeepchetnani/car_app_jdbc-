package com.ty.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ty.dto.User;

public class UserDao {
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

	public User saveUser(User user) throws SQLException {
		String sql = "Insert into users values (?,?,?,?,?)";
		PreparedStatement pstm = connection.prepareStatement(sql);
		pstm.setInt(1, user.getId());
		pstm.setString(2, user.getName());
		pstm.setString(3, user.getEmail());
		pstm.setString(4, user.getPassword());
		pstm.setString(5, user.getPhoneNumber());
		if (pstm.executeUpdate() == 1) {
			connection.close();
			return user;
		} else {
			connection.close();
			return null;
		}

	}

	public User updateUser(User user) throws SQLException {
		String sql = "update users set name=?,email=?,password=?,phonenumber=? where id=?";
		PreparedStatement pstm = connection.prepareStatement(sql);
		pstm.setInt(5, user.getId());
		pstm.setString(1, user.getName());
		pstm.setString(2, user.getEmail());
		pstm.setString(3, user.getPassword());
		pstm.setString(4, user.getPhoneNumber());
		if (pstm.executeUpdate() == 1) {
			connection.close();
			return user;
		} else {
			connection.close();
			return null;
		}

	}

	public boolean deleteUser(int id) throws SQLException {
		// User user=new User();
		String sql = "delete from users where id=" + id;
		Statement stm = connection.createStatement();
		if (stm.executeUpdate(sql) > 0) {
			connection.close();
			return true;
		} else {
			connection.close();
			return false;
		}

	}

	public User findByIdUser(int id) throws SQLException {
		String sql = "select * from users where id=" + id;
		Statement stm = connection.createStatement();
		ResultSet resultset = stm.executeQuery(sql);
		if (resultset.next()) {
			User user = new User();
			user.setId(resultset.getInt(1));
			user.setName(resultset.getString(2));
			user.setEmail(resultset.getString(3));
			user.setPassword(resultset.getString(4));
			user.setPhoneNumber(resultset.getString(5));
			connection.close();
			return user;
		}

		else {
			connection.close();
			return null;
		}

	}

	public List<User> displayUser(User user) throws SQLException {
		String sql = "select * from users";
		Statement stm = connection.createStatement();
		ResultSet resultset = stm.executeQuery(sql);
		List<User> list = new ArrayList<User>();
		while (resultset.next()) {
			user.setId(resultset.getInt(1));
			user.setName(resultset.getString(2));
			user.setEmail(resultset.getString(3));
			user.setPassword(resultset.getString(4));
			user.setPhoneNumber(resultset.getString(5));
			list.add(user);
		}
		connection.close();
		return list;

	}
}
