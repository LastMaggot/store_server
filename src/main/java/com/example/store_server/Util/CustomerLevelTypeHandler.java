package com.example.store_server.Util;

import com.example.store_server.Pojo.CustomerLevel;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(CustomerLevel.class)
public class CustomerLevelTypeHandler extends BaseTypeHandler<CustomerLevel> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CustomerLevel parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.ordinal());
    }

    @Override
    public CustomerLevel getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        }
        return CustomerLevel.values()[value];
    }

    @Override
    public CustomerLevel getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        }
        return CustomerLevel.values()[value];
    }

    @Override
    public CustomerLevel getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        }
        return CustomerLevel.values()[value];
    }
}
