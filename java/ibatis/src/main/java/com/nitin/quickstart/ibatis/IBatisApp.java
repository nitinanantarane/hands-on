package com.thinkinginjava.quickstart.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.thinkinginjava.quickstart.ibatis.dao.UserInfoDao;
import com.thinkinginjava.quickstart.ibatis.dao.impl.UserInfoDaoImpl;
import com.thinkinginjava.quickstart.ibatis.entity.UserInfo;

public class IBatisApp {
    public static void main( String[] args ) throws IOException, SQLException {
    	Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
    	SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
    	
    	UserInfoDao userInfoDao = new UserInfoDaoImpl(sqlMapClient);
    	
    	UserInfo userInfo = new UserInfo(1, "nitin", "nrane@virtusa.com", "n123", 2);
    	userInfoDao.add(userInfo);
    }
}
