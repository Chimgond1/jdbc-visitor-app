package com.ty.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.ty.visitot.dto.Visitor;
import com.ty.visitot.util.ConnectionObject;

public class VisitorDao {
	public int saveVisitor(Visitor visitor) {
		int resultCount = 0;
		String query = "insert into visitor values(?,?,?,?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, visitor.getId());
			preparedStatement.setString(2, visitor.getName());
			preparedStatement.setString(3, visitor.getEmail());
			preparedStatement.setString(4, visitor.getPhone());
			preparedStatement.setInt(5, visitor.getAge());
			preparedStatement.setString(6, visitor.getGender());
			preparedStatement.setString(7, visitor.getDob() + "");
			preparedStatement.setString(8, visitor.getVisitorDateTime() + "");
			resultCount = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultCount;

	}

	public Visitor getVisitorById(int id) {
		String query = "select * from visitor where id=?";
		Connection connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Visitor visitor = new Visitor();
				visitor.setId(resultSet.getInt(1));
				visitor.setName(resultSet.getString(2));
				visitor.setEmail(resultSet.getString(3));
				visitor.setPhone(resultSet.getString(4));
				visitor.setAge(resultSet.getInt(5));
				visitor.setGender(resultSet.getString(6));
				return visitor;
			} else {
				return null;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<Visitor> getVisitorByDate() {
		return null;
	}

	public List<Visitor> getVisitorByAgeRange(int startAge, int endAge) {
		return null;
	}

}
