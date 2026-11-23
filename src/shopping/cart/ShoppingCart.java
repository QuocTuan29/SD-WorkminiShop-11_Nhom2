package shopping.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import shopping.element.ItemElement;
import shopping.visitor.ShoppingCartVisitor;

/** Object Structure (client của Visitor; không vẽ trong sơ đồ gốc). */
public class ShoppingCart {
    private final List<ItemElement> items = new ArrayList<>();

    public void add(ItemElement item) { items.add(item); }
    public boolean remove(ItemElement item) { return items.remove(item); }
    public List<ItemElement> getItems() { return Collections.unmodifiableList(items); }

    /** Cộng kết quả của visitor trên toàn bộ mặt hàng. */
    public double calculate(ShoppingCartVisitor visitor) {
        double sum = 0;
        for (ItemElement item : items) {
            sum += item.accept(visitor);
        }
        return sum;
    }
}
