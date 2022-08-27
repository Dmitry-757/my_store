package Model.Documents;

import Model.Directories.Store;
import Model.Service.DocumentsService;

import java.util.HashSet;

public class Sale implements IDocumentHeadable{
    private final long id;
    private String docNumber;
    private Store store;

    //ссылка на строки документа
    private HashSet<IDocumentStringable> documentStrings = new HashSet<>();

    //constructor
    public Sale(String docNumber, Store store) {
        this.docNumber = docNumber;
        this.store = store;
        this.id = DocumentsService.getNewUnicID(this);
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

    public String toString() {
        //System.out.println(str);
        return "Sale{" +
                "documentID=" + id +
                ", docNumber='" + docNumber + '\'' +
                ", store=" + store +
                '}'+"\n"
                + "Doc strings: \n"+
                documentStrings.stream().toList().toString()
                ;
    }

}
