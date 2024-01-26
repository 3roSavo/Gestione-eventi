package savogineros.Gestioneeventi.DTO.events;

import java.time.LocalDate;
import java.util.UUID;

public record EventResponseDTO(
        UUID id,
        String title,
        String description,
        LocalDate date,
        String location,
        int seatsAvailable) {
}
