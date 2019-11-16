package v1.tourism.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class Itinerary {

    @Id
    private String id;

    private String name;
    private String imageId;
    private String description;
    private double[] mapLatLan;
    private int dayNum;
    private String destination;
    private String[] activities;


    public Itinerary() {
    }

    public Itinerary(String name, String imageId,
     String description, double[] mapLatLan, int dayNum,
      String destination, String[] activities) {
        this.name = name;
        this.imageId = imageId;
        this.description = description;
        this.mapLatLan = mapLatLan;
        this.dayNum = dayNum;
        this.destination = destination;
        this.activities = activities;
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

    public String getImageId() {
        return this.imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double[] getMapLatLan() {
        return this.mapLatLan;
    }

    public void setMapLatLan(double[] mapLatLan) {
        this.mapLatLan = mapLatLan;
    }

    public int getDayNum() {
        return this.dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String[] getActivities() {
        return this.activities;
    }

    public void setActivities(String[] activities) {
        this.activities = activities;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Itinerary)) {
            return false;
        }
        Itinerary itinerary = (Itinerary) o;
        return Objects.equals(id, itinerary.id)
         && Objects.equals(name, itinerary.name)
         && Objects.equals(imageId, itinerary.imageId)
         && Objects.equals(description, itinerary.description)
         && Objects.equals(mapLatLan, itinerary.mapLatLan)
         && dayNum == itinerary.dayNum
         && Objects.equals(destination, itinerary.destination)
         && Objects.equals(activities, itinerary.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageId, description, mapLatLan, dayNum, destination, activities);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", imageId='" + getImageId() + "'" +
            ", description='" + getDescription() + "'" +
            ", mapLatLan='" + getMapLatLan() + "'" +
            ", dayNum='" + getDayNum() + "'" +
            ", destination='" + getDestination() + "'" +
            ", activities='" + getActivities() + "'" +
            "}";
    }

}
