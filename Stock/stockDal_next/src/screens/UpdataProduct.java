package screens;

import entities.Product;
import java.sql.Connection;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import repos.ProductRepo;

public class UpdataProduct {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String productId = JOptionPane.showInputDialog("Pr Id");
        String productName = JOptionPane.showInputDialog("Pr Name");
        String productPrice = JOptionPane.showInputDialog("Pr Price");
        String productQty = JOptionPane.showInputDialog("Pr Qty");

        Product p = new Product();
        p.setProductId(Integer.parseInt(productId));
        p.setProductName(productName);
        p.setProductPrice(Integer.parseInt(productPrice));
        p.setProductQty(Integer.parseInt(productQty));
        ProductRepo upProduct = new ProductRepo();
        upProduct.updateProduct(p);

    }

}
