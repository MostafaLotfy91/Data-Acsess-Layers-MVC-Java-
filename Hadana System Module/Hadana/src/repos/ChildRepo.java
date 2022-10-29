package repos;

import entities.Child;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import managers.DBManager;

public class ChildRepo {
    
    public void regester(Child child) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("INSERT INTO CHILD (CHILD_ID,CHILD_NAME,DATE_OF_BIRTH,EXPERIANCE,SOLOK,TQDM) VALUES (?, ?, ?, ?,?,?)");
            stmt.setInt(1, child.getChildId());
            stmt.setString(2, child.getChildName());
            stmt.setInt(3, child.getDateOfBirth());
            stmt.setInt(4, child.getExperiance());
            stmt.setString(5, child.getSolok());
            stmt.setString(6, child.getTqdm());
            int r = stmt.executeUpdate(); // ins  upd   delete

            System.out.println(r);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
    }
    
    public void updateChild(Child child) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            
            stmt = conn.prepareStatement("UPDATE CHILD SET CHILD_NAME = ? , DATE_OF_BIRTH = ? ,EXPERIANCE = ?,SOLOK = ?,TQDM=?  where CHILD_ID = ?");
            
            stmt.setString(1, child.getChildName());
            stmt.setInt(2, child.getDateOfBirth());
            stmt.setInt(3, child.getExperiance());
            stmt.setString(4, child.getSolok());
            stmt.setString(5, child.getTqdm());
            stmt.setInt(1, child.getChildId());
            
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
    public Child childProfile(int childId) {
        Child child = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT CHILD_ID , CHILD_NAME , DATE_OF_BIRTH , EXPERIANCE ,SOLOK,TQDM  FROM CHILD where CHILD_ID = ?");
            stmt.setInt(1, childId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                child = new Child();
                child.setChildId(rs.getInt("CHILD_ID"));
                child.setChildName(rs.getNString("CHILD_NAME"));
                child.setDateOfBirth(rs.getInt("DATE_OF_BIRTH"));
                child.setExperiance(rs.getInt("EXPERIANCE"));
                child.setSolok(rs.getNString("SOLOK"));
                child.setTqdm(rs.getNString("TQDM"));
                
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
        
        return child;
    }
    
    public void deleteChild(int childId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            
            stmt = conn.prepareStatement("delete from CHILD where CHILD_ID = ? ");
            stmt.setInt(1, childId);
            
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
    public Child login(String userName, String password) {
        Child child = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT  CHILD_ID , CHILD_NAME , DATE_OF_BIRTH , EXPERIANCE ,SOLOK,TQDM  FROM CHILD where USER_NAME = ? and PASWORD = ?");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                child = new Child();
                child.setChildId(rs.getInt("CHILD_ID"));
                child.setChildName(rs.getString("CHILD_NAME"));
                child.setDateOfBirth(rs.getInt("DATE_OF_BIRTH"));
                child.setExperiance(rs.getInt("EXPERIANCE"));
                child.setSolok(rs.getNString("SOLOK"));
                child.setTqdm(rs.getNString("TQDM"));
                
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
        
        return child;
    }
    
}
