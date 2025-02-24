package com.thinkinginjava.quickstart.ibatis.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.thinkinginjava.quickstart.ibatis.dao.UserInfoDao;
import com.thinkinginjava.quickstart.ibatis.entity.UserInfo;

public class UserInfoDaoImpl implements UserInfoDao {

	private SqlMapClient sqlMapClient;
	
	public UserInfoDaoImpl(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@Override
	public void add(UserInfo userInfo) throws SQLException {
		//Integer id = (Integer) sqlMapClient.queryForObject("userInfo.getMaxId");
		sqlMapClient.insert("userInfo.insert", userInfo);
	}

	@Override
	public void update(UserInfo userInfo) throws SQLException {
		sqlMapClient.update("userInfo.update", userInfo);
	}

	@Override
	public UserInfo get(int id) throws SQLException {
		return (UserInfo) sqlMapClient.queryForObject("userInfo.get", id);
	}

	@Override
	public void delete(int id) throws SQLException {
		sqlMapClient.delete("userInfo.delete", id);
	}

}
