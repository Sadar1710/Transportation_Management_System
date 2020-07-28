
package transportationmanagementsystem;

public class businfo {
    
    private int id;
    private String busname;
    private  String model;
    private int capacity;
    private String insuranceStatus;

    public businfo(int id, String busname, String model, int capacity, String insuranceStatus) {
        this.id = id;
        this.busname = busname;
        this.model = model;
        this.capacity = capacity;
        this.insuranceStatus = insuranceStatus;
    }

    public businfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(String insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }

    @Override
    public String toString() {
        return "businfo{" + "id=" + id + ", busname=" + busname + ", model=" + model + ", capacity=" + capacity + ", insuranceStatus=" + insuranceStatus + '}';
    }
    
    
}
