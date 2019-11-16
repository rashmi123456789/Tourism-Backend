package v1.tourism.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class Inquiries {

    @Id
    private String id;

    private String name;
    private String email;
    private String country;
    private String tel;
    private int numOfChildren;
    private int numOfAdult;
    private String packageId;
    private Date fromDate;
    private Date toDate;


    public Inquiries() {
    }

    public Inquiries(String name, String email, String country, 
    String tel, int numOfChildren, int numOfAdult, String packageId, 
    Date fromDate, Date toDate) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.tel = tel;
        this.numOfChildren = numOfChildren;
        this.numOfAdult = numOfAdult;
        this.packageId = packageId;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getNumOfChildren() {
        return this.numOfChildren;
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
    }

    public int getNumOfAdult() {
        return this.numOfAdult;
    }

    public void setNumOfAdult(int numOfAdult) {
        this.numOfAdult = numOfAdult;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public Date getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return this.toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Inquiries)) {
            return false;
        }
        Inquiries inquiries = (Inquiries) o;
        return Objects.equals(id, inquiries.id)
         && Objects.equals(name, inquiries.name)
         && Objects.equals(email, inquiries.email)
         && Objects.equals(country, inquiries.country) 
         && Objects.equals(tel, inquiries.tel) 
         && numOfChildren == inquiries.numOfChildren 
         && numOfAdult == inquiries.numOfAdult 
         && Objects.equals(packageId, inquiries.packageId) 
         && Objects.equals(fromDate, inquiries.fromDate) 
         && Objects.equals(toDate, inquiries.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, country, tel, numOfChildren,
         numOfAdult, packageId, fromDate, toDate);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", country='" + getCountry() + "'" +
            ", tel='" + getTel() + "'" +
            ", numOfChildren='" + getNumOfChildren() + "'" +
            ", numOfAdult='" + getNumOfAdult() + "'" +
            ", packageId='" + getPackageId() + "'" +
            ", fromDate='" + getFromDate() + "'" +
            ", toDate='" + getToDate() + "'" +
            "}";
    }
}

