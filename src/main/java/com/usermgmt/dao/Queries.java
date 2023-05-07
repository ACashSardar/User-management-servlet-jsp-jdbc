package com.usermgmt.dao;

public class Queries {
	 static String CREATE_TABLE = "create table user (id int(10), name varchar(100), email varchar(100), password varchar(100), role varchar(100), primary key (id))";
	 static String INSERT_USER = "insert into user(id, name, email, password, role) values(? , ? , ?, ?, ?)";
	 static String UPDATE_USER = "update user set name=?, email=?, password=?, role=? where id=?";
	 static String SELECT_USERS = "select * from user";
	 static String SELECT_USER_BY_ID = "select * from user where id=?";
	 static String DELETE_USER = "delete from user where id=?";
}
