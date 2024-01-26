package savogineros.Gestioneeventi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import savogineros.Gestioneeventi.entities.User;
import savogineros.Gestioneeventi.exceptions.NotFoundException;
import savogineros.Gestioneeventi.repositories.UsersDAO;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersDAO usersDAO;


    // METODI

    public List<User> getAllUsers() {
        return usersDAO.findAll();
    }

    public User getUserById(UUID userId) {
        return usersDAO.findById(userId).orElseThrow( () -> new NotFoundException(userId));
    }

    public User findByEmail(String email) throws NotFoundException {
        return usersDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("Utente con email " + email + " non trovata!"));
    }

    public void deleteUser(UUID userId) {
        User user = getUserById(userId);
        usersDAO.delete(user);
    }

}
