package shopping.element;

import shopping.visitor.ShoppingCartVisitor;

public class FreshFood implements PhysicalItem {
    private final String name;
    private final double pricePerKg;
    private final double weight;

    public FreshFood(String name, double pricePerKg, double weight) {
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getPricePerKg() { return pricePerKg; }
    @Override public double getWeight() { return weight; }

    @Override public double accept(ShoppingCartVisitor visitor) { return visitor.visit(this); }
}
