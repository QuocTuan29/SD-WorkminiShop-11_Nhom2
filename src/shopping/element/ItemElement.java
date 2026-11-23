package shopping.element;

import shopping.visitor.ShoppingCartVisitor;

/** Element gốc của Visitor Pattern. */
public interface ItemElement {
    double accept(ShoppingCartVisitor visitor);
}
