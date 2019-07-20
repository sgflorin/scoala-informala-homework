public class Animal {
    private String product;
    private double price;
    private String date;
    private double weight;
    private double temperature;

    public Animal(String product, double price, String date, double weight, double temperature) {
        this.product = product;
        this.price = price;
        this.date = date;
        this.weight = weight;
        this.temperature = temperature;
    }

    public String getProduct() { return product; }

    public void setProduct(String product) { this.product = product; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public double getWeight() { return weight; }

    public void setWeight(double weight) { this.weight = weight; }

    public double getTemperature() { return temperature; }

    public void setTemperature(double temperature) { this.temperature = temperature; }

    @Override
    public String toString() {
        return product + " - $" + price + ". Weight: " + weight + ", storing temperature: " + temperature + "°C. Best before " + date + ".";
    }
}

