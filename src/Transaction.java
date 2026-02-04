import java.util.Date;

public class Transaction {
    private String type;
    private Asset asset;
    private Trader trader;
    private double qty;
    private double price;
    private Date date;

    public Transaction(String type, Asset asset, Trader trader, double qty, double price, Date date) {
        this.type = type;
        this.asset = asset;
        this.trader = trader;
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

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", asset=" + asset +
                ", trader=" + trader +
                ", qty=" + qty +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}