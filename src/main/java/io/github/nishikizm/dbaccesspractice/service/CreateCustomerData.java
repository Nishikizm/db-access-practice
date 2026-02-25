package io.github.nishikizm.dbaccesspractice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import io.github.nishikizm.dbaccesspractice.config.ConnectionProvider;
import io.github.nishikizm.dbaccesspractice.domain.model.Customer;

public class CreateCustomerData {

    private static final String SQL = 
        "INSERT INTO customers(CUSTOMER_NAME, EMAIL, BALANCE)" + 
        "VALUES(?, ?, ?)";

    public void createData(Customer customer) throws SQLException {
        try(Connection con = ConnectionProvider.connectionGet();
            PreparedStatement ps = con.prepareStatement(SQL)) {
                ps.setString(1, customer.name());
                ps.setString(2, customer.email());
                ps.setBigDecimal(3, customer.balance());
                ps.executeUpdate();
        }
    }
}