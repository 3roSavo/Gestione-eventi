package savogineros.Gestioneeventi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import savogineros.Gestioneeventi.DTO.events.EventResponseDTO;
import savogineros.Gestioneeventi.entities.Event;
import savogineros.Gestioneeventi.services.EventsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping("")
    public List<EventResponseDTO> getAllEvents() {
        List<EventResponseDTO> eventResponseList = new ArrayList<>();
        eventsService.getAllEvents().forEach(event -> eventResponseList.add(
                new EventResponseDTO(
                        event.getId(),
                        event.getTitle(),
                        event.getDescription(),
                        event.getDate(),
                        event.getLocation(),
                        event.getSeatsAvailable())));

        return  eventResponseList;
    }



}
