package v1.tourism.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class Itinerary {

    @Id
    private String id;

    private String name;
    private String image_name;
    private String description;
    private int dayNum;
    private String destination;
    private String[] activities;


    public Itinerary() {
    }

    public Itinerary(String name, String image_name,
     String description, int dayNum,
      String destination, String[] activities) {
        this.name = name;
        this.image_name = image_name;
        this.description = description;
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
         && Objects.equals(image_name, itinerary.image_name)
         && Objects.equals(description, itinerary.description)
         && dayNum == itinerary.dayNum
         && Objects.equals(destination, itinerary.destination)
         && Objects.equals(activities, itinerary.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image_name, description, dayNum, destination, activities);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", image_name='" + getImageName() + "'" +
            ", description='" + getDescription() + "'" +
            ", dayNum='" + getDayNum() + "'" +
            ", destination='" + getDestination() + "'" +
            ", activities='" + getActivities() + "'" +
            "}";
    }

}
