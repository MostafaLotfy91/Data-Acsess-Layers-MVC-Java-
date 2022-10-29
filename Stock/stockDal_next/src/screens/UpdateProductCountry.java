
package screens;

import entities.ProductCountry;
import javax.swing.JOptionPane;
import repos.ProductCountryRepo;

public class UpdateProductCountry {
    public static void main(String[] args) {
        String seqId = JOptionPane.showInputDialog("SEQ Id");
        String proudectFk= JOptionPane.showInputDialog("PRODUCT_ID_FK");
        String countryName = JOptionPane.showInputDialog("COUNTRY_NAME");
        String productModel = JOptionPane.showInputDialog("PRODUCT_MODEL");
        String productQty = JOptionPane.showInputDialog("PRODUCT_COUNTRY_QTY");
        
        
            ProductCountry p = new ProductCountry();

        p.setSeqId(Integer.parseInt(seqId));
        p.setProductIdFk(Integer.parseInt(proudectFk));
        p.setCountryName(countryName);
        p.setProductModel(Integer.parseInt(productModel));
        p.setProductCountryQty(Integer.parseInt(productQty));
        
            ProductCountryRepo pcr = new ProductCountryRepo();
            pcr.updateProductCountry(p);

    }
}
    

