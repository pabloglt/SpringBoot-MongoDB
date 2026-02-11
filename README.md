# TurismoAPI - Documentación de la API

Esta API REST permite gestionar hoteles y reservas, proporcionando funcionalidades para consultar, crear y actualizar hoteles, así como realizar reservas.

## Recursos

La API expone los siguientes recursos principales:

*   **Hoteles**: Gestión de la información de los hoteles.
*   **Reservas**: Gestión de las reservas realizadas por los usuarios.

## Autenticación

Algunos endpoints requieren autenticación mediante **Basic Auth**.
*   **Usuario**: (El email registrado en la base de datos)
*   **Contraseña**: (La contraseña registrada)

## Endpoints

### 1. Hoteles

#### Listar todos los hoteles
Obtiene una lista de todos los hoteles registrados.

*   **Método**: `GET`
*   **URL**: `/hoteles`
*   **Autenticación**: No requerida (Pública)

**Ejemplo de Respuesta (200 OK):**
```json
[
  {
    "id": "656f1a...",
    "nombre": "Hotel Paraíso",
    "ciudad": "Cancún",
    "estrellas": 5,
    "precioNoche": 150.0,
    "servicios": ["Piscina", "Wifi", "Desayuno"]
  },
  {
    "id": "656f1b...",
    "nombre": "Hotel Centro",
    "ciudad": "Madrid",
    "estrellas": 3,
    "precioNoche": 80.0,
    "servicios": ["Wifi"]
  }
]
```

#### Obtener hotel por ID
Obtiene los detalles de un hotel específico.

*   **Método**: `GET`
*   **URL**: `/hoteles/{id}`
*   **Autenticación**: No requerida (Pública)

**Ejemplo de Respuesta (200 OK):**
```json
{
  "id": "656f1a...",
  "nombre": "Hotel Paraíso",
  "ciudad": "Cancún",
  "estrellas": 5,
  "precioNoche": 150.0,
  "servicios": ["Piscina", "Wifi", "Desayuno"]
}
```

**Ejemplo de Error (404 Not Found):**
```json
{
  "error": "Hotel No Encontrado",
  "message": "Hotel no encontrado con ID: 12345",
  "errorCode": 404
}
```

#### Crear un nuevo hotel
Registra un nuevo hotel en el sistema.

*   **Método**: `POST`
*   **URL**: `/hoteles`
*   **Autenticación**: Requerida (ADMIN)

**Cuerpo de la petición (JSON):**
```json
{
  "nombre": "Gran Hotel",
  "ciudad": "Barcelona",
  "estrellas": 4,
  "precioNoche": 120.0,
  "servicios": ["Gimnasio", "Spa"]
}
```

**Ejemplo de Respuesta (200 OK):**
```json
{
  "id": "657a2c...",
  "nombre": "Gran Hotel",
  "ciudad": "Barcelona",
  "estrellas": 4,
  "precioNoche": 120.0,
  "servicios": ["Gimnasio", "Spa"]
}
```

#### Actualizar un hotel
Actualiza la información de un hotel existente.

*   **Método**: `PUT`
*   **URL**: `/hoteles/{id}`
*   **Autenticación**: Requerida (ADMIN)

**Cuerpo de la petición (JSON):**
```json
{
  "nombre": "Gran Hotel Renovado",
  "ciudad": "Barcelona",
  "estrellas": 5,
  "precioNoche": 180.0,
  "servicios": ["Gimnasio", "Spa", "Piscina"]
}
```

**Ejemplo de Respuesta (200 OK):**
```json
{
  "id": "657a2c...",
  "nombre": "Gran Hotel Renovado",
  "ciudad": "Barcelona",
  "estrellas": 5,
  "precioNoche": 180.0,
  "servicios": ["Gimnasio", "Spa", "Piscina"]
}
```

### 2. Reservas

#### Crear una reserva
Realiza una reserva en un hotel. El email del usuario se asigna automáticamente según el usuario autenticado.

*   **Método**: `POST`
*   **URL**: `/hoteles/reservas`
*   **Autenticación**: Requerida (Usuario autenticado)

**Cuerpo de la petición (JSON):**
```json
{
  "hotelId": "656f1a...",
  "fechaEntrada": "2023-12-01",
  "fechaSalida": "2023-12-10",
  "numeroPersonas": 2
}
```

**Ejemplo de Respuesta (200 OK):**
```json
{
  "id": "658b3d...",
  "hotelId": "656f1a...",
  "fechaEntrada": "2023-12-01",
  "fechaSalida": "2023-12-10",
  "numeroPersonas": 2,
  "usuarioEmail": "usuario@ejemplo.com"
}
```

**Nota:** Si el `hotelId` proporcionado no existe, la API devolverá un error 404.
