package shopping.visitor;

import shopping.element.*;

/** Thao tác BỔ SUNG 1 («New»): số tiền giảm nhờ voucher theo từng loại hàng. */
public class DiscountVoucherVisitor implements ShoppingCartVisitor {
    private final ShoppingCartVisitor price = new PriceCalculatorVisitor();

    @Override public double visit(Sneaker s)          { return s.accept(price) * 0.15; }
    @Override public double visit(FreshFood f)        { return f.accept(price) * 0.05; }
    @Override public double visit(EBook e)            { return e.accept(price) * 0.20; }
    @Override public double visit(SoftwareLicense l)  { return l.accept(price) * 0.10; }
}
