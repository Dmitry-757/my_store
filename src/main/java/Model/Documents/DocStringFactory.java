package Model.Documents;

import Model.Directories.Product;
import Model.Directories.Services;

//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
import java.lang.reflect.InvocationTargetException;


public class DocStringFactory {
    private static IDocumentStringable docString;
    private static String docStringClass;


//    static {
//        Properties properties = new Properties();
//        try ( InputStream is = DocStringFactory.class.getClassLoader().getResourceAsStream("app.properties")) {
//            properties.load(is);
//            docStringClass = properties.getProperty("docStringClass");
//
//            //use reflection
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static IDocumentStringable getDocString(IDocumentHeadable headReference, Product product, float count, float price) {

        docStringClass = "Model.Documents.PurchaseStringProducts";
        try {
//            docString = (IDocumentStringable)Class.forName(docStringClass).
            docString = (IDocumentStringable)Class.forName(docStringClass).
                    getConstructor(IDocumentHeadable.class, Product.class, float.class, float.class).
                    newInstance(headReference, product, count, price);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return docString;
    }
    public static IDocumentStringable getDocString(IDocumentHeadable headReference, Services service, float count, float price) {
        docStringClass = "Model.Documents.PurchaseStringServices";
        try {
//            docString = (IDocumentStringable)Class.forName(docStringClass).
            docString = (IDocumentStringable)Class.forName(docStringClass).
                    getConstructor(IDocumentHeadable.class, Services.class, float.class, float.class).
                    newInstance(headReference, service, count, price);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return docString;
    }

}