package Model.Directories;

import java.util.Objects;

public class Store {
    private long storeId;
    private String storeName;

    public Store(String storeName) {
        this.storeName = storeName;
    }

    public long getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return storeName.equals(store.storeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, storeName);
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                '}';
    }
}
