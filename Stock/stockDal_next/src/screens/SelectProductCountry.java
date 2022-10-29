package screens;

import javax.swing.JOptionPane;
import repos.ProductCountryRepo;

public class SelectProductCountry {

    public static void main(String[] args) {

        String seqId = JOptionPane.showInputDialog("SEQ Id");

        ProductCountryRepo pcr = new ProductCountryRepo();
        pcr.getProductCountryByPK(Integer.parseInt(seqId));

    }
}
