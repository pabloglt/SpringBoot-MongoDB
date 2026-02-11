package org.example.tareaspringboot.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

/**
 * Representa un hotel en el sistema.
 * Esta entidad se mapea a la colección "hoteles" en MongoDB.
 */
@Data
@Document(collection = "hoteles") // Se guardará en esta colección
public class Hotel {
    /**
     * Identificador único del hotel.
     */
    @Id
    private String id;

    /**
     * Nombre del hotel.
     */
    private String nombre;

    /**
     * Ciudad donde se ubica el hotel.
     */
    private String ciudad;

    /**
     * Categoría del hotel (número de estrellas).
     */
    private Integer estrellas;

    /**
     * Precio por noche en el hotel.
     */
    private Double precioNoche;

    /**
     * Lista de servicios disponibles en el hotel.
     */
    private List<String> servicios;
}