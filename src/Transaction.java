public class Transaction {
    private String type;
    private String assetCode;
    private int qty;
    private double price;

    public Transaction(String type, String assetCode, int qty, double price) {
        this.type = type;
        this.assetCode = assetCode;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public String toString() {
        return type + ": " + qty + " x " + assetCode + " à " + price + " DH";
    }
}