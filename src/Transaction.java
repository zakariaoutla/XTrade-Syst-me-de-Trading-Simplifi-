import java.util.Date;

public class Transaction {
    private String typeOperation;
    private double quantite;
    private double prix;
    private Date date;
    private Trader trader;
    private Asset asset;


    public Transaction(String typeOperation, double quantite, double prix, Date date, Trader trader, Asset asset) {
        this.typeOperation = typeOperation;
        this.quantite = quantite;
        this.prix = prix;
        this.date = date;
        this.trader = trader;
        this.asset = asset;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
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
                "typeOperation='" + typeOperation + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                ", date=" + date +
                ", trader=" + trader +
                ", asset=" + asset +
                '}';
    }
}
