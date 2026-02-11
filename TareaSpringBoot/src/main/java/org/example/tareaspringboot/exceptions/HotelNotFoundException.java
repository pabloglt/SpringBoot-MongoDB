package org.example.tareaspringboot.exceptions;


/**
 * Excepción personalizada lanzada cuando no se encuentra un hotel solicitado.
 */
public class HotelNotFoundException extends RuntimeException {
    /**
     * Constructor de la excepción.
     *
     * @param message Mensaje descriptivo del error.
     */
    public HotelNotFoundException(String message) {
        super(message);
    }
}