public class Trader extends Person {
    private double balance;
    private Portfolio portfolio;

    public Trader(int id, String name, double balance) {
        super(id, name);
        this.balance = balance;
        this.portfolio = new Portfolio();
    }

    public double getBalance() {
        return balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | Solde: " + balance + " DH";
    }
}