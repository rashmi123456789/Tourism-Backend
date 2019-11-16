package v1.tourism.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class About {

    @Id
    private String id;

    private String address;
    private String email;
    private double[] mapLanLat;
    private String tel;


    public About() {
    }

    public About(String id, String address, String email, double[] mapLanLat, String tel) {
        this.id=id;
        this.address = address;
        this.email = email;
        this.mapLanLat = mapLanLat;
        this.tel = tel;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double[] getMapLanLat() {
        return this.mapLanLat;
    }

    public void setMapLanLat(double[] mapLanLat) {
        this.mapLanLat = mapLanLat;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof About)) {
            return false;
        }
        About about = (About) o;
        return Objects.equals(id, about.id) 
        && Objects.equals(address, about.address) 
        && Objects.equals(email, about.email) 
        && Objects.equals(mapLanLat, about.mapLanLat) 
        && Objects.equals(tel, about.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, email, mapLanLat, tel);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", mapLanLat='" + getMapLanLat() + "'" +
            ", tel='" + getTel() + "'" +
            "}";
    }
}
