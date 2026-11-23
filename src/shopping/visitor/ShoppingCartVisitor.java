package shopping.visitor;

import shopping.element.*;

/** Visitor: một phương thức visit cho mỗi loại mặt hàng cụ thể. */
public interface ShoppingCartVisitor {
    double visit(Sneaker sneaker);
    double visit(FreshFood food);
    double visit(EBook ebook);
    double visit(SoftwareLicense license);
}
