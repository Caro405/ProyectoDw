package com.example.demo.Init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.Repository.*;
import com.example.demo.Model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private JugadorRepository jugadorRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicializando la base de datos...");

        //  Crear 100 ciudades 
        List<Ciudad> ciudades = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Ciudad(
                        "Ciudad " + i,
                        generarImpuestosAleatorios()
                ))
                .collect(Collectors.toList());

        ciudadRepository.saveAll(ciudades);
        System.out.println(" 100 ciudades creadas.");

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
                    random.nextInt(991) + 10,  
                    esSegura,                   
                    esSegura ? 0 : random.nextInt(101), 
                    causaAtaque                 
            );

            ruta.setCiudadOrigen(ciudadOrigen);
            ruta.setCiudadDestino(ciudadDestino);
            rutaRepository.save(ruta);
        }
        System.out.println(" 30 rutas generadas.");

        // Crear 10 jugadores con roles aleatorios
        List<Jugador> jugadores = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Jugador(
                        "Jugador " + i,
                        getRandomRol()
                ))
                .collect(Collectors.toList());

        jugadorRepository.saveAll(jugadores);
        System.out.println("10 jugadores creados.");

        // 🔹 Crear 10 servicios con efectos específicos
        List<Servicio> servicios = List.of(
                new Servicio(null, "Reparar", generarPrecioBase(), 100, getRandomCiudad(ciudades)),
                new Servicio(null, "Mejorar Capacidad", generarPrecioBase(), 400, getRandomCiudad(ciudades)),
                new Servicio(null, "Mejorar Velocidad", generarPrecioBase(), 50, getRandomCiudad(ciudades)),
                new Servicio(null, "Guardias", generarPrecioBase(), 25, getRandomCiudad(ciudades)),
                new Servicio(null, "Seguro de Viaje", generarPrecioBase(), 50, getRandomCiudad(ciudades)),
                new Servicio(null, "Refugio Temporal", generarPrecioBase(), 30, getRandomCiudad(ciudades)),
                new Servicio(null, "Rutas Alternativas", generarPrecioBase(), 20, getRandomCiudad(ciudades)),
                new Servicio(null, "Reducción de Peajes", generarPrecioBase(), 15, getRandomCiudad(ciudades)),
                new Servicio(null, "Negociación de Precios", generarPrecioBase(), 35, getRandomCiudad(ciudades)),
                new Servicio(null, "Almacenamiento Extra", generarPrecioBase(), 300, getRandomCiudad(ciudades))
        );

        servicioRepository.saveAll(servicios);
        System.out.println(" 10 servicios creados.");

        // 🔹 Crear 50 productos con categorías restringidas
        List<Producto> productos = IntStream.rangeClosed(1, 50)
                .mapToObj(i -> new Producto(
                        "Producto " + i,
                        getRandomCategoria(),
                        generarPrecioBase(),
                        generarFactor(),
                        generarFactor(),
                        getRandomCiudad(ciudades)
                ))
                .collect(Collectors.toList());

        productoRepository.saveAll(productos);
        System.out.println(" 50 productos creados con categorías permitidas.");

        System.out.println(" Inicialización de la base de datos completada con éxito. 🚀");
    }

    // 🔹 Métodos auxiliares
    private Ciudad getRandomCiudad(List<Ciudad> ciudades) {
        return ciudades.get(random.nextInt(ciudades.size()));
    }

    private BigDecimal generarImpuestosAleatorios() {
        return BigDecimal.valueOf(random.nextDouble() * 10)
                         .setScale(2, RoundingMode.HALF_UP);
    }

    private String getRandomRol() {
        String[] roles = {"Comerciante", "Caravanero", "Administrador"};
        return roles[random.nextInt(roles.length)];
    }

    private Producto.Categoria getRandomCategoria() {
        Producto.Categoria[] categorias = Producto.Categoria.values();
        return categorias[random.nextInt(categorias.length)];
    }

    private double generarPrecioBase() {
        return BigDecimal.valueOf(100 + random.nextDouble() * 900) 
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private double generarFactor() {
        return BigDecimal.valueOf(0.5 + random.nextDouble() * 1.5) // Factor entre 0.5 y 2.0
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
