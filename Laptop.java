public class Laptop extends Product{
    private String colorL;
    private double scrSize;
    private String processor;
    private int ram;
    private int rom;


    public Laptop(int idProduct, String nameProduct, String manuProduct, int quantProduct,
                  double priceProduct, String colorL, double scrSize, String processor, int ram, int rom) {
        super(idProduct, nameProduct, manuProduct, quantProduct, priceProduct);
        this.colorL = colorL;
        this.scrSize = scrSize;
        this.processor = processor;
        this.ram = ram;
        this.rom = rom;
    }

    public String getColorL() {
        return colorL;
    }

    public void setColorL(String colorL) {
        this.colorL = colorL;
    }

    public double getScrSize() {
        return scrSize;
    }

    public void setScrSize(float scrSize) {
        this.scrSize = scrSize;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public double getPrice ()
    {
        return getPriceProduct()*1.1;
    }

    public double getInvValue()
    {
    	return super.getQuantProduct()*getPrice();
    }
    @Override
    public String toString() {
        return "Laptop{\n" +
                super.toString()+
                "Color                :" + colorL + '\n' +
                "Screen Size          : " + String.format("%.2f",scrSize) +'\n' +
                "Processor            : " + processor + '\n' +
                "Memory (RAM)         :" + ram +'\n' +
                "Storage Size         :" + rom +'\n' +
                '}';
    }
}
