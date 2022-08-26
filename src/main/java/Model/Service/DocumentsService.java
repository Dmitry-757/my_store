package Model.Service;

import Model.Directories.Product;
import Model.Directories.Service;
import Model.Directories.Store;
import Model.Documents.*;

public class DocumentsService {

    public static long getNewUnicID(Object o) {
        System.out.println("need to make this meth!");
        return 1;
    }

    //******** create new document head ******
    public static Object getNewDocument(TypesOfDocuments typeOfDocument, Object ...args){
        if (args.length>0){
            switch (typeOfDocument) {
                case PURCHASE -> {return createPurchase(args);}
                case SALE -> {return createSale(args);}
                case MOVE -> {return createMove(args);}
            }
        }
        return null;
    }

    private static Move createMove(Object[] args) {
        if (args.length == 3) {
            String docNumber = (String) args[0];
            Store storeOut = (Store) args[1];
            Store storeIn = (Store) args[2];
            return new Move(docNumber, storeOut, storeIn);
        }
        return null;
    }

    private static Sale createSale(Object[] args) {
        if (args.length == 2) {
            String docNumber = (String) args[0];
            Store store = (Store) args[1];
            return new Sale(docNumber, store);
        }
        return null;
    }

    private static Purchase createPurchase(Object[] args) {
        if (args.length == 2) {
            String docNumber = (String) args[0];
            Store store = (Store) args[1];
            return new Purchase(docNumber, store);
        }
        return null;
    }
    //******** create new document head ******
    //****************************************



    //******** create new document string ******
    public static Object getNewDocumentString(TypesOfDocuments typeOfDocument, Object ...args){
        if (args.length>0){
            switch (typeOfDocument) {
                case PURCHASE -> {return createPurchaseString(args);}
                case SALE -> {return createSaleString(args);}
                case MOVE -> {return createMoveString(args);}
            }
        }
        return null;
    }

    private static Object createMoveString(Object[] args) {
        if (args.length == 3) {
            Move doc = (Move) args[0];
            Product product = (Product) args[1];
            int count = (int) args[2];

            return DocStringFactory.getDocString(doc, product, count);
        }
        return null;
    }

    private static Object createSaleString(Object[] args) {
        if (args.length == 4) {
            Sale doc = (Sale) args[0];
            String className = args[1].getClass().getName();
            switch (className) {
                case "Model.Directories.Service" -> {
                    Service subj = (Service) args[1];
                    int count = (int) args[2];
                    int price = (int) args[3];
                    return DocStringFactory.getDocString(doc, subj, count, price);
                }
                case "Model.Directories.Product" -> {
                    Product subj = (Product) args[1];
                    int count = (int) args[2];
                    int price = (int) args[3];
                    return DocStringFactory.getDocString(doc, subj, count, price);
                }
            }
        }
        return null;
    }

    private static Object createPurchaseString(Object[] args) {
        if (args.length == 4) {
            Purchase doc = (Purchase) args[0];
            String className = args[1].getClass().getName();
            switch (className) {
                case "Model.Directories.Service" -> {
                    Service subj = (Service) args[1];
                    int count = (int) args[2];
                    int price = (int) args[3];
                    return DocStringFactory.getDocString(doc, subj, count, price);
                }
                case "Model.Directories.Product" -> {
                    Product subj = (Product) args[1];
                    int count = (int) args[2];
                    int price = (int) args[3];
                    return DocStringFactory.getDocString(doc, subj, count, price);
                }
            }
        }
        return null;
    }

    //******** create new document string ******
    //******************************************

}
