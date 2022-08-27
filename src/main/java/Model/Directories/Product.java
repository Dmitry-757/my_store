package Model.Directories;

import Model.Service.DocumentsService;

import java.util.Objects;

public class Product {
    private final long id;
    private String article;
    private String name;
    private float lastPurchasePrice;
    private float lastSalePrice;

    public Product(String article, String productName, float lastPurchasePrice, float lastSalePrice) {
        this.article = article;
        this.name = productName;
        this.lastPurchasePrice = lastPurchasePrice;
        this.lastSalePrice = lastSalePrice;
        this.id = DocumentsService.getNewUnicID(this);
    }

    public long getProductID() {
        return id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String productName) {
        this.name = productName;
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
        return Float.compare(product.lastPurchasePrice, lastPurchasePrice) == 0 &&
                Float.compare(product.lastSalePrice, lastSalePrice) == 0 &&
                article.equals(product.article) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, article, name, lastPurchasePrice, lastSalePrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + id +
                ", article='" + article + '\'' +
                ", Name='" + name + '\'' +
                '}';
    }
}
