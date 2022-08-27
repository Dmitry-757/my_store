package Model.Directories;

import Model.Service.DocumentsService;

import java.util.Objects;

public class Store {
    private final long id;
    private String name;

    public Store(String storeName) {
        this.name = storeName;
        this.id = DocumentsService.getNewUnicID(this);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return name.equals(store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + name + '\'' +
                '}';
    }
}
