package Model.Directories;


import Model.Service.DocumentsService;

public class Service {
    private final long id;
    private String name;

    public Service(String servicesName) {
        this.name = servicesName;
        this.id = DocumentsService.getNewUnicID(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Service{" +
                "ID=" + id +
                ", ServicesName='" + name + '\'' +
                '}';
    }
}
