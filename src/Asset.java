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

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Code: " + code + " | " + label + " | " + price + " DH";
    }
}