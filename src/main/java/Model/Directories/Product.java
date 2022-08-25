package Model.Directories;

import Model.Service.DocumentsService;

import java.util.Objects;

public class Product {
    private long ID;
    private String article;
    private String Name;
    private float lastPurchasePrice;
    private float lastSalePrice;

    public Product(String article, String productName, float lastPurchasePrice, float lastSalePrice) {
        this.article = article;
        this.Name = productName;
        this.lastPurchasePrice = lastPurchasePrice;
        this.lastSalePrice = lastSalePrice;
        this.ID = DocumentsService.getNewUnicID(this);
    }

    public long getProductID() {
        return ID;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getProductName() {
        return Name;
    }

    public void setProductName(String productName) {
        this.Name = productName;
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
                article.equals(product.article) && Name.equals(product.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, article, Name, lastPurchasePrice, lastSalePrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", article='" + article + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
