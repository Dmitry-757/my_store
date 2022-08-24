package Model.Directories;


import Model.Service.DocumentsService;

public class Service {
    private long ID;
    private String name;

    public Service(String servicesName) {
        this.name = servicesName;
        this.ID = DocumentsService.getNewUnicID(this);
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
                "ID=" + ID +
                ", ServicesName='" + name + '\'' +
                '}';
    }
}
