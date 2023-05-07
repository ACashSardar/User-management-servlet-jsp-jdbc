package com.usermgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usermgmt.entity.User;

public class UserDao {
	public void createTable() {
		Connection conn = null;
		try {
			conn = DBUtil.connect();
			PreparedStatement pstm = conn.prepareStatement(Queries.CREATE_TABLE);
			pstm.execute();
			conn.close();
			System.out.println("User table created successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createUser(User user) {
		Connection conn = null;
		try {
			conn = DBUtil.connect();
			PreparedStatement pstm = conn.prepareStatement(Queries.INSERT_USER);
			pstm.setInt(1, generateUniqueId());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getPassword());
			pstm.setString(5, user.getRole());
			pstm.execute();
			conn.close();
			System.out.println("New user created successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User getUser(int id) {
		Connection conn = null;
		User user = null;
		try {
			conn = DBUtil.connect();
			PreparedStatement pstm = conn.prepareStatement(Queries.SELECT_USER_BY_ID);
			pstm.setInt(1, id);
			pstm.executeQuery();
			ResultSet rs = pstm.executeQuery();
			boolean found = false;
			while (rs.next()) {
				if (rs.getInt(1) == id) {
					user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					System.out.println("User found.");
					found = true;
				}
			}
			if (!found) {
				System.out.println("User not found.");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(int id, User user) {
		Connection conn = null;
		try {
			conn = DBUtil.connect();
			PreparedStatement pstm = conn.prepareStatement(Queries.UPDATE_USER);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getEmail());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getRole());
			pstm.setInt(5, id);
			int rows = pstm.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + " row(s) affected, User with id=" + id + " updated.");
			} else {
				System.out.println("User with id=" + id + " not found.");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		Connection conn = null;
		List<User> users = new ArrayList<>();
		try {
			conn = DBUtil.connect();
			PreparedStatement pstm = conn.prepareStatement(Queries.SELECT_USERS);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
			System.out.println("User list traversed successfully.");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void deleteUser(int id) {
		Connection conn = null;
		try {
			conn = DBUtil.connect();
			PreparedStatement pstm = conn.prepareStatement(Queries.DELETE_USER);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			int rows = pstm.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + " row(s) affected, User with id=" + id + " deleted.");
			} else {
				System.out.println("User with id=" + id + " not found.");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int generateUniqueId() {
		int maxId = 0;
		List<User> users = getAllUsers();
		for (User user : users)
			maxId = Math.max(maxId, user.getId());
		return maxId + 1;
	}

	public User authenticate(String email, String password) {
		List<User> users = getAllUsers();
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
