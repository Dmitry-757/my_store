package Model.Documents;

import Model.Directories.Product;
import Model.Service.DocumentsService;

public class MoveString implements IDocumentStringable{
    private final IDocumentHeadable headReference;
    private final long documentID;

    private Product product;
    private float count;
    private float price;


    //constructor
    public MoveString(IDocumentHeadable headReference, Product product, float count, float price) {
        this.headReference = headReference;
        this.product = product;
        this.count = count;
        this.price = price;
        this.documentID = DocumentsService.getNewUnicID(this);
        headReference.addString(this);
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

}