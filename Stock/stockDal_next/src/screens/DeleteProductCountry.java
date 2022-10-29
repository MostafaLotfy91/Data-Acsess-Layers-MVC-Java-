
package screens;
import javax.swing.JOptionPane;
import repos.ProductCountryRepo;

public class DeleteProductCountry {
    public static void main(String[] args) {
        
        String pCountryId = JOptionPane.showInputDialog("pCountryId");
        
        
        ProductCountryRepo repo = new ProductCountryRepo();
        repo.deleteProductCountry(Integer.parseInt(pCountryId));
    }
}
