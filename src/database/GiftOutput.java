package database;

public class GiftOutput {
    private String productName;
    private double price;
    private String category;

    public GiftOutput(final String productName, final double price, final String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
    public GiftOutput() { }

    /**
     * Getter pentru productName.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Setter pentru productName.
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * Getter pentru price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter pentru price.
     */
    public void setPrice(final double price) {
        this.price = price;
    }

    /**
     * Getter pentru category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * setter pentru category.
     */
    public void setCategory(final String category) {
        this.category = category;
    }

    /**
     * Override metodei toString.
     */
    @Override
    public String toString() {
        return "GiftOutput{"
                + "productName='" + productName + '\''
                + ", price=" + price
                + ", category='" + category + '\''
                + '}';
    }

    /**
     * Metoda ce converteste un gift de tip Gift la unul de tip GiftOutput.
     */
    public void convert(final Gift gift) {
        this.category = gift.getCategory();
        this.productName = gift.getProductName();
        this.price = gift.getPrice();
    }
}

