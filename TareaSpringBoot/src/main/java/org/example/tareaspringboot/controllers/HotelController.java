package org.example.tareaspringboot.controllers;


import org.example.tareaspringboot.entities.Hotel;
import org.example.tareaspringboot.entities.Reserva;
import org.example.tareaspringboot.services.HotelService;
import org.example.tareaspringboot.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones relacionadas con hoteles y reservas.
 * Expone endpoints bajo la ruta "/hoteles".
 */
@RestController
@RequestMapping("/hoteles") // Cambiado de /api/hoteles a /hoteles
public class HotelController {

    private final HotelService hotelService;
    private final ReservaService reservaService;

    /**
     * Constructor para inyectar los servicios necesarios.
     *
     * @param hotelService   Servicio de gestión de hoteles.
     * @param reservaService Servicio de gestión de reservas.
     */
    public HotelController(HotelService hotelService, ReservaService reservaService) {
        this.hotelService = hotelService;
        this.reservaService = reservaService;
    }

    /**
     * Obtiene la lista de todos los hoteles disponibles.
     *
     * @return Lista de objetos {@link Hotel}.
     */
    // GET /hoteles -> Listar todos
    @GetMapping
    public List<Hotel> getAll() {
        return hotelService.findAll();
    }

    /**
     * Obtiene los detalles de un hotel específico por su ID.
     *
     * @param id El identificador del hotel.
     * @return Un {@link ResponseEntity} con el hotel encontrado.
     */
    // GET /hoteles/{id} -> Obtener detalles por ID (Cambiado de {nombre} a {id})
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }

    /**
     * Crea un nuevo hotel en el sistema.
     * Requiere autenticación.
     *
     * @param hotel El objeto {@link Hotel} a crear.
     * @return Un {@link ResponseEntity} con el hotel creado.
     */
    // POST /hoteles -> Crear nuevo (Quitamos el /create)
    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.save(hotel));
    }

    /**
     * Actualiza la información de un hotel existente.
     * Requiere autenticación.
     *
     * @param id    El identificador del hotel a actualizar.
     * @param hotel El objeto {@link Hotel} con la nueva información.
     * @return Un {@link ResponseEntity} con el hotel actualizado.
     */
    // PUT /hoteles/{id} -> Actualizar información
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> update(@PathVariable String id, @RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.update(id, hotel));
    }

    /**
     * Crea una nueva reserva para un hotel.
     * Requiere autenticación. El email del usuario se toma del contexto de seguridad.
     *
     * @param reserva        El objeto {@link Reserva} con los detalles de la reserva.
     * @param authentication Objeto de autenticación para obtener el usuario actual.
     * @return Un {@link ResponseEntity} con la reserva creada.
     */
    // POST /hoteles/reservas -> Crear una reserva
    @PostMapping("/reservas")
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva, Authentication authentication) {
        // Asegurar que el ID sea null si viene vacío para que Mongo lo autogenere
        if (reserva.getId() != null && reserva.getId().isEmpty()) {
            reserva.setId(null);
        }

        // Validar que el hotel existe si se proporciona un ID
        if (reserva.getHotelId() != null) {
            hotelService.findById(reserva.getHotelId());
        }

        if (authentication != null) {
            reserva.setUsuarioEmail(authentication.getName());
        }
        return ResponseEntity.ok(reservaService.save(reserva));
    }
}