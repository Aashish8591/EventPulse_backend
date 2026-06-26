package com.Aashish.eventPulse.controller;

import com.Aashish.eventPulse.entity.Feedback;
import com.Aashish.eventPulse.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @PostMapping
    public Feedback save(
            @RequestBody Feedback feedback){
        return service.save(feedback);
    }

    @GetMapping
    public List<Feedback> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Feedback getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Feedback update(
            @PathVariable Long id,
            @RequestBody Feedback feedback){

        return service.update(id, feedback);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){

        return service.delete(id);
    }

    @GetMapping("/search")
    public List<Feedback> search(
            @RequestParam String eventName){

        return service.search(eventName);
    }
}
