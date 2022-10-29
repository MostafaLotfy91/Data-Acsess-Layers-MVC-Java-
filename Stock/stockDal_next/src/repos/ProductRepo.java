
package repos;


import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import managers.DBManager;

public class ProductRepo {

    public void insertProduct(Product product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QTY) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductName());
            stmt.setInt(3, product.getProductPrice());
            stmt.setInt(4, product.getProductQty());

            int r = stmt.executeUpdate(); // ins  upd   delete
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public void updateProduct(Product product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();


            stmt = conn.prepareStatement("UPDATE PRODUCT SET PRODUCT_NAME = ? , PRODUCT_PRICE = ? ,PRODUCT_QTY = ? where product_ID = ?");
            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getProductPrice());
            stmt.setInt(3, product.getProductQty());
            stmt.setInt(4, product.getProductId());

            int r = stmt.executeUpdate(); // ins  upd   delete
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
    }


    public Product getProductByPK(int productId) {
        Product product = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT PRODUCT_ID,PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QTY FROM PRODUCT where Product_id = ?");
            stmt.setInt(1, productId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("PRODUCT_ID"));
                product.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                product.setProductQty(rs.getInt("PRODUCT_QTY"));
                product.setProductName(rs.getString("PRODUCT_NAME"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }

        return product;
    }
    
    public void deleteProduct(int productId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("delete from product where product_id = ? ");
            stmt.setInt(1, productId);

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

