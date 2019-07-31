package com.realtime.collegemanagement.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtime.collegemanagement.dao.EventDAO;
import com.realtime.collegemanagement.entities.Event;

@Service
public class EventBO {
	@Autowired
	EventDAO eventDAO;

	public List<Event> getEventList() {

		List<Event> events  = null;
		try {
			events	= (List<Event>) eventDAO.findAll();
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
//			e.getMessage();
		}
		return events;
	}

	public Event createStudent(Event event) {

		Event eventDetails = eventDAO.save(event);
		if (eventDetails != null)
			return eventDetails;
		else
			return null;

	}

	public Event updateEvent(Event event) {

		Optional<Event> existingEventDetails = eventDAO.findById(event
				.getEventId());

		Event existingDetails = existingEventDetails.get();

		if (existingDetails != null) {

			existingDetails.setEventDate(event.getEventDate());
			existingDetails.setEventName(event.getEventName());
			existingDetails.setEventDuration(event.getEventDuration());
			existingDetails.setNumberOfGuests(event.getNumberOfGuests());
			Event eventDetails = eventDAO.save(existingDetails);

			if (eventDetails != null) {
				return eventDetails;
			}
		}
		return null;

	}

	public String deleteEvent(Event event) {

		String result = null;

		Optional<Event> existingEventDetails = eventDAO.findById(event
				.getEventId());

		Event existingDetails = existingEventDetails.get();

		if (existingDetails != null) {
			eventDAO.delete(existingDetails);

			result = "records deleted successsfully.";

		} else {
			result = "records not deleted successsfully.";
		}
		return result;

	}

}
