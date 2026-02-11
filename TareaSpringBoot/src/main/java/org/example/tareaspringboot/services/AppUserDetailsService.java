package org.example.tareaspringboot.services;


import org.example.tareaspringboot.entities.UserDB;
import org.example.tareaspringboot.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Servicio personalizado para cargar los detalles del usuario desde la base de datos
 * para la autenticación con Spring Security.
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Constructor para inyectar el repositorio de usuarios.
     *
     * @param userRepository El repositorio de usuarios.
     */
    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Carga un usuario por su nombre de usuario (en este caso, email).
     *
     * @param email El correo electrónico del usuario.
     * @return Los detalles del usuario necesarios para la autenticación.
     * @throws UsernameNotFoundException Si el usuario no es encontrado.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDB userDB = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

        return User.withUsername(userDB.getEmail())
                .password("{noop}" + userDB.getPassword()) // {noop} para contraseñas sin encriptar (pruebas)
                .roles("ADMIN")
                .build();
    }
}