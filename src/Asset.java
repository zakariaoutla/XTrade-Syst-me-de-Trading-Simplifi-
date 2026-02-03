public abstract class Asset {
    protected String code;
    protected String label;
    protected double price;

    public Asset(String code, String label, double price) {
        this.code = code;
        this.label = label;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Code: " + code + " | " + label + " | " + price + " DH";
    }
}