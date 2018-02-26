package com.rentcar.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rentcar.model.Order;

public class OrderMapper implements RowMapper<Order> {

	public static final String BASE_SQL = "SELECT * FROM order";
	
	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		return null;
	}

}
