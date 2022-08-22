package Model.Directories;

import java.util.Objects;

public class Product {
    private long productID;
    private String article;
    private String productName;
    private float lastPurchasePrice;
    private float lastSalePrice;

    public Product(String article, String productName, float lastPurchasePrice, float lastSalePrice) {
        this.article = article;
        this.productName = productName;
        this.lastPurchasePrice = lastPurchasePrice;
        this.lastSalePrice = lastSalePrice;
    }

    public long getProductID() {
        return productID;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getLastPurchasePrice() {
        return lastPurchasePrice;
    }

    public void setLastPurchasePrice(float lastPurchasePrice) {
        this.lastPurchasePrice = lastPurchasePrice;
    }

    public float getLastSalePrice() {
        return lastSalePrice;
    }

    public void setLastSalePrice(float lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Float.compare(product.lastPurchasePrice, lastPurchasePrice) == 0 && Float.compare(product.lastSalePrice, lastSalePrice) == 0 && article.equals(product.article) && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, article, productName, lastPurchasePrice, lastSalePrice);
    }
}
