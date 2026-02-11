package org.example.tareaspringboot.entities;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa un usuario del sistema almacenado en la base de datos.
 * Esta entidad se mapea a la colección "users" en MongoDB.
 */
@Data
@Document(collection = "users")
public class UserDB {
    /**
     * Identificador único del usuario.
     */
    private String id;

    /**
     * Correo electrónico del usuario, utilizado para la autenticación.
     */
    private String email;

    /**
     * Contraseña del usuario.
     */
    private String password;
}