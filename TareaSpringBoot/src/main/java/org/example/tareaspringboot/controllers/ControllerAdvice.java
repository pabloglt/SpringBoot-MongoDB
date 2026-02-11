package org.example.tareaspringboot.controllers;


import org.example.tareaspringboot.dto.ErrorResponseDTO;
import org.example.tareaspringboot.exceptions.HotelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase para el manejo global de excepciones en los controladores REST.
 * Captura excepciones específicas y devuelve respuestas de error estructuradas.
 */
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * Maneja la excepción {@link HotelNotFoundException}.
     *
     * @param ex La excepción capturada.
     * @return Una respuesta con estado 404 (Not Found) y detalles del error.
     */
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleHotelNotFound(HotelNotFoundException ex) {
        ErrorResponseDTO err = new ErrorResponseDTO(
                "Hotel No Encontrado",
                ex.getMessage(),
                404
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    /**
     * Maneja cualquier otra excepción no controlada específicamente.
     *
     * @param ex La excepción capturada.
     * @return Una respuesta con estado 500 (Internal Server Error) y un mensaje genérico.
     */
    // Opcional: Manejar errores genéricos (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericError(Exception ex) {
        ErrorResponseDTO err = new ErrorResponseDTO(
                "Error Interno",
                "Ha ocurrido un error inesperado",
                500
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}