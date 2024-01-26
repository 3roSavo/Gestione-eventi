package savogineros.Gestioneeventi.DTO.events;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewEventDTO(
        @NotEmpty(message = "Il titolo è richiesto")
        String title,
        @NotEmpty(message = "La descrizione è richiesta")
        String description,
        @NotEmpty(message = "La data è richiesta")
        LocalDate date,
        @NotEmpty(message = "La zona è richiesta")
        String location,
        @NotEmpty(message = "I numero di posti disponibili è richiesto")
        int seatsAvailable) {
}
