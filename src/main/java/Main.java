import Model.Directories.Product;
import Model.Directories.Services;
import Model.Directories.Store;
import Model.Documents.*;

public class Main {
    public static void main(String[] args) {

        Store store = new Store("Store №1");
        Product product = new Product("article 111", "Apple",1000, 2000);
        Services service = new Services("our service #1");


//        Purchase purchase = new Purchase("purchase №1", store);
//        PurchaseString purchaseString = new PurchaseString(purchase, product, 10, 1100);

//        IDocumentHeadable purchase2 = new Purchase("purchase №2", store);
//        IDocumentStringable purchaseString2 = new PurchaseString(purchase2, product, 10, 1100);
//
//        System.out.println(purchase2.toString());
//
//        System.out.println("\n**********************\n");
//
//        IDocumentHeadable purchase3 = new Purchase("purchase №3", store);
//        IDocumentStringable purchaseString3 = new PurchaseStringServices(purchase3, service, 2, 500);
//
//        System.out.println(purchase3.toString());
//
//        IDocumentStringable purchaseString31 = new PurchaseString(purchase3, product, 10, 1100);
//        System.out.println("\n**********************\n");
//
//        System.out.println(purchase3.toString());
//
//
//        System.out.println("\n**********************\n");

        IDocumentHeadable purchase4 = new Purchase("purchase №4", store);
//        IDocumentStringable purchaseString4 = DocStringFactory.getDocString(purchase4, product, 10, 1100);

        IDocumentStringable purchaseString4 = DocStringFactory.getDocString(purchase4, product, 10, 1100);
        IDocumentStringable purchaseString5 = DocStringFactory.getDocString(purchase4, service, 2, 500);

        System.out.println(purchase4.toString());


    }
}
