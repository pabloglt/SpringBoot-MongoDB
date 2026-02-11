package org.example.tareaspringboot.repositories;


import org.example.tareaspringboot.entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad {@link Hotel}.
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    /**
     * Busca un hotel por su nombre.
     *
     * @param nombre El nombre del hotel a buscar.
     * @return El hotel encontrado o null si no existe.
     */
    Hotel findByNombre(String nombre);
}