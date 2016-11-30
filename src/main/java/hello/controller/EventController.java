package hello.controller;

import hello.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hello.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by kevin on 22/11/2016.
 */
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(method = POST)
    public EventModel createEvent(@RequestParam(value = "nom") String nom,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "date")String date){
        EventModel event = new EventModel(date,nom,description);
        return eventRepository.save(event);
    }

    @RequestMapping(method = GET)
    public List<EventModel> allEvent(){
        List<EventModel> events = new ArrayList<>();
        events = (List<EventModel>) eventRepository.findAll();
        return events;
    }


}
