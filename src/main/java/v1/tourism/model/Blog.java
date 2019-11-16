package v1.tourism.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class Blog {

    @Id
    private String id;

    private String topic;
    private String imageId;
    private String description;


    public Blog() {
    }

    public Blog(String topic, String imageId, String description) {
        this.topic = topic;
        this.imageId = imageId;
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Blog)) {
            return false;
        }
        Blog blog = (Blog) o;
        return Objects.equals(id, blog.id) 
        && Objects.equals(topic, blog.topic) 
        && Objects.equals(imageId, blog.imageId) 
        && Objects.equals(description, blog.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, imageId, description);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", topic='" + getTopic() + "'" +
            ", imageId='" + getImageId() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
