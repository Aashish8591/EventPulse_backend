package com.Aashish.eventPulse.service;

import com.Aashish.eventPulse.entity.Feedback;
import com.Aashish.eventPulse.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repo;

    public Feedback save(Feedback feedback){
        return repo.save(feedback);
    }

    public List<Feedback> getAll(){
        return repo.findAll();
    }

    public Feedback getById(Long id){
        return repo.findById(id).orElse(null);
    }

    public Feedback update(Long id, Feedback feedback){

        Feedback existing = repo.findById(id).orElse(null);

        if(existing != null){

            existing.setName(feedback.getName());
            existing.setEmail(feedback.getEmail());
            existing.setEventName(feedback.getEventName());
            existing.setRating(feedback.getRating());
            existing.setComment(feedback.getComment());

            return repo.save(existing);
        }

        return null;
    }

    public String delete(Long id){

        repo.deleteById(id);

        return "Feedback Deleted Successfully";
    }

    public List<Feedback> search(String eventName){

        return repo.findByEventNameContainingIgnoreCase(eventName);

    }

}
