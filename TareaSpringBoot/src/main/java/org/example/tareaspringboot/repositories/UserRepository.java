package org.example.tareaspringboot.repositories;


import org.example.tareaspringboot.entities.UserDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad {@link UserDB}.
 */
public interface UserRepository extends MongoRepository<UserDB, String> {
    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email El correo electrónico del usuario.
     * @return Un {@link Optional} que contiene el usuario si se encuentra, o vacío si no.
     */
    Optional<UserDB> findByEmail(String email);
}