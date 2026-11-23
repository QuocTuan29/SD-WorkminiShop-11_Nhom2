package shopping.element;

import shopping.visitor.ShoppingCartVisitor;

public class Sneaker implements PhysicalItem {
    private final String brand;
    private final double price;
    private final double weight;

    public Sneaker(String brand, double price, double weight) {
        this.brand = brand;
        this.price = price;
        this.weight = weight;
    }

    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    @Override public double getWeight() { return weight; }

    @Override public double accept(ShoppingCartVisitor visitor) { return visitor.visit(this); }
}
