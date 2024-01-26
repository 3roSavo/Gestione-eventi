package savogineros.Gestioneeventi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import savogineros.Gestioneeventi.DTO.users.NewUserDTO;
import savogineros.Gestioneeventi.DTO.users.UserLoginDTO;
import savogineros.Gestioneeventi.entities.Role;
import savogineros.Gestioneeventi.entities.User;
import savogineros.Gestioneeventi.exceptions.BadRequestException;
import savogineros.Gestioneeventi.exceptions.UnauthorizedException;
import savogineros.Gestioneeventi.repositories.UsersDAO;
import savogineros.Gestioneeventi.security.JWTTools;

@Service
public class AuthService {
	@Autowired
	private UsersService usersService;

	@Autowired
	private UsersDAO usersDAO;

	@Autowired
	private JWTTools jwtTools;

	public String authenticateUser(UserLoginDTO body) {
		// 1. Verifichiamo che l'email dell'utente sia nel db
		User user = usersService.findByEmail(body.email());

		// 2. In caso affermativo, verifichiamo se la password fornita corrisponde a quella trovata nel db
		if (user.getPassword().equals(body.password())) {
			// 3. Se le credenziali sono OK --> Genere un token JWT e lo ritorno
			return jwtTools.createToken(user);
		} else {
			// 4. Se le credenziali NON sono OK --> 401 (Unauthorized)
			throw new UnauthorizedException("Credenziali non valide!");
		}
	}



	public User saveUser(NewUserDTO userDTO) {

		usersDAO.findByEmail(userDTO.email()).ifPresent( user -> { throw new BadRequestException("L'email " + user.getEmail() + " è già in uso");});

		User user = new User(userDTO.userName(), userDTO.email(), userDTO.password());
		user.setRole(Role.NORMAL_USER);
		return usersDAO.save(user);
	}


}
