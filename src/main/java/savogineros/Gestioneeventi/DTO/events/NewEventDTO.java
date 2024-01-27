package savogineros.Gestioneeventi.DTO.events;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record NewEventDTO(
        @NotEmpty(message = "Il titolo è richiesto")
        String title,
        @NotEmpty(message = "La descrizione è richiesta")
        String description,
        @NotEmpty(message = "La data è richiesta")
        String date,
        @NotEmpty(message = "La zona è richiesta")
        String location,
        //@Positive(message = "Il valore deve essere maggiore di zero")
        int seatsAvailable) {
}
