package io.github.nishikizm.dbaccesspractice.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.github.nishikizm.dbaccesspractice.config.ConnectionProvider;

public class UpdateCustomerData {
    
    private static final String SQL = 
        "UPDATE customers " + 
        "SET balance=(balance + ?) " + 
        "WHERE customer_id = ?";
    
    public void updateData(int id, BigDecimal num) throws SQLException {
        try(Connection con = ConnectionProvider.connectionGet();
            PreparedStatement ps = con.prepareStatement(SQL)) {
                ps.setBigDecimal(1, num);
                ps.setInt(2, id);
                ps.executeUpdate();
        }
    }
}
