package com.nitin.quickstart.ibatis.dao;

import java.sql.SQLException;

import com.nitin.quickstart.ibatis.entity.UserInfo;

public interface UserInfoDao {
	
	void add(UserInfo userInfo) throws SQLException;
	void update(UserInfo userInfo) throws SQLException;
	UserInfo get(int id) throws SQLException;
	void delete(int id) throws SQLException;

}
