
package managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBManager {
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.OracleDriver");     // Oracle
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "stock_next", "stock_next");//oracle URL
        return conn;
    }

    public static void closeStatement(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
}
