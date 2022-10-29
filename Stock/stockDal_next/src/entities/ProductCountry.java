package entities;

public class ProductCountry {

    private int seqId;
    private int productIdFk;
    private String countryName;
    private int productModel;
    private int productCountryQty;

    public int getSeqId() {
        return seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    public int getProductIdFk() {
        return productIdFk;
    }

    public void setProductIdFk(int productIdFk) {
        this.productIdFk = productIdFk;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getProductModel() {
        return productModel;
    }

    public void setProductModel(int productModel) {
        this.productModel = productModel;
    }

    public int getProductCountryQty() {
        return productCountryQty;
    }

    public void setProductCountryQty(int productCountryQty) {
        this.productCountryQty = productCountryQty;
    }

}
