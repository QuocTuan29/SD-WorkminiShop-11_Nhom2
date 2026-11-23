package shopping.element;

import shopping.visitor.ShoppingCartVisitor;

public class SoftwareLicense implements DigitalItem {
    private final String softwareName;
    private final double annualFee;
    private final double downloadSizeMB;

    public SoftwareLicense(String softwareName, double annualFee, double downloadSizeMB) {
        this.softwareName = softwareName;
        this.annualFee = annualFee;
        this.downloadSizeMB = downloadSizeMB;
    }

    public String getSoftwareName() { return softwareName; }
    public double getAnnualFee() { return annualFee; }
    @Override public double getDownloadSizeMB() { return downloadSizeMB; }

    @Override public double accept(ShoppingCartVisitor visitor) { return visitor.visit(this); }
}
