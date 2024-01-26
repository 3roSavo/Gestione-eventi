package savogineros.Gestioneeventi.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // ogni prenotazione dovà necessariamente avere un utente collegato
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false) // ogni prenotazione dovà necessariamente avere un evento collegato
    private Event event;

    private int seatsBooked;


    public Reservation(User user, Event event, int seatsBooked) {
        this.user = user;
        this.event = event;
        this.seatsBooked = seatsBooked;
    }
}
