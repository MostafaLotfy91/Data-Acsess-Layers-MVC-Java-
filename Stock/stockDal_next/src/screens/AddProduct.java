    
package screens;

import entities.Product;
import javax.swing.JOptionPane;
import repos.ProductRepo;

/**
 *
 * @author Delta Store
 */
public class AddProduct {
    public static void main(String[] args) {

        String productId = JOptionPane.showInputDialog("Pr Id");
        String productName = JOptionPane.showInputDialog("Pr Name");
        String productPrice = JOptionPane.showInputDialog("Pr Price");
        String productQty = JOptionPane.showInputDialog("Pr Qty");

        Product p = new Product();
        p.setProductId(Integer.parseInt(productId));
        p.setProductName(productName);
        p.setProductPrice(Integer.parseInt(productPrice));
        p.setProductQty(Integer.parseInt(productQty));

        ProductRepo repo = new ProductRepo();
        repo.insertProduct(p);

    }
    
}
