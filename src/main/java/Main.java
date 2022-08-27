import DAO.ProductDAO;
import Model.Directories.Product;

public class Main {
    public static void main(String[] args) {

//        Store store = new Store("Store №1");
//        Store store2 = new Store("Store №2");
        Product product = new Product("article 222", "Apple",1000, 2000);
        System.out.println(product);

        product.setName("Apple 2");
        ProductDAO.update(product);
        System.out.println(product);

        /*
        Service service = new Service("our service #1");


//        Purchase purchase = new Purchase("purchase №1", store);
//        PurchaseString purchaseString = new PurchaseString(purchase, product, 10, 1100);
        Purchase purchase = (Purchase) DocumentsService.getNewDocument(TypesOfDocuments.PURCHASE,"purchase №1", store);
            DocumentsService.getNewDocumentString(TypesOfDocuments.PURCHASE ,purchase, product, 10, 1100);
            DocumentsService.getNewDocumentString(TypesOfDocuments.PURCHASE ,purchase, service, 10, 1100);
        System.out.println(purchase.toString());

        System.out.println();

        Sale sale = (Sale)DocumentsService.getNewDocument(TypesOfDocuments.SALE,"sale №2", store);
            DocumentsService.getNewDocumentString(TypesOfDocuments.SALE ,sale, product, 5, 1500);
            DocumentsService.getNewDocumentString(TypesOfDocuments.SALE ,sale, service, 1, 500);
        System.out.println(sale.toString());

        System.out.println();

        Move move = (Move) DocumentsService.getNewDocument(TypesOfDocuments.MOVE,"move №2", store, store2);
            DocumentsService.getNewDocumentString(TypesOfDocuments.MOVE ,move, product, 3);
        System.out.println(move.toString());
*/




    }
}
