package com.shop.db.sqlconfig;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IBatisDBConnector {
	
	private static SqlMapClient client;
	
	public static SqlMapClient getSqlMapClient(){
		return client;
	}
	
	static {
		try{
			String resource = "com/shop/db/sqlconfig/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			client = SqlMapClientBuilder.buildSqlMapClient(reader);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
