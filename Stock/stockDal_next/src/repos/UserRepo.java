
package repos;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import managers.DBManager;

/**
 *
 * @author Delta Store
 */
public class UserRepo {
    public void insertUser(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("INSERT INTO stock_users (user_id, user_full_name, user_name, user_password,email) VALUES (?, ?, ?, ?,?)");
            stmt.setInt(1,user.getUserId());
            stmt.setString(2, user.getUserFullName());
            stmt.setString(3,user.getUserName());
            stmt.setString(4,user.getUserPassword());
            stmt.setString(5,user.getEmail());
            int r = stmt.executeUpdate(); // ins  upd   delete
            
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public void updateUser(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("UPDATE stock_users SET user_full_name = ? , user_name = ? ,user_password = ?,email = ? where user_id = ?");
            stmt.setInt(5,user.getUserId());
            stmt.setString(1, user.getUserFullName());
            stmt.setString(2,user.getUserName());
            stmt.setString(3,user.getUserPassword());
            stmt.setString(4,user.getEmail());

            int r = stmt.executeUpdate(); // ins  upd   delete
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
    }

    // Task delete >> PK 
    public User getUserByPK(int userId) {
       User user = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT user_id , user_full_name , user_name , user_password ,EMAIL  FROM stock_users where user_id = ?");
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("USER_ID"));
                user.setUserFullName(rs.getString("User_Full_Name"));
                user.setUserName(rs.getString("User_Name"));
                user.setUserPassword(rs.getString("User_Password"));
                user.setEmail(rs.getString("Email"));
                
                
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }

        return user;
    }
    
    public void deleteUser(int userId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("delete from stock_users where user_id = ? ");
            stmt.setInt(1, userId);

            int r = stmt.executeUpdate(); // ins  upd   delete
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }

    }
    
    

    
}
