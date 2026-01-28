public class Trader extends Person {

    private int id;
    private double sold;

    public Trader(String name ,int id, double sold) {
        super(name);
        this.id = id;
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "id=" + id +
                ", sold=" + sold +
                '}';
    }
}
