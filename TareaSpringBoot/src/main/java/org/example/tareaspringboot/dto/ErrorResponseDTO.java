package org.example.tareaspringboot.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO (Data Transfer Object) para estructurar las respuestas de error de la API.
 */
@AllArgsConstructor
@Getter
public class ErrorResponseDTO {
    /**
     * Tipo o nombre del error.
     */
    private String error;

    /**
     * Mensaje descriptivo del error.
     */
    private String message;

    /**
     * Código de estado HTTP asociado al error.
     */
    private Integer errorCode;
}