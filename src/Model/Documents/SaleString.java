package Model.Documents;

import Model.Directories.Product;

public class SaleString {
    private final Sale headReference;
    private final long documentID;

    private Product product;
    private float count;
    private float price;


    //constructor
    public SaleString(Sale headReference, Product product, float count, float price) {
        this.headReference = headReference;
        this.product = product;
        this.count = count;
        this.price = price;
        this.documentID = getNewUnicalID();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
