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
                        generarImpuestosAleatorios()  // Llama al generador de impuestos aleatorios
                ))
                .collect(Collectors.toList());

        ciudadRepository.saveAll(ciudades);
        System.out.println("100 ciudades creadas.");

        // Crear 30 rutas entre ciudades existentes
        for (int i = 0; i < 30; i++) {
            Ciudad ciudadOrigen = getRandomCiudad(ciudades);
            Ciudad ciudadDestino = getRandomCiudad(ciudades);

            // Evitar rutas de una ciudad a sí misma
            while (ciudadOrigen.equals(ciudadDestino)) {
                ciudadDestino = getRandomCiudad(ciudades);
            }

            boolean esSegura = random.nextBoolean();
            String causaAtaque = esSegura ? null : (random.nextBoolean() ? "Bandidos" : "Desastre Natural");

            Ruta ruta = new Ruta(
                    random.nextInt(991) + 10,  // Distancia aleatoria entre 10 y 1000
                    esSegura,                    // Ruta segura o no
                    esSegura ? 0 : random.nextInt(101), // Daño aleatorio si no es segura
                    causaAtaque                  // Causa del ataque si no es segura
            );

            // Asocia las ciudades a la ruta
            ruta.setCiudadOrigen(ciudadOrigen);
            ruta.setCiudadDestino(ciudadDestino);
            rutaRepository.save(ruta);  // Guarda la ruta en el repositorio
        }
        System.out.println("30 rutas generadas.");

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
