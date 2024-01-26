package savogineros.Gestioneeventi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import savogineros.Gestioneeventi.repositories.EventsDAO;

@Service
public class EventsService {

    @Autowired
    private EventsDAO eventsDAO;
}
