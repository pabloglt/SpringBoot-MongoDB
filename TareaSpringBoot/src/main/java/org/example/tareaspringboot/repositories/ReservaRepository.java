package org.example.tareaspringboot.repositories;

import org.example.tareaspringboot.entities.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar las operaciones CRUD de la entidad {@link Reserva}.
 */
@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
}