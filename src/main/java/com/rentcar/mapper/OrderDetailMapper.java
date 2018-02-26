package com.rentcar.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rentcar.model.OrderDetail;

public class OrderDetailMapper implements RowMapper<OrderDetail>{

	@Override
	public OrderDetail mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
