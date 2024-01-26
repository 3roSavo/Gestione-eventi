package savogineros.Gestioneeventi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import savogineros.Gestioneeventi.repositories.ReservationsDAO;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsDAO reservationsDAO;
}
