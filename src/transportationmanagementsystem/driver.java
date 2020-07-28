
package transportationmanagementsystem;

public class driver {
    private int id;
    private String drivername;
    private int phone;
    private String maritalstatus;
    private String licence;

    public driver(int id, String drivername, int phone, String maritalstatus, String licence) {
        this.id = id;
        this.drivername = drivername;
        this.phone = phone;
        this.maritalstatus = maritalstatus;
        this.licence = licence;
    }

    public driver() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "driver{" + "id=" + id + ", drivername=" + drivername + ", phone=" + phone + ", maritalstatus=" + maritalstatus + ", licence=" + licence + '}';
    }
    
    
}
