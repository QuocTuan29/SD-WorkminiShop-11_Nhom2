package shopping.visitor;

import shopping.element.*;

/**
 * Thao tác BỔ SUNG 2 («New»): ước tính lượng phát thải CO2 (kg).
 * Hệ số dưới đây chỉ mang tính minh họa cho bài tập.
 */
public class CarbonFootprintVisitor implements ShoppingCartVisitor {
    private static final double CO2_PER_KG_PHYSICAL = 0.5;   // vận chuyển
    private static final double CO2_MANUFACTURE_SNEAKER = 14.0;
    private static final double CO2_PER_KG_FOOD_PRODUCTION = 2.5;
    private static final double CO2_PER_MB_DOWNLOAD = 0.0003; // truyền tải dữ liệu

    private double transport(PhysicalItem p) { return p.getWeight() * CO2_PER_KG_PHYSICAL; }
    private double download(DigitalItem d)   { return d.getDownloadSizeMB() * CO2_PER_MB_DOWNLOAD; }

    @Override public double visit(Sneaker s)          { return CO2_MANUFACTURE_SNEAKER + transport(s); }
    @Override public double visit(FreshFood f)        { return f.getWeight() * CO2_PER_KG_FOOD_PRODUCTION + transport(f); }
    @Override public double visit(EBook e)            { return download(e); }
    @Override public double visit(SoftwareLicense l)  { return download(l); }
}
