package savogineros.Gestioneeventi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import savogineros.Gestioneeventi.entities.Event;

import java.util.UUID;
@Repository
public interface EventsDAO extends JpaRepository<Event, UUID> {
}
