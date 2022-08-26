package Model.Documents;

import Model.Directories.Product;
import Model.Directories.Service;

import java.lang.reflect.InvocationTargetException;


public class DocStringFactory {
    private static IDocumentStringable docString;
    private static String docStringClass;



    public static IDocumentStringable getDocString(IDocumentHeadable headReference, Product product, float count, float price) {
        docStringClass = "Model.Documents.PurchaseProductsString";
        try {
            docString = (IDocumentStringable)Class.forName(docStringClass).
                    getConstructor(IDocumentHeadable.class, Product.class, float.class, float.class).
                    newInstance(headReference, product, count, price);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return docString;
    }

    //***************************************************************
    //*** let`s play to polymorphism ;) ***

    //if its need to use Service in string
    public static IDocumentStringable getDocString(IDocumentHeadable headReference, Service service, float count, float price) {
        docStringClass = "Model.Documents.PurchaseServicesString";
        try {
            docString = (IDocumentStringable)Class.forName(docStringClass).
                    getConstructor(IDocumentHeadable.class, Service.class, float.class, float.class).
                    newInstance(headReference, service, count, price);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return docString;
    }

    //if its need to use Product in string
    public static IDocumentStringable getDocString(IDocumentHeadable headReference, Product product, float count) {
        docStringClass = "Model.Documents.MoveProductsString";
        try {
            docString = (IDocumentStringable)Class.forName(docStringClass).
                    getConstructor(IDocumentHeadable.class, Product.class, float.class).
                    newInstance(headReference, product, count);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return docString;
    }

}
