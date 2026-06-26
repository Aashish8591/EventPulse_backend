package com.Aashish.eventPulse.controller;

import com.Aashish.eventPulse.entity.Event;
import com.Aashish.eventPulse.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @PostMapping
    public Event saveEvent(@RequestBody Event event) {
        return service.saveEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id,
                             @RequestBody Event event) {
        return service.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        return service.deleteEvent(id);
    }
}