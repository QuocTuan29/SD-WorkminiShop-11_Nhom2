package shopping.visitor;

import shopping.element.*;

/** Thao tác 1: giá của từng mặt hàng. */
public class PriceCalculatorVisitor implements ShoppingCartVisitor {
    @Override public double visit(Sneaker s)          { return s.getPrice(); }
    @Override public double visit(FreshFood f)        { return f.getPricePerKg() * f.getWeight(); }
    @Override public double visit(EBook e)            { return e.getPrice(); }
    @Override public double visit(SoftwareLicense l)  { return l.getAnnualFee(); }
}
