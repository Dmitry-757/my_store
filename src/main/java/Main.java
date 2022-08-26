import Model.Directories.Product;
import Model.Directories.Service;
import Model.Directories.Store;
import Model.Documents.*;
import Model.Service.DocumentsService;

public class Main {
    public static void main(String[] args) {

        Store store = new Store("Store №1");
        Store store2 = new Store("Store №2");
        Product product = new Product("article 111", "Apple",1000, 2000);
        Service service = new Service("our service #1");


//        Purchase purchase = new Purchase("purchase №1", store);
//        PurchaseString purchaseString = new PurchaseString(purchase, product, 10, 1100);
        Purchase purchase = (Purchase) DocumentsService.getNewDocument(TypesOfDocuments.PURCHASE,"purchase №1", store);
            DocumentsService.getNewDocumentString(TypesOfDocuments.PURCHASE ,purchase, product, 10, 1100);
            DocumentsService.getNewDocumentString(TypesOfDocuments.PURCHASE ,purchase, service, 10, 1100);
        System.out.println(purchase.toString());

//        System.out.println();
//
        Sale sale = (Sale)DocumentsService.getNewDocument(TypesOfDocuments.SALE,"sale №2", store);
            DocumentsService.getNewDocumentString(TypesOfDocuments.SALE ,sale, product, 5, 1500);
            DocumentsService.getNewDocumentString(TypesOfDocuments.SALE ,sale, service, 1, 500);
        System.out.println(sale.toString());

        System.out.println();

        Move move = (Move) DocumentsService.getNewDocument(TypesOfDocuments.MOVE,"move №2", store, store2);
            DocumentsService.getNewDocumentString(TypesOfDocuments.MOVE ,move, product, 3);
        System.out.println(move.toString());





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

//        IDocumentHeadable purchase4 = new Purchase("purchase №4", store);
////        IDocumentStringable purchaseString4 = DocStringFactory.getDocString(purchase4, product, 10, 1100);
//
//        IDocumentStringable purchaseString4 = DocStringFactory.getDocString(purchase4, product, 10, 1100);
//        IDocumentStringable purchaseString5 = DocStringFactory.getDocString(purchase4, service, 2, 500);
//
//        System.out.println(purchase4.toString());


    }
}
