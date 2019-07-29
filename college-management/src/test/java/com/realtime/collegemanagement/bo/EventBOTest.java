package com.realtime.collegemanagement.bo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.realtime.collegemanagement.dao.EventDAO;
import com.realtime.collegemanagement.entities.Event;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventBOTest {

	@InjectMocks
	EventBO eventBO;

	@Mock
	EventDAO eventDAO;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

	}

	public void getEventListTest() {

		List<Event> events = new ArrayList<Event>();

		Event event = new Event();
		event.setEventDate("drfgh");

		events.add(event);

		Mockito.when(eventDAO.findAll()).thenReturn(events);
		
		eventBO.getEventList();
	}

}
