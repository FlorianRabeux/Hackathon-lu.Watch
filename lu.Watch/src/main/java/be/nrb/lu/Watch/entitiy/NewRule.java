package be.nrb.lu.Watch.entitiy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"daysMonday",
	"daysTuesday",
	"daysWednesday",
	"daysThursday",
	"daysFriday",
	"daysSaturday",
	"daysSunday",
	"name",
	"timeFrom",
	"timeTo",
	"notificationEmail",
	"notificationSms",
	"positionAreaRadius",
	"positionAreaLat",
	"positionAreaLng"
})
public class NewRule {

	@JsonProperty("daysMonday")
	private Boolean daysMonday;
	@JsonProperty("daysTuesday")
	private Boolean daysTuesday;
	@JsonProperty("daysWednesday")
	private Boolean daysWednesday;
	@JsonProperty("daysThursday")
	private Boolean daysThursday;
	@JsonProperty("daysFriday")
	private Boolean daysFriday;
	@JsonProperty("daysSaturday")
	private Boolean daysSaturday;
	@JsonProperty("daysSunday")
	private Boolean daysSunday;
	@JsonProperty("name")
	private String name;
	@JsonProperty("timeFrom")
	private String timeFrom;
	@JsonProperty("timeTo")
	private String timeTo;
	@JsonProperty("notificationEmail")
	private String notificationEmail;
	@JsonProperty("notificationSms")
	private String notificationSms;
	@JsonProperty("positionAreaRadius")
	private Double positionAreaRadius;
	@JsonProperty("positionAreaLat")
	private Double positionAreaLat;
	@JsonProperty("positionAreaLng")
	private Double positionAreaLng;

/**
* No args constructor for use in serialization
*
*/
public NewRule() {
}

/**
*
* @param daysWednesday
* @param daysFriday
* @param positionAreaLng
* @param timeTo
* @param daysMonday
* @param notificationEmail
* @param daysTuesday
* @param daysSaturday
* @param positionAreaRadius
* @param daysSunday
* @param name
* @param positionAreaLat
* @param timeFrom
* @param daysThursday
* @param notificationSms
*/
public NewRule(Boolean daysMonday, Boolean daysTuesday, Boolean daysWednesday, Boolean daysThursday, Boolean daysFriday, Boolean daysSaturday, Boolean daysSunday, String name, String timeFrom, String timeTo, String notificationEmail, String notificationSms, Double positionAreaRadius, Double positionAreaLat, Double positionAreaLng) {
	super();
	this.daysMonday = daysMonday;
	this.daysTuesday = daysTuesday;
	this.daysWednesday = daysWednesday;
	this.daysThursday = daysThursday;
	this.daysFriday = daysFriday;
	this.daysSaturday = daysSaturday;
	this.daysSunday = daysSunday;
	this.name = name;
	this.timeFrom = timeFrom;
	this.timeTo = timeTo;
	this.notificationEmail = notificationEmail;
	this.notificationSms = notificationSms;
	this.positionAreaRadius = positionAreaRadius;
	this.positionAreaLat = positionAreaLat;
	this.positionAreaLng = positionAreaLng;
}

@JsonProperty("daysMonday")
public Boolean getDaysMonday() {
	return daysMonday;
}

@JsonProperty("daysMonday")
public void setDaysMonday(Boolean daysMonday) {
	this.daysMonday = daysMonday;
}

@JsonProperty("daysTuesday")
public Boolean getDaysTuesday() {
	return daysTuesday;
}

@JsonProperty("daysTuesday")
public void setDaysTuesday(Boolean daysTuesday) {
	this.daysTuesday = daysTuesday;
}

@JsonProperty("daysWednesday")
public Boolean getDaysWednesday() {
	return daysWednesday;
}

@JsonProperty("daysWednesday")
public void setDaysWednesday(Boolean daysWednesday) {
	this.daysWednesday = daysWednesday;
}

@JsonProperty("daysThursday")
public Boolean getDaysThursday() {
	return daysThursday;
}

@JsonProperty("daysThursday")
public void setDaysThursday(Boolean daysThursday) {
	this.daysThursday = daysThursday;
}

@JsonProperty("daysFriday")
public Boolean getDaysFriday() {
	return daysFriday;
}

@JsonProperty("daysFriday")
public void setDaysFriday(Boolean daysFriday) {
	this.daysFriday = daysFriday;
}

@JsonProperty("daysSaturday")
public Boolean getDaysSaturday() {
	return daysSaturday;
}

@JsonProperty("daysSaturday")
public void setDaysSaturday(Boolean daysSaturday) {
	this.daysSaturday = daysSaturday;
}

@JsonProperty("daysSunday")
public Boolean getDaysSunday() {
	return daysSunday;
}

@JsonProperty("daysSunday")
public void setDaysSunday(Boolean daysSunday) {
	this.daysSunday = daysSunday;
}

@JsonProperty("name")
public String getName() {
	return name;
}

@JsonProperty("name")
public void setName(String name) {
	this.name = name;
}

@JsonProperty("timeFrom")
public String getTimeFrom() {
	return timeFrom;
}

@JsonProperty("timeFrom")
public void setTimeFrom(String timeFrom) {
	this.timeFrom = timeFrom;
}

@JsonProperty("timeTo")
public String getTimeTo() {
	return timeTo;
}

@JsonProperty("timeTo")
public void setTimeTo(String timeTo) {
	this.timeTo = timeTo;
}

@JsonProperty("notificationEmail")
public String getNotificationEmail() {
	return notificationEmail;
}

@JsonProperty("notificationEmail")
public void setNotificationEmail(String notificationEmail) {
	this.notificationEmail = notificationEmail;
}

@JsonProperty("notificationSms")
public String getNotificationSms() {
	return notificationSms;
}

@JsonProperty("notificationSms")
public void setNotificationSms(String notificationSms) {
	this.notificationSms = notificationSms;
}

@JsonProperty("positionAreaRadius")
public Double getPositionAreaRadius() {
	return positionAreaRadius;
}

@JsonProperty("positionAreaRadius")
public void setPositionAreaRadius(Double positionAreaRadius) {
	this.positionAreaRadius = positionAreaRadius;
}

@JsonProperty("positionAreaLat")
public Double getPositionAreaLat() {
	return positionAreaLat;
}

@JsonProperty("positionAreaLat")
public void setPositionAreaLat(Double positionAreaLat) {
	this.positionAreaLat = positionAreaLat;
}

@JsonProperty("positionAreaLng")
public Double getPositionAreaLng() {
	return positionAreaLng;
}

@JsonProperty("positionAreaLng")
public void setPositionAreaLng(Double positionAreaLng) {
	this.positionAreaLng = positionAreaLng;
}

}

