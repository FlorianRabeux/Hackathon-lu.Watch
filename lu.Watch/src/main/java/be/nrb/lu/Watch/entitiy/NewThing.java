package be.nrb.lu.Watch.entitiy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"sensorId",
"description",
"image"
})
public class NewThing {

@JsonProperty("name")
private String name;
@JsonProperty("sensorId")
private String sensorId;
@JsonProperty("description")
private String description;
@JsonProperty("image")
private String image;

/**
* No args constructor for use in serialization
*
*/
public NewThing() {
}

/**
*
* @param description
* @param sensorId
* @param name
* @param image
*/
public NewThing(String name, String sensorId, String description, String image) {
super();
this.name = name;
this.sensorId = sensorId;
this.description = description;
this.image = image;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("sensorId")
public String getSensorId() {
return sensorId;
}

@JsonProperty("sensorId")
public void setSensorId(String sensorId) {
this.sensorId = sensorId;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("image")
public String getImage() {
return image;
}

@JsonProperty("image")
public void setImage(String image) {
this.image = image;
}

}

