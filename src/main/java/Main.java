import Model.Directories.Product;
import Model.Directories.Store;
import Model.Documents.*;

public class Main {
    public static void main(String[] args) {

        Store store = new Store("Store №1");
        Product product = new Product("article 111", "Apple",1000, 2000);


//        Purchase purchase = new Purchase("purchase №1", store);
//        PurchaseString purchaseString = new PurchaseString(purchase, product, 10, 1100);

        IDocumentHeadable purchase2 = new Purchase("purchase №2", store);
        IDocumentStringable purchaseString2 = new PurchaseString(purchase2, product, 10, 1100);

        System.out.println(purchase2.toString());

        System.out.println("\n**********************\n");

        IDocumentHeadable purchase3 = new Purchase("purchase №3", store);
        IDocumentStringable purchaseString3 = DocStringFactory.getDocString(purchase3, product, 10, 1100);

        System.out.println(purchase3.toString());



    }
}
