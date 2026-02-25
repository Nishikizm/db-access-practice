package io.github.nishikizm.dbaccesspractice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import io.github.nishikizm.dbaccesspractice.config.ConnectionProvider;

public class DeleteCustomerData {

    private static final String SQL = 
        "DELETE FROM customers " + 
        "WHERE customer_id = ?";
    
    public void deleteData(int id) throws SQLException {
        try(Connection con = ConnectionProvider.connectionGet();
            PreparedStatement ps = con.prepareStatement(SQL)) {
                ps.setInt(1, id);
                ps.executeUpdate();
        }
    }
}
