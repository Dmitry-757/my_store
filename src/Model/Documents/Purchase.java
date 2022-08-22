package Model.Documents;

import Model.Directories.Store;

import java.util.HashMap;

public class Purchase {
    private final long documentID;
    private String docNumber;
    private Store store;

    //ссылка на строки документа
    private HashMap<Purchase, PurchaseString> documentString = new HashMap<>();

    public Purchase(String docNumber, Store store) {
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

    public HashMap<Purchase, PurchaseString> getDocumentString() {
        return documentString;
    }

}
