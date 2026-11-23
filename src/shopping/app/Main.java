package shopping.app;

import shopping.cart.ShoppingCart;
import shopping.element.*;
import shopping.visitor.*;

public class Main {
    public static void main(String[] args) {
        ItemElement sneaker = new Sneaker("Nike Air", 2_500_000, 0.9);
        ItemElement food = new FreshFood("Cam sành", 45_000, 3.0);
        ItemElement ebook = new EBook("Design Patterns", 150_000, 12.5);
        ItemElement license = new SoftwareLicense("IntelliJ IDEA", 3_000_000, 900);

        ShoppingCart cart = new ShoppingCart();
        cart.add(sneaker);
        cart.add(food);
        cart.add(ebook);
        cart.add(license);

        ShoppingCartVisitor price = new PriceCalculatorVisitor();
        ShoppingCartVisitor shipping = new ShippingFeeVisitor();
        ShoppingCartVisitor voucher = new DiscountVoucherVisitor();
        ShoppingCartVisitor carbon = new CarbonFootprintVisitor();

        String[] names = {"Giày Sneaker", "Trái cây", "EBook", "License PM"};
        System.out.printf("%-14s %12s %10s %12s %10s%n", "Mặt hàng", "Giá", "Ship", "Voucher", "CO2(kg)");
        int i = 0;
        for (ItemElement it : cart.getItems()) {
            System.out.printf("%-14s %,12.0f %,10.0f %,12.0f %10.3f%n", names[i++],
                    it.accept(price), it.accept(shipping), it.accept(voucher), it.accept(carbon));
        }

        double total = cart.calculate(price);
        double ship = cart.calculate(shipping);
        double disc = cart.calculate(voucher);
        System.out.println("---------------------------------------------------------");
        System.out.printf("Tiền hàng      : %,12.0f VND%n", total);
        System.out.printf("Giảm voucher   : %,12.0f VND%n", -disc);
        System.out.printf("Phí vận chuyển : %,12.0f VND%n", ship);
        System.out.printf("THANH TOÁN     : %,12.0f VND%n", total - disc + ship);
        System.out.printf("Phát thải CO2  : %12.3f kg%n", cart.calculate(carbon));
    }
}
