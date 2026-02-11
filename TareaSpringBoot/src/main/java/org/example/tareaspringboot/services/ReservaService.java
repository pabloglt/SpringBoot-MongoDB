package org.example.tareaspringboot.services;

import org.example.tareaspringboot.entities.Reserva;
import org.example.tareaspringboot.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio que gestiona la lógica de negocio relacionada con las reservas.
 */
@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    /**
     * Constructor para inyectar el repositorio de reservas.
     *
     * @param reservaRepository El repositorio de reservas.
     */
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    /**
     * Guarda una nueva reserva en la base de datos.
     *
     * @param reserva La reserva a guardar.
     * @return La reserva guardada.
     */
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}