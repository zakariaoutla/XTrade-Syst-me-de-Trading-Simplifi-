import java.util.Date;

public class Transaction {
    private String type;
    private Asset asset;
    private double qty;
    private double price;
    private Date date;

    public Transaction(String type, Asset asset, double qty, double price, Date date) {
        this.type = type;
        this.asset = asset;
        this.qty = qty;
        this.price = price;
        this.date = date;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", asset=" + asset +
                ", qty=" + qty +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}