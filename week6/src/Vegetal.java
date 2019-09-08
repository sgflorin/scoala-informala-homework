public class Vegetal {
    private String product;
    private double price;
    private String date;
    private double weight;
    private String vitamin;

    public Vegetal(String product, double price, String date, double weight, String vitamin) {
        this.product = product;
        this.price = price;
        this.date = date;
        this.weight = weight;
        this.vitamin = vitamin;
    }

    public String getProduct() { return product; }

    public void setProduct(String product) { this.product = product; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public double getWeight() { return weight; }

    public void setWeight(double weight) { this.weight = weight; }

    public String getVitamin() { return vitamin; }

    public void setVitamin(String vitamin) { this.vitamin = vitamin; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return product + " - $" + price + ". Weight: " + weight + " kilograms, vitamins: " + vitamin + ". Best before " + date + ".";
    }
}
