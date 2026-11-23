package shopping.visitor;

import shopping.element.*;

/** Thao tác 2: phí vận chuyển. Hàng vật lý tính theo khối lượng, hàng số miễn phí. */
public class ShippingFeeVisitor implements ShoppingCartVisitor {
    private static final double BASE_FEE = 15_000;
    private static final double PER_KG_NORMAL = 10_000;
    private static final double PER_KG_COLD_CHAIN = 12_000;

    /** Dùng chung cho mọi PhysicalItem nhờ interface trung gian (giảm lặp code). */
    private double physicalFee(PhysicalItem item, double perKg) {
        return BASE_FEE + perKg * item.getWeight();
    }

    @Override public double visit(Sneaker s)          { return physicalFee(s, PER_KG_NORMAL); }
    @Override public double visit(FreshFood f)        { return physicalFee(f, PER_KG_COLD_CHAIN); }
    @Override public double visit(EBook e)            { return 0; }
    @Override public double visit(SoftwareLicense l)  { return 0; }
}
