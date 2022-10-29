package screens;

import entities.Product;
import javax.swing.JOptionPane;
import repos.ProductRepo;

public class DeleteProduct {

    public static void main(String[] args) {
        String productId = JOptionPane.showInputDialog("Pr Id");

        
        ProductRepo repo = new ProductRepo();
        repo.deleteProduct(Integer.parseInt(productId));

    }

}
