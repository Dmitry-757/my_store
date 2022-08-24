package Model.Documents;


import Model.Directories.Store;
import Model.Service.DocumentsService;

import java.util.HashSet;

public class Purchase implements IDocumentHeadable{
    private final long documentID;
    private String docNumber;
    private Store store;

    //ссылка на строки документа
    private HashSet<IDocumentStringable> documentStrings = new HashSet<>();

    public Purchase(String docNumber, Store store) {
        this.docNumber = docNumber;
        this.store = store;
        this.documentID = DocumentsService.getNewUnicID(this);
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

    public HashSet<IDocumentStringable> getDocumentString() {
        return documentStrings;
    }

    @Override
    public void addString(IDocumentStringable documentString){
        documentStrings.add(documentString);
    }

    @Override
    public String toString() {

        //System.out.println(str);
        return "Purchase{" +
                "documentID=" + documentID +
                ", docNumber='" + docNumber + '\'' +
                ", store=" + store +
                '}'+"\n"
                + "Doc strings: \n"+
                documentStrings.stream().toList().toString()
                ;
    }
}
