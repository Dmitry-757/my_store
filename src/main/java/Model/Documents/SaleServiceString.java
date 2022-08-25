package Model.Documents;

import Model.Directories.Service;
import Model.Service.DocumentsService;

public class SaleServiceString implements IDocumentStringable{
    private final IDocumentHeadable headReference;
    private final long ID;

    private Service service;
    private float count;
    private float price;


    //constructor
    public SaleServiceString(IDocumentHeadable headReference, Service service, float count, float price) {
        this.headReference = headReference;
        this.service = service;
        this.count = count;
        this.price = price;
        this.ID = DocumentsService.getNewUnicID(this);
        //теперь добавим эту строку к головной части (headReference - ссылка на "голову")
        headReference.addString(this);
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
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
        return "SAleString{" +
                service +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

}
