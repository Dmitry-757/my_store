package Model.Documents;

import Model.Directories.Services;
import Model.Service.DocumentsService;




public class PurchaseStringServices implements IDocumentStringable {
    private final IDocumentHeadable headReference;
    private final long documentID;

    private Services service;
    private float count;
    private float price;

    //constructor
    public PurchaseStringServices(IDocumentHeadable headReference, Services service, float count, float price) {
        this.headReference = headReference;
        this.service = service;
        this.count = count;
        this.price = price;
        this.documentID = DocumentsService.getNewUnicID(this);
        //теперь добавим эту строку к головной части (headReference - ссылка на "голову")
        headReference.addString(this);
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
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
        return "PurchaseString{" +
                "product=" + service +
                ", count=" + count +
                ", price=" + price +
                '}';
    }


}
