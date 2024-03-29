package savogineros.Gestioneeventi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import savogineros.Gestioneeventi.DTO.users.ErrorsDTO;

import java.time.LocalDateTime;

@RestControllerAdvice // <-- Controller specifico per le eccezioni
// Questa classe dovrà quindi catturare le eccezioni provenienti dai nostri endpoints
// Implementerò un metodo per ogni eccezione da gestire
public class ExceptionsHandler {
	@ExceptionHandler(BadRequestException.class)
	// Indico che questo metodo gestirà le eccezioni di tipo BadRequestException
	@ResponseStatus(HttpStatus.BAD_REQUEST) // Dovrà rispondere con un 400
	public ErrorsDTO handleBadRequest(BadRequestException ex) {
		return new ErrorsDTO(ex.getMessage(), LocalDateTime.now());
	}

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
	public ErrorsDTO handleUnauthorized(UnauthorizedException ex) {
		return new ErrorsDTO(ex.getMessage(), LocalDateTime.now());
	}

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN) // 403
	public ErrorsDTO handleAccessDenied(AccessDeniedException ex) {
		return new ErrorsDTO("Il tuo ruolo non permette di accedere a questa funzionalità!", LocalDateTime.now());
	}

	@ExceptionHandler(NotFoundException.class)
	// Indico che questo metodo gestirà le eccezioni di tipo NotFoundException
	@ResponseStatus(HttpStatus.NOT_FOUND) // Dovrà rispondere con un 404
	public ErrorsDTO handleNotFound(NotFoundException ex) {
		return new ErrorsDTO(ex.getMessage(), LocalDateTime.now());
	}


	@ExceptionHandler(Exception.class)
	// Tutti gli altri tipi di eccezioni (come errori vari nel codice) verranno gestiti da questo metodo
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Dovrà rispondere con un 500
	public ErrorsDTO handleGenericError(Exception ex) {
		ex.printStackTrace();
		return new ErrorsDTO("Problema lato server! Giuro che risolveremo presto!", LocalDateTime.now());
	}
}
