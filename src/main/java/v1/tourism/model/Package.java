package v1.tourism.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Package{

    @Id
    private String id;

    private double totalPrice;
    private String name;
    private String description;
    private String[] itineraryIdArray;
    private String[] inclusions;
    private String[] exclusions;
    private String image_name; 
    private String mapId;


    public Package() {
    }


    public Package( double totalPrice, String name,
     String description, String[] itineraryIdArray, String[] inclusions, String[] exclusions,String image_name, String mapId) {
        this.totalPrice = totalPrice;
        this.name = name;
        this.description = description;
        this.itineraryIdArray = itineraryIdArray;
        this.inclusions = inclusions;
        this.exclusions = exclusions;
        this.image_name = image_name;
        this.mapId = mapId; 
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getImageName() {
        return this.image_name;
    }

    public void setImageName(String image_name) {
        this.image_name = image_name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getItineraryIdArray() {
        return this.itineraryIdArray;
    }

    public void setItineraryIdArray(String[] itineraryIdArray) {
        this.itineraryIdArray = itineraryIdArray;
    }

    public String[] getInclusions() {
        return this.inclusions;
    }

    public void setInclusions(String[] inclusions) {
        this.inclusions = inclusions;
    }

    public String[] getExclusions() {
        return this.exclusions;
    }

    public void setExclusions(String[] exclusions) {
        this.exclusions = exclusions;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String mapId) {
        this.mapId = mapId;
    }

    public String getMapId() {
        return this.mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Package)) {
            return false;
        }
        Package p = (Package) o;
        return Objects.equals(id, p.id) && totalPrice == p.totalPrice
         && Objects.equals(name, p.name)
         && Objects.equals(description, p.description)
         && Objects.equals(itineraryIdArray, p.itineraryIdArray)
         && Objects.equals(inclusions, p.inclusions)
         && Objects.equals(exclusions, p.exclusions)
         && Objects.equals(image_name, p.image_name)
         && Objects.equals(mapId, p.mapId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPrice, name, description, itineraryIdArray, inclusions, exclusions, image_name, mapId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", totalPrice='" + getTotalPrice() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", itineraryIdArray='" + getItineraryIdArray() + "'" +
            ", inclusions='" + getInclusions() + "'" +
            ", exclusions='" + getExclusions() + "'" +
            ", image_name='" + getImageName() + "'" +
            ", mapId='" + getMapId() + "'" +
            "}";
    }
    

}
