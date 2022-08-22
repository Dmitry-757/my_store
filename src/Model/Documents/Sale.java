package Model.Documents;

import Model.Directories.Store;

import java.util.HashMap;

public class Sale {
    private final long documentID;
    private String docNumber;
    private Store store;

    //ссылка на строки документа
    private HashMap<Purchase, SaleString> documentString = new HashMap<>();

    //constructor
    public Sale(String docNumber, Store store) {
        this.docNumber = docNumber;
        this.store = store;
        this.documentID = getNewUnicalID();
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public HashMap<Purchase, SaleString> getDocumentString() {
        return documentString;
    }

}
