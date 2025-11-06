public class Fruit {

    private int id;
    private String name;
    private double pricePerKg;
    private int stockKg;

    public Fruit() {}

    public Fruit(int id, String name, double pricePerKg, int stockKg) {
        this.id = id;
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.stockKg = stockKg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public int getStockKg() {
        return stockKg;
    }

    public void setStockKg(int stockKg) {
        this.stockKg = stockKg;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerKg=" + pricePerKg +
                ", stockKg=" + stockKg +
                '}';
    }

    public String toFileFormat() {
        return id + ";" + name + ";" + pricePerKg + ";" + stockKg;
    }
}
