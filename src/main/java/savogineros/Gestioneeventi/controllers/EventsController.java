package savogineros.Gestioneeventi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import savogineros.Gestioneeventi.DTO.events.EventResponseDTO;
import savogineros.Gestioneeventi.DTO.events.NewEventDTO;
import savogineros.Gestioneeventi.entities.Event;
import savogineros.Gestioneeventi.exceptions.BadRequestException;
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

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponseDTO saveEvent(@RequestBody @Validated NewEventDTO eventDTO, BindingResult validation) {

        if (validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException("Ci sono errori nel payload!!!");
        } else {
        Event event = eventsService.saveEvent(eventDTO);
            return new EventResponseDTO(
                    event.getId(),
                    event.getTitle(),
                    event.getDescription(),
                    event.getDate(),
                    event.getLocation(),
                    event.getSeatsAvailable());
        }

    }



}
