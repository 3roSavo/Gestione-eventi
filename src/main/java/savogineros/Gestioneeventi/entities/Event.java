package savogineros.Gestioneeventi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String title;

    private String description;

    private LocalDate date;

    private String location;

    private int seatsAvailable;

    @OneToMany(mappedBy = "event")
    private List<Reservation> reservationList;


    public Event(String title, String description, LocalDate date, String location, int seatsAvailable) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.seatsAvailable = seatsAvailable;
    }
}
