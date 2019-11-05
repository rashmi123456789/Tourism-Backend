package v1.tourism.model;

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


    public User(){

    }

    public User(String id,String name,String email,String country,int age,String referenceNumber,String password){
        this.id=id;
        this.name=name;
        this.email=email;
        this.country=country;
        this.age=age;
        this.password=password;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getId(){
        return this.id;
    }

    public String getCountry(){
        return this.country;
    }

    public int getAge(){
        return this.age;
    }

    public String getPassword(){
        return this.password;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setCountry(String country){
        this.country=country;
    }
    
    public void setAge(int age){
        this.age=age;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setEmail(String email){
        this.email=email;
    }
    

}