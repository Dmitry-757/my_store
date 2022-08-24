package Model.Documents;

import Model.Directories.Product;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DocStringFactory {
    private static IDocumentStringable docString;
    private static String docStringClass;

    static {
        Properties properties = new Properties();
        try ( InputStream is = DocStringFactory.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(is);
            docStringClass = properties.getProperty("docStringClass");

            //use reflection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static IDocumentStringable getDocString(IDocumentHeadable headReference, Product product, float count, float price) {

        try {
            docString = (IDocumentStringable)Class.forName(docStringClass).
                    getConstructor(IDocumentHeadable.class, Product.class, float.class, float.class).newInstance(headReference, product, count, price);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return docString;
    }
}
