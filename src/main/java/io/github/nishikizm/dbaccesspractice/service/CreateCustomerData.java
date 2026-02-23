package io.github.nishikizm.dbaccesspractice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import io.github.nishikizm.dbaccesspractice.config.ConnectionProvider;
import io.github.nishikizm.dbaccesspractice.model.Customer;

public class CreateCustomerData {

    private static final String sql = 
        "INSERT INTO customers(CUSTOMER_NAME, EMAIL, BALANCE)" + 
        "VALUES(?, ?, ?)";

    public int CreateData(Customer customer) throws SQLException {

        try(Connection con = ConnectionProvider.connectionGet();
            PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, customer.name());
                ps.setString(2, customer.email());
                ps.setBigDecimal(3, customer.balance());
                return ps.executeUpdate();
        }
    }
}