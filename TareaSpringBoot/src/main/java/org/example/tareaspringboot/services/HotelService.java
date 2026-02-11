package org.example.tareaspringboot.services;

import org.example.tareaspringboot.entities.Hotel;
import org.example.tareaspringboot.repositories.HotelRepository;
import org.example.tareaspringboot.exceptions.HotelNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio relacionada con los hoteles.
 */
@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    /**
     * Constructor para inyectar el repositorio de hoteles.
     *
     * @param hotelRepository El repositorio de hoteles.
     */
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * Obtiene una lista de todos los hoteles registrados.
     *
     * @return Lista de hoteles.
     */
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    /**
     * Busca un hotel por su identificador.
     *
     * @param id El identificador del hotel.
     * @return El hotel encontrado.
     * @throws HotelNotFoundException Si no se encuentra un hotel con el ID proporcionado.
     */
    public Hotel findById(String id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel no encontrado con ID: " + id));
    }

    /**
     * Guarda un nuevo hotel en la base de datos.
     *
     * @param hotel El objeto hotel a guardar.
     * @return El hotel guardado.
     */
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    /**
     * Actualiza la información de un hotel existente.
     *
     * @param id    El identificador del hotel a actualizar.
     * @param nuevo El objeto con la nueva información del hotel.
     * @return El hotel actualizado.
     * @throws HotelNotFoundException Si no se encuentra el hotel a actualizar.
     */
    public Hotel update(String id, Hotel nuevo) {
        return hotelRepository.findById(id).map(h -> {
            h.setNombre(nuevo.getNombre());
            h.setCiudad(nuevo.getCiudad());
            h.setEstrellas(nuevo.getEstrellas());
            h.setPrecioNoche(nuevo.getPrecioNoche());
            h.setServicios(nuevo.getServicios());
            return hotelRepository.save(h);
        }).orElseThrow(() -> new HotelNotFoundException("No se puede actualizar, ID inexistente: " + id));
    }
}