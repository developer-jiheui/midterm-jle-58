package com.csis3275.dao_jle_58;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.model_jle_58.OrderMapper_jle_58;
import com.csis3275.model_jle_58.Order_jle_58;

@Component
public class OrderDAOImpl_jle_58 {

	JdbcTemplate jdbcTemplate;
	
	// SQL queries ///////////////////////
	private final String SQL_GET_ALL = "SELECT * FROM order_jle_58";
	private final String SQL_CREATE_ORDER = "INSERT INTO order_jle_58 (size, firstname, lastname, discount, numberOfToppings) VALUES (?, ?, ?, ?,?)";

	@Autowired
	public OrderDAOImpl_jle_58(DataSource dataSource)	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// DAO methods /////////////////////// 
	
	public List<Order_jle_58> getAllOrders()	{
		return jdbcTemplate.query(SQL_GET_ALL, new OrderMapper_jle_58());
		
	}
	
	
	
}
