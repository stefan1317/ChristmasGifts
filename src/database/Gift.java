package database;

public class Gift {
    private String productName;
    private double price;
    private String category;
    private int quantity;

    public Gift(final String productName, final double price, final String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public Gift(final Gift gift) {
        this.productName = gift.productName;
        this.price = gift.price;
        this.category = gift.category;
    }

    public Gift() { }

    /**
     * Getter pentru productName.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Getter pentru price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter pentru category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Getter pentru quality.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter pentru productName.
     */
    public void setProductName(final String productName) {
        this.productName = productName;
    }

    /**
     * Setter pentru price.
     */
    public void setPrice(final double price) {
        this.price = price;
    }

    /**
     * Setter pentru category.
     */
    public void setCategory(final String category) {
        this.category = category;
    }

    /**
     * Setter pentru quality.
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    /**
     * Override metodei toString.
     */
    @Override
    public String toString() {
        return "Gift{"
                + "productName='" + productName + '\''
                + ", price=" + price
                + ", category='" + category + '\''
                + ", quantity=" + quantity
                + '}';
    }
}
