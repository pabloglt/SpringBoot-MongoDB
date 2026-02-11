package org.example.tareaspringboot.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

/**
 * Representa una reserva realizada por un usuario en un hotel.
 * Esta entidad se mapea a la colección "reservas" en MongoDB.
 */
@Data
@Document(collection = "reservas")
public class Reserva {
    /**
     * Identificador único de la reserva.
     */
    @Id
    private String id;

    /**
     * Identificador del hotel asociado a la reserva.
     */
    private String hotelId;

    /**
     * Fecha de entrada al hotel.
     */
    private LocalDate fechaEntrada;

    /**
     * Fecha de salida del hotel.
     */
    private LocalDate fechaSalida;

    /**
     * Número de personas incluidas en la reserva.
     */
    private Integer numeroPersonas;

    /**
     * Correo electrónico del usuario que realizó la reserva.
     */
    private String usuarioEmail;
}