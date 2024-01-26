package savogineros.Gestioneeventi.DTO.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        @NotEmpty(message = "Lo user name è un campo obbligatorio")
        @Size(min = 3, max = 20, message = "Lo user name deve essere compreso tra 3 e 20 caratteri")
        String userName,
        @NotEmpty(message = "La email è un campo obbligatorio")
        @Email(message = "Indirizzo e-mail non valido")
        @Size(min = 3, max = 20, message = "La email deve essere compresa tra 3 e 20 caratteri")
        String email,
        @NotEmpty(message = "La password è un campo obbligatorio")
        @Size(min = 8, max = 30, message = "La password deve essere compresa tra 8 e 30 caratteri")
        String password) {
}
