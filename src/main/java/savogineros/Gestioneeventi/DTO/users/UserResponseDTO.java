package savogineros.Gestioneeventi.DTO.users;

import savogineros.Gestioneeventi.entities.Role;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String userName,
        String email,
        String password,
        Role role) {
}
