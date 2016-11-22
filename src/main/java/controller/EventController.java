package controller;

import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.EventRepository;

/**
 * Created by kevin on 22/11/2016.
 */
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    public Event createUser(@RequestParam(value = "nom") String nom,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "date")String date){
        Event event = new Event(date,nom,description);
        return eventRepository.save(event);
    }
}
