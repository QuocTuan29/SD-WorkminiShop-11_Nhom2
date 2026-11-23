package shopping.element;

import shopping.visitor.ShoppingCartVisitor;

public class EBook implements DigitalItem {
    private final String title;
    private final double price;
    private final double downloadSizeMB;

    public EBook(String title, double price, double downloadSizeMB) {
        this.title = title;
        this.price = price;
        this.downloadSizeMB = downloadSizeMB;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    @Override public double getDownloadSizeMB() { return downloadSizeMB; }

    @Override public double accept(ShoppingCartVisitor visitor) { return visitor.visit(this); }
}
