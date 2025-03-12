package com.example.demo.Init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.Repository.CiudadRepository;
import com.example.demo.Repository.RutaRepository;
import com.example.demo.Model.Ciudad;
import com.example.demo.Model.Ruta;

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
        System.out.println("100 ciudades creadas con impuestos ajustados a 2 decimales.");

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
                random.nextInt(991) + 10,  // 🔹 Distancia entre 10 y 1000
                esSegura,                   // 🔹 Definir si es segura
                esSegura ? 0 : random.nextInt(101), // 🔹 Si es segura, ataque = 0
                causaAtaque                  // 🔹 Si es segura, causaAtaque = null
            );

            ruta.setCiudadOrigen(ciudadOrigen);
            ruta.setCiudadDestino(ciudadDestino);
            rutaRepository.save(ruta);
        }

        System.out.println("30 rutas generadas con distancias y ataques enteros.");
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
