package com.springboot.eventmanagement.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;


@Entity(name = "EVENT")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "EVENT_ID")
	private long eventId;
	
	@Column(name = "eventName")
	private String eventName;
	
	@Column(name = "eventDate")
	private String eventDate;
	
	@Column(name = "numberOfGuests")
	private int numberOfGuests;
	
	@Column(name = "eventDuration")
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
