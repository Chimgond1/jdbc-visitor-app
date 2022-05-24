package com.ty.visitor.dao;

import java.security.KeyStore.SecretKeyEntry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.visitot.dto.User;
import com.ty.visitot.util.AES;
import com.ty.visitot.util.ConnectionObject;
import static com.ty.visitot.util.AppConstant.*;

public class UserDao {

	Connection connection = connection = ConnectionObject.getConnection();;

	public int saveUser(User user) {
		try {

			String query = "insert into user values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getRole());
			preparedStatement.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}
		return 0;

	}

	public void validateUser(String email, String password) {
		String query = "select * from visitor where email=? and password=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				//user.setName( resultSet.getString(2));
				System.out.println(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPhone(resultSet.getString(4));
				user.setRole(resultSet.getString(5));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int updateUser(User user) {
		String quary = "update user set name=?,phone=?,password=?,role=? where id=? and email=?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(quary);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getPhone());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setString(4, user.getRole());
			prepareStatement.setInt(5, user.getId());
			prepareStatement.setString(6, user.getEmail());
			return prepareStatement.executeUpdate();

		} catch (SQLException e) {
		}
		return 0;
	}

	public int deleteUser(User user) {
		String query = "delete from user where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, user.getId());
		return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

}
