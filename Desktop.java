public class Desktop extends Product{

    private String usageC;
    private  String processor;
    private int ram;
    private int rom;
    private String romType;
    private double scrSize;
    private String formFac;

    public Desktop(int idProduct, String nameProduct, String manuProduct, int quantProduct, double priceProduct,
                   String usageD, String processor, int ram, int rom, String romType,
                   double scrSize, String formFac) {
        super(idProduct, nameProduct, manuProduct, quantProduct, priceProduct);
        this.usageC = usageD;
        this.processor = processor;
        this.ram = ram;
        this.rom = rom;
        this.romType = romType;
        this.scrSize = scrSize;
        this.formFac = formFac;
    }

    public String getUsageC() {
        return usageC;
    }

    public void setUsageD(String usageC) {
        this.usageC = usageC;
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

    public String getRomType() {
        return romType;
    }

    public void setRomType(String romType) {
        this.romType = romType;
    }

    public double getScrSize() {
        return scrSize;
    }

    public void setScrSize(double scrSize) {
        this.scrSize = scrSize;
    }

    public String getFormFac() {
        return formFac;
    }

    public void setFormFac(String formFac) {
        this.formFac = formFac;
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
        return "Desktop{\n" +
                super.toString()+
                "Usage Category       :" + usageC + '\n' +
                "Processor            : " + processor + '\n' +
                "Memory (RAM)         : " + ram +'\n' +
                "Storage Size         :" + rom +'\n' +
                "Storage Type         : " + romType + '\n' +
                "Screen Size          :" +  String.format("%.2f",scrSize) +'\n'+
                "Form Factor          :" + formFac + '\n' +
                '}';
    }
}
