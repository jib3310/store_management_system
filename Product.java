public abstract class Product {

    private int idProduct;
    private String nameProduct;
    private String manuProduct;
    private int quantProduct;
    private double priceProduct;



    private String statusProduct = "active";

    public Product(int idProduct, String nameProduct, String manuProduct, int quantProduct, double priceProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.manuProduct = manuProduct;
        this.quantProduct = quantProduct;
        this.priceProduct = priceProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getManuProduct() {
        return manuProduct;
    }

    public void setManuProduct(String manuProduct) {
        this.manuProduct = manuProduct;
    }

    public int getQuantProduct() {
        return quantProduct;
    }

    public void setQuantProduct(int quantProduct) {
        this.quantProduct = quantProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public double getInvValue()
    {
        return quantProduct*priceProduct;
    }

    public void addQuant(int quant)
    {
        setQuantProduct(getQuantProduct()+quant);
    }
    public void deductQuant(int quant)
    {
        setQuantProduct(getQuantProduct()-quant);
    }

    @Override
    public String toString() {
        return
                "Item number          :" + idProduct +'\n'+
                "Product name         :" + nameProduct + '\n' +
                "Product manufacturer :'" + manuProduct + '\n' +
                "Quantity available   :" + quantProduct +'\n'+
                "Price (RM)           :" + String.format("%.2f",priceProduct) +'\n'+
                "Inventory value (RM) :"+ String.format("%.2f",getInvValue())+'\n'+
                "Product status       :"+ statusProduct+'\n'
                ;
    }
}