		
package com.example.demo.Init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.Repository.CiudadRepository;
import com.example.demo.Repository.RutaRepository;
import com.example.demo.Repository.JugadorRepository;
import com.example.demo.Model.Ciudad;
import com.example.demo.Model.Ruta;
import com.example.demo.Model.Jugador;

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

    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicializando la base de datos...");

        // Crear 100 ciudades con impuestos de 2 decimales
        List<Ciudad> ciudades = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Ciudad(
                        "Ciudad " + i, 
                        generarImpuestosAleatorios()
                ))
                .collect(Collectors.toList());

        ciudadRepository.saveAll(ciudades);
        System.out.println("Las 100 ciudades fueron correctamente");

        // Crear 30 rutas aleatorias entre ciudades existentes
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
                causaAtaque);

            ruta.setCiudadOrigen(ciudadOrigen);
            ruta.setCiudadDestino(ciudadDestino);
            rutaRepository.save(ruta);
        }
        System.out.println(" Las 30 rutas fueron generadas correctamente");

        // Crear los 10 jugadores con roles aleatorios
        String[] roles = {"Comerciante", "Caravanero", "Administrador"};
        List<Jugador> jugadores = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new Jugador(
                        "Jugador " + i,
                        roles[random.nextInt(roles.length)]))
                .collect(Collectors.toList());

        jugadorRepository.saveAll(jugadores);
        System.out.println("10 jugadores generados con roles aleatorios.");

        System.out.println("Inicialización de la base de datos completada.");
    }

    private Ciudad getRandomCiudad(List<Ciudad> ciudades) {
        return ciudades.get(random.nextInt(ciudades.size()));
    }

    private BigDecimal generarImpuestosAleatorios() {
        return BigDecimal.valueOf(random.nextDouble() * 10)
                         .setScale(2, RoundingMode.HALF_UP);
    }
}
