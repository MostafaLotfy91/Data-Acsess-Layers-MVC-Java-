package screens;

import entities.Product;
import javax.swing.JOptionPane;
import repos.ProductRepo;


public class SelectProduct {
     public static void main(String[] args) {

        String productId = JOptionPane.showInputDialog("Pr Id");

        ProductRepo repo = new ProductRepo();
        Product p = repo.getProductByPK(Integer.parseInt(productId));

        System.out.println(p.getProductName());
    }
    
}
