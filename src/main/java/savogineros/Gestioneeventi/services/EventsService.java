package savogineros.Gestioneeventi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import savogineros.Gestioneeventi.DTO.events.NewEventDTO;
import savogineros.Gestioneeventi.entities.Event;
import savogineros.Gestioneeventi.repositories.EventsDAO;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    private EventsDAO eventsDAO;

    // METODI

    public List<Event> getAllEvents() {
        return eventsDAO.findAll();
    }

    public Event saveEvent(NewEventDTO eventDTO) {

        return eventsDAO.save(new Event(
                eventDTO.title(),
                eventDTO.description(),
                eventDTO.date(),
                eventDTO.location(),
                eventDTO.seatsAvailable()));
    }


}
