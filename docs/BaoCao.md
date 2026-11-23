# Case study: Shopping Cart (hàng vật lý và hàng số) với Visitor Pattern

## 1. Phân tích sơ đồ
- `ItemElement`: Element gốc, khai báo `accept(visitor): double`.
- `PhysicalItem` (getWeight) và `DigitalItem` (getDownloadSizeMB): interface trung gian, gom hàng thành 2 nhóm.
- `Sneaker`, `FreshFood` (vật lý); `EBook`, `SoftwareLicense` (số): ConcreteElement.
- `ShoppingCartVisitor`: 4 hàm visit, mỗi loại hàng cụ thể một hàm.
- `PriceCalculatorVisitor`, `ShippingFeeVisitor`: 2 thao tác gốc. `DiscountVoucherVisitor`, `CarbonFootprintVisitor` («New»): 2 thao tác bổ sung.
- Mũi tên "uses": Element phụ thuộc Visitor.

## 2. Ý nghĩa của PhysicalItem / DigitalItem
Giúp visitor xử lý chung theo nhóm qua getter của interface (ví dụ `physicalFee(PhysicalItem)` trong ShippingFeeVisitor, `download(DigitalItem)` trong CarbonFootprintVisitor), giảm code lặp. Tuy nhiên Visitor vẫn phải cài visit cho từng lớp cụ thể vì overload chọn theo kiểu cụ thể, không theo interface trung gian.

## 3. Mở rộng
- Thêm thao tác: dễ, chỉ thêm 1 lớp visitor (như 2 lớp «New»).
- Thêm loại hàng (ví dụ Voucher, Subscription): phải thêm visit vào ShoppingCartVisitor và sửa cả 4 visitor.
- Thêm loại hàng thuộc nhóm có sẵn vẫn phải sửa visitor, vì Visitor không dispatch theo nhóm.

## 4. Khó khăn khi áp dụng Visitor
1. Thêm loại hàng làm vỡ mọi visitor.
2. Phải mở getter (phá đóng gói).
3. `visit` trả về double nên bị ràng buộc kiểu kết quả (không in hóa đơn dạng chuỗi được; cần Visitor<R>).
4. Hai nhóm hàng có thuộc tính khác nhau nên nhiều visit trả 0 / không áp dụng (ví dụ ship của hàng số).
5. Quy tắc theo cả giỏ (miễn ship khi đơn lớn, voucher theo tổng đơn) không thuộc từng mặt hàng.
6. Double dispatch khó hiểu; model và visitor phụ thuộc vòng.
