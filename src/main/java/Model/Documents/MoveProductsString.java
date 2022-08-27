package Model.Documents;

import Model.Directories.Product;
import Model.Service.DocumentsService;

public class MoveProductsString implements IDocumentStringable{
    private final IDocumentHeadable headReference;
    private final long id;

    private Product product;
    private float count;
    private float price;


    //constructor
    public MoveProductsString(IDocumentHeadable headReference, Product product, float count) {
        this.headReference = headReference;
        this.product = product;
        this.count = count;
        this.id = DocumentsService.getNewUnicID(this);
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

    @Override
    public String toString() {
        return "MoveString{" +
                product +
                ", count=" + count +
                '}';
    }

}
