package com.Aashish.eventPulse.service;

import com.Aashish.eventPulse.entity.Event;
import com.Aashish.eventPulse.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event getEventById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Event saveEvent(Event event) {
        return repository.save(event);
    }

    public Event updateEvent(Long id, Event event) {

        Event existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setTitle(event.getTitle());
            existing.setCategory(event.getCategory());
            existing.setLocation(event.getLocation());
            existing.setEventDate(event.getEventDate());
            existing.setImageUrl(event.getImageUrl());
            existing.setDescription(event.getDescription());

            return repository.save(existing);
        }

        return null;
    }

    public String deleteEvent(Long id) {

        repository.deleteById(id);

        return "Event Deleted Successfully";
    }
}