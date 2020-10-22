package com.csis3275.model_jle_58;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

// way to match list of students with results from jdcb driver
// part of dao one could argue

public class OrderMapper_jle_58 implements RowMapper<Order_jle_58> {

	// throws sql exception cause we talking to the database
	public Order_jle_58 mapRow(ResultSet resultSet, int i) throws SQLException	{
	
		Order_jle_58 order = new Order_jle_58();
		order.setId(resultSet.getInt("id"));
		order.setFirstname(resultSet.getString("firstname"));
		order.setLastname(resultSet.getString("lastname"));
		order.setDiscount(resultSet.getInt("discount"));
		order.setNumToppings(resultSet.getInt("numberOfToppings"));
		order.setSize(resultSet.getString("size"));
		return order;
		
	}

}
