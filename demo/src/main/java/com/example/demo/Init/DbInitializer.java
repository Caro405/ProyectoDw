package com.example.demo.Init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.Repository.*;
import com.example.demo.Model.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class DbInitializer implements CommandLineRunner {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicializando la base de datos...");

        // Crear 100 ciudades
        List<Ciudad> ciudades = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Ciudad(
                        "Ciudad " + i,
                        generarImpuestosAleatorios()  
                ))
                .collect(Collectors.toList());

        ciudadRepository.saveAll(ciudades);
        System.out.println("100 ciudades creadas.");

        // Crear '0' rutas entre ciudades existentes
        for (Ciudad ciudad : ciudades) {
            // Verifica si la ciudad tiene rutas
            if (ciudad.getRutasSalida().isEmpty() && ciudad.getRutasLlegada().isEmpty()) {
                // Si no tiene rutas, crear dos rutas: una segura y otra insegura
                Ciudad ciudadDestino1 = getRandomCiudad(ciudades);
                Ciudad ciudadDestino2 = getRandomCiudad(ciudades);
                
                while (ciudadDestino1.equals(ciudadDestino2)) {
                    ciudadDestino2 = getRandomCiudad(ciudades); // Evitar que la ciudad destino sea la misma
                }

                // Crear una ruta segura
                Ruta rutaSegura = new Ruta(
                        random.nextInt(991) + 10,  // Distancia aleatoria entre 10 y 1000
                        true,                       // Ruta segura
                        0,                          // No hay ataque
                        null                        // No hay causa de ataque
                );
                rutaSegura.setCiudadOrigen(ciudad);
                rutaSegura.setCiudadDestino(ciudadDestino1);
                rutaRepository.save(rutaSegura);  // Guarda la ruta segura en el repositorio

                // Crear una ruta insegura
                Ruta rutaInsegura = new Ruta(
                        random.nextInt(991) + 10,  // Distancia aleatoria entre 10 y 1000
                        false,                      // Ruta insegura
                        random.nextInt(101),        // Daño aleatorio si no es segura
                        random.nextBoolean() ? "Bandidos" : "Desastre Natural"  // Causa de ataque aleatoria
                );
                rutaInsegura.setCiudadOrigen(ciudad);
                rutaInsegura.setCiudadDestino(ciudadDestino2);
                rutaRepository.save(rutaInsegura);  // Guarda la ruta insegura en el repositorio

                System.out.println("Se crearon rutas para la ciudad: " + ciudad.getNombre());
            }
        }

        // Crear 10 servicios con efectos específicos
        List<Servicio> servicios = List.of(
                new Servicio("Reparar", generarPrecioBase(), 100, getRandomCiudad(ciudades)),
                new Servicio("Mejorar Capacidad", generarPrecioBase(), 400, getRandomCiudad(ciudades)),
                new Servicio("Mejorar Velocidad", generarPrecioBase(), 50, getRandomCiudad(ciudades)),
                new Servicio("Guardias", generarPrecioBase(), 25, getRandomCiudad(ciudades)),
                new Servicio("Seguro de Viaje", generarPrecioBase(), 50, getRandomCiudad(ciudades)),
                new Servicio("Refugio Temporal", generarPrecioBase(), 30, getRandomCiudad(ciudades)),
                new Servicio("Rutas Alternativas", generarPrecioBase(), 20, getRandomCiudad(ciudades)),
                new Servicio("Reducción de Peajes", generarPrecioBase(), 15, getRandomCiudad(ciudades)),
                new Servicio("Negociación de Precios", generarPrecioBase(), 35, getRandomCiudad(ciudades)),
                new Servicio("Almacenamiento Extra", generarPrecioBase(), 300, getRandomCiudad(ciudades))
        );

        servicioRepository.saveAll(servicios);
        System.out.println("10 servicios creados.");

        // Crear 50 productos 
        List<Producto> productos = IntStream.rangeClosed(1, 50)
                .mapToObj(i -> new Producto(
                        "Producto " + i,
                        getRandomCategoria(),
                        generarPrecioBase(),
                        generarFactor(),
                        generarFactor(),
                        getRandomCiudad(ciudades)  // Asociar una ciudad aleatoria
                ))
                .collect(Collectors.toList());

        productoRepository.saveAll(productos);
        System.out.println("50 productos creados con categorías permitidas.");

        System.out.println("Inicialización de la base de datos completada con éxito.");
    }

    // Métodos auxiliares
    private Ciudad getRandomCiudad(List<Ciudad> ciudades) {
        return ciudades.get(random.nextInt(ciudades.size()));
    }

    private Integer generarImpuestosAleatorios() {
        return random.nextInt(951) + 50; // Genera un valor entre 50 y 1000
    }

    private Producto.Categoria getRandomCategoria() {
        Producto.Categoria[] categorias = Producto.Categoria.values();
        return categorias[random.nextInt(categorias.length)];
    }

    // Método para generar el precio base
    private Integer generarPrecioBase() {
        return random.nextInt(901) + 100; // Genera un valor entre 100 y 1000
    }

    // Método para generar un factor
    private Integer generarFactor() {
        return random.nextInt(151) + 50; // Factor entre 50 y 200
    }
}
