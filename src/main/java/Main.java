import Model.Directories.Product;
import Model.Directories.Store;
import Model.Documents.Purchase;
import Model.Documents.PurchaseString;

public class Main {
    public static void main(String[] args) {

        Store store = new Store("Store №1");
        Product product = new Product("article 111", "Apple",1000, 2000);
        Purchase purchase = new Purchase("purchase №1", store);
        PurchaseString purchaseString = new PurchaseString(purchase, product, 10, 1100);

    }
}
