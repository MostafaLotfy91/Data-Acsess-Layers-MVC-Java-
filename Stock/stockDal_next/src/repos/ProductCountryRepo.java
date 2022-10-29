package repos;
import entities.ProductCountry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import managers.DBManager;

public class ProductCountryRepo {

    public void insertProductCountry(ProductCountry pCountry) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("INSERT INTO PRODUCT_COUNTRY (SEQ_ID, PRODUCT_ID_FK, COUNTRY_NAME, PRODUCT_MODEL,PRODUCT_COUNTRY_QTY) VALUES (?, ?, ?, ?,?)");
            stmt.setInt(1, pCountry.getSeqId());
            stmt.setInt(2, pCountry.getProductIdFk());
            stmt.setString(3, pCountry.getCountryName());
            stmt.setInt(4, pCountry.getProductModel());
            stmt.setInt(5, pCountry.getProductCountryQty());

            int r = stmt.executeUpdate(); // ins  upd   delete
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public void updateProductCountry(ProductCountry pCountry) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("UPDATE PRODUCT_COUNTRY SET PRODUCT_ID_FK = ? , COUNTRY_NAME = ? ,PRODUCT_MODEL = ? ,PRODUCT_COUNTRY_QTY = ? where SEQ_ID = ?");
            stmt.setInt(5, pCountry.getSeqId());
            stmt.setInt(1, pCountry.getProductIdFk());
            stmt.setString(2, pCountry.getCountryName());
            stmt.setInt(3, pCountry.getProductModel());
            stmt.setInt(4, pCountry.getProductCountryQty());

            int r = stmt.executeUpdate(); // ins  upd   delete
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public ProductCountry getProductCountryByPK(int seqId) {
        ProductCountry pCountry = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT SEQ_ID ,PRODUCT_ID_FK, COUNTRY_NAME, PRODUCT_MODEL,PRODUCT_COUNTRY_QTY  FROM PRODUCT_COUNTRY where SEQ_ID = ?");
            stmt.setInt(1, seqId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                pCountry = new ProductCountry();
                pCountry.setSeqId(rs.getInt("SEQ_ID"));
                pCountry.setProductIdFk(rs.getInt("PRODUCT_ID_FK"));
                pCountry.setCountryName(rs.getString("COUNTRY_NAME"));
                pCountry.setProductModel(rs.getInt("PRODUCT_MODEL"));
                pCountry.setProductCountryQty(rs.getInt("PRODUCT_COUNTRY_QTY"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }

        return pCountry;
    }

    public void deleteProductCountry(int seqId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("delete from product_country where seq_id = ? ");
            stmt.setInt(1, seqId);

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
