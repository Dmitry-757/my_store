package Model.Documents;

import Model.Directories.Store;

import java.util.HashMap;

public class Move {
    private final long documentID;
    private String docNumber;
    private Store storeDonor;
    private Store storeRecipient;



    //ссылка на строки документа
    private HashMap<Move, MoveString> documentString = new HashMap<>();

    //constructor
    public Move(String docNumber, Store storeDonor, Store storeRecipient) {
        this.docNumber = docNumber;
        this.storeDonor = storeDonor;
        this.storeRecipient = storeRecipient;
        this.documentID = getNewUnicalID();
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Store getStoreDonor() {
        return storeDonor;
    }

    public void setStoreDonor(Store storeDonor) {
        this.storeDonor = storeDonor;
    }

    public Store getStoreRecipient() {
        return storeRecipient;
    }

    public void setStoreRecipient(Store storeRecipient) {
        this.storeRecipient = storeRecipient;
    }

    public HashMap<Move, MoveString> getDocumentString() {
        return documentString;
    }

}
