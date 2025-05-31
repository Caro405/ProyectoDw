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

        // Crear 100 ciudades con impuestos aleatorios
        List<Ciudad> ciudades = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Ciudad(
                        "Ciudad " + i,
                        generarImpuestosAleatorios()
                ))
                .collect(Collectors.toList());
        ciudadRepository.saveAll(ciudades);
        System.out.println("100 ciudades creadas.");

        // Crear rutas (2 por ciudad) si no tiene rutas de salida o llegada
        for (Ciudad ciudad : ciudades) {
            if ((ciudad.getRutasSalida() == null || ciudad.getRutasSalida().isEmpty()) &&
                (ciudad.getRutasLlegada() == null || ciudad.getRutasLlegada().isEmpty())) {

                Ciudad ciudadDestino1 = getRandomCiudadDiferente(ciudades, ciudad);
                Ciudad ciudadDestino2 = getRandomCiudadDiferente(ciudades, ciudadDestino1);

                // Ruta segura
                Ruta rutaSegura = new Ruta(
                        random.nextInt(991) + 10,  // Distancia 10-1000
                        true,                       // segura
                        0,
                        null
                );
                rutaSegura.setCiudadOrigen(ciudad);
                rutaSegura.setCiudadDestino(ciudadDestino1);
                rutaRepository.save(rutaSegura);

                // Ruta insegura
                Ruta rutaInsegura = new Ruta(
                        random.nextInt(991) + 10,
                        false,
                        random.nextInt(101),  // daño 0-100
                        random.nextBoolean() ? "Bandidos" : "Desastre Natural"
                );
                rutaInsegura.setCiudadOrigen(ciudad);
                rutaInsegura.setCiudadDestino(ciudadDestino2);
                rutaRepository.save(rutaInsegura);

                System.out.println("Rutas creadas para ciudad: " + ciudad.getNombre());
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

        // Crear 50 productos con ciudad asignada y categorías permitidas
        List<Producto> productos = IntStream.rangeClosed(1, 50)
                .mapToObj(i -> new Producto(
                        "Producto " + i,
                        getRandomCategoria(),
                        generarPrecioBase(),
                        generarFactor(),
                        generarDemanda()
                ))
                .collect(Collectors.toList());
        productoRepository.saveAll(productos);
        System.out.println("50 productos creados con categorías permitidas.");

        System.out.println("Inicialización de la base de datos completada con éxito.");
    }

    // Método para obtener ciudad aleatoria distinta a la dada
    private Ciudad getRandomCiudadDiferente(List<Ciudad> ciudades, Ciudad excluida) {
        Ciudad ciudadRandom;
        do {
            ciudadRandom = getRandomCiudad(ciudades);
        } while (ciudadRandom.equals(excluida));
        return ciudadRandom;
    }

    private Ciudad getRandomCiudad(List<Ciudad> ciudades) {
        return ciudades.get(random.nextInt(ciudades.size()));
    }

    private Integer generarImpuestosAleatorios() {
        return random.nextInt(951) + 50; // entre 50 y 1000
    }

    private Producto.Categoria getRandomCategoria() {
        Producto.Categoria[] categorias = Producto.Categoria.values();
        return categorias[random.nextInt(categorias.length)];
    }

    private Integer generarPrecioBase() {
        return random.nextInt(901) + 100; // entre 100 y 1000
    }

    private Integer generarFactor() {
        return random.nextInt(151) + 50; // entre 50 y 200
    }

    private Integer generarDemanda() {
        return random.nextInt(951) + 50; // entre 50 y 1000
    }
}
