package Model.Documents;

import Model.Directories.Store;
import Model.Service.DocumentsService;

import java.util.HashSet;

public class Move implements IDocumentHeadable{
    private final long documentID;
    private String docNumber;
    private Store storeDonor;
    private Store storeRecipient;



    //ссылка на строки документа
    private HashSet<IDocumentStringable> documentStrings = new HashSet<>();

    //constructor
    public Move(String docNumber, Store storeDonor, Store storeRecipient) {
        this.docNumber = docNumber;
        this.storeDonor = storeDonor;
        this.storeRecipient = storeRecipient;
        this.documentID = DocumentsService.getNewUnicID(this);
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

    public HashSet<IDocumentStringable> getDocumentString() {
        return documentStrings;
    }

    @Override
    public void addString(IDocumentStringable documentString){
        documentStrings.add(documentString);
    }

    public String toString() {
        //System.out.println(str);
        return "Move{" +
                "documentID=" + documentID +
                ", docNumber='" + docNumber + '\'' +
                ", storeFrom=" + storeDonor +
                ", storeTo=" + storeRecipient +
                '}'+"\n"
                + "Doc strings: \n"+
                documentStrings.stream().toList().toString()
                ;
    }

}
