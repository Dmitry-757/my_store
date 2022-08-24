package Model.Directories;


public class Services {
    private long ID;
    private String name;

    public Services(String servicesName) {
        name = servicesName;
    }

    @Override
    public String toString() {
        return "Services{" +
                "ID=" + ID +
                ", ServicesName='" + name + '\'' +
                '}';
    }
}
