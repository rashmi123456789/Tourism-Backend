package v1.tourism.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    private String country;
    private int age;
    private String password;
    private Long tel;


    public User() {
    }

    public User(String id, String name, String email, String country,
     int age, String password, Long tel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.age = age;
        this.password = password;
        this.tel = tel;
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTel() {
        return this.tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public User id(String id) {
        this.id = id;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User country(String country) {
        this.country = country;
        return this;
    }

    public User age(int age) {
        this.age = age;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User tel(Long tel) {
        this.tel = tel;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id)
         && Objects.equals(name, user.name)
         && Objects.equals(email, user.email)
         && Objects.equals(country, user.country) 
         && age == user.age
         && Objects.equals(password, user.password)
         && Objects.equals(tel, user.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, country, age, password, tel);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", country='" + getCountry() + "'" +
            ", age='" + getAge() + "'" +
            ", password='" + getPassword() + "'" +
            ", tel='" + getTel() + "'" +
            "}";
    }

}
