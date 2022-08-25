package Model.Documents;

import Model.Directories.Product;
import Model.Service.DocumentsService;

public class SaleProductString implements IDocumentStringable{
    private final IDocumentHeadable headReference;
    private final long ID;

    private Product product;
    private float count;
    private float price;


    //constructor
    public SaleProductString(IDocumentHeadable headReference, Product product, float count, float price) {
        this.headReference = headReference;
        this.product = product;
        this.count = count;
        this.price = price;
        this.ID = DocumentsService.getNewUnicID(this);
        //теперь добавим эту строку к головной части (headReference - ссылка на "голову")
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SaleString{" +
                product +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

}
