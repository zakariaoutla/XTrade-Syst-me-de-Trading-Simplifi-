import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private String type;
    private String assetCode;
    private double qty;
    private double price;
    private Date date;

    public Transaction(String type, String assetCode, double qty, double price, Date date) {
        this.type = type;
        this.assetCode = assetCode;
        this.qty = qty;
        this.price = price;
        this.date = date;
    }

    @Override
    public String toString() {
        return type + ": " + qty + " x " + assetCode + " à " + price + " DH";
    }
}