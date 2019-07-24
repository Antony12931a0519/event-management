package com.realtime.collegemanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity(name = "EVENT")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "EVENT_ID")
	private long eventId;
	
	@Column(name = "event_Name")
	private String eventName;
	
	@Column(name = "event_Date")
	private String eventDate;
	
	@Column(name = "number_Of_Guests")
	private int numberOfGuests;
	
	@Column(name = "event_Duration")
	private int eventDuration;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public int getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(int eventDuration) {
		this.eventDuration = eventDuration;
	}
	

}
