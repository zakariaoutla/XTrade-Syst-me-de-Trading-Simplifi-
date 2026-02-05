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




    public double withdraw(double amount) {

        this.balance -= amount;
        return balance;
    }

    public double deposit(double amount) {
        this.balance += amount;
        return balance;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "balance=" + balance +
                ", portfolio=" + portfolio +
                '}';
    }
}