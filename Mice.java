public class Mice extends Product{

    private String conType;
    private String size;
    private String scrollType;

    public Mice(int idProduct, String nameProduct,
                String manuProduct, int quantProduct, double priceProduct, String conType,
                String size, String scrollType) {
        super(idProduct, nameProduct, manuProduct, quantProduct, priceProduct);
        this.conType = conType;
        this.size = size;
        this.scrollType = scrollType;
    }

    public String getConType() {
        return conType;
    }

    public void setConType(String conType) {
        this.conType = conType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getScrollType() {
        return scrollType;
    }

    public void setScrollType(String scrollType) {
        this.scrollType = scrollType;
    }

    public double getPrice ()
    {
        return getPriceProduct();
    }

    public double getInvValue()
    {
    	return super.getQuantProduct()*getPrice();
    }
    @Override
    public String toString() {
        return "Mice{\n" +
                super.toString()+
                "Connectivity        :" + conType + '\n' +
                "Mouse size          :" + size + '\n' +
                "Scroll Type         :" + scrollType + '\n' +
                '}';
    }
}
