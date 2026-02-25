package io.github.nishikizm.dbaccesspractice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import io.github.nishikizm.dbaccesspractice.config.ConnectionProvider;
import io.github.nishikizm.dbaccesspractice.domain.model.Customer;

public class ReadCustomerData {
    
    private static final String SQL = 
        "SELECT customer_name, email, balance " + 
        "FROM customers " + 
        "WHERE customer_id = ?";

    public Customer readData(int id) throws SQLException {
        try(Connection con = ConnectionProvider.connectionGet();
            PreparedStatement ps = con.prepareStatement(SQL)) {
                ps.setInt(1, id);
                try(ResultSet rs = ps.executeQuery()) {
                    while(rs.next()) {
                        return new Customer(rs.getString("customer_name"), 
                                            rs.getString("email"), 
                                            rs.getBigDecimal("balance"));
                    }
                    return null;
                }
        }
    }
}
