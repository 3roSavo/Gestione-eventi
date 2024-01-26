package savogineros.Gestioneeventi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import savogineros.Gestioneeventi.DTO.users.NewUserDTO;
import savogineros.Gestioneeventi.DTO.users.UserLoginDTO;
import savogineros.Gestioneeventi.DTO.users.UserLoginResponseDTO;
import savogineros.Gestioneeventi.DTO.users.UserResponseDTO;
import savogineros.Gestioneeventi.entities.User;
import savogineros.Gestioneeventi.exceptions.BadRequestException;
import savogineros.Gestioneeventi.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public UserLoginResponseDTO login(@RequestBody UserLoginDTO body) {
		String accessToken = authService.authenticateUser(body);
		return new UserLoginResponseDTO(accessToken);
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponseDTO createUser(@RequestBody @Validated NewUserDTO userDTO, BindingResult validation) {
		if (validation.hasErrors()) {
			System.out.println(validation.getAllErrors());
			throw new BadRequestException("Ci sono errori nel payload!");
		} else {
			User user = authService.saveUser(userDTO);
			return new UserResponseDTO(
					user.getId(),
					userDTO.userName(),
					userDTO.email(),
					userDTO.password(),
					user.getRole());
		}
	}
}
