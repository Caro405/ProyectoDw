package com.example.demo.Init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Model.*;
import com.example.demo.Repository.*;

import java.util.*;
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
    private ServicioCiudadRepository servicioCiudadRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoCiudadRepository productoCiudadRepository;

    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Inicializando la base de datos...");

        // Crear 100 ciudades
        List<Ciudad> ciudades = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Ciudad("Ciudad " + i, generarImpuestosAleatorios()))
                .collect(Collectors.toList());
        ciudadRepository.saveAll(ciudades);
        System.out.println("100 ciudades creadas.");

        // Crear rutas (2 por ciudad)
        for (Ciudad ciudad : ciudades) {
            if ((ciudad.getRutasSalida() == null || ciudad.getRutasSalida().isEmpty()) &&
                (ciudad.getRutasLlegada() == null || ciudad.getRutasLlegada().isEmpty())) {

                Ciudad destino1 = getRandomCiudadDiferente(ciudades, ciudad);
                Ciudad destino2 = getRandomCiudadDiferente(ciudades, destino1);

                Ruta segura = new Ruta(random.nextInt(991) + 10, true, 0, null);
                segura.setCiudadOrigen(ciudad);
                segura.setCiudadDestino(destino1);
                rutaRepository.save(segura);

                Ruta insegura = new Ruta(random.nextInt(991) + 10, false, random.nextInt(101),
                        random.nextBoolean() ? "Bandidos" : "Desastre Natural");
                insegura.setCiudadOrigen(ciudad);
                insegura.setCiudadDestino(destino2);
                rutaRepository.save(insegura);

                System.out.println("Rutas creadas para ciudad: " + ciudad.getNombre());
            }
        }

        // Crear servicios base
        List<Servicio> serviciosBase = List.of(
                new Servicio("Reparar", generarPorcentaje()),
                new Servicio("Mejorar Capacidad", generarPorcentaje()),
                new Servicio("Mejorar Velocidad", generarPorcentaje()),
                new Servicio("Guardias", generarPorcentaje()),
                new Servicio("Seguro de Viaje", generarPorcentaje())
        );
        servicioRepository.saveAll(serviciosBase);
        System.out.println("5 servicios base creados.");

        // Asignar 2 servicios aleatorios por ciudad (ServicioCiudad)
        List<ServicioCiudad> servicioCiudades = new ArrayList<>();
        for (Ciudad ciudad : ciudades) {
            List<Servicio> seleccionados = getServiciosAleatorios(serviciosBase, 2);
            for (Servicio servicio : seleccionados) {
                ServicioCiudad sc = new ServicioCiudad();
                sc.setCiudad(ciudad);
                sc.setServicio(servicio);
                sc.setPrecio(random.nextInt(401) + 100); // 100 a 500

                ciudad.getServiciosCiudad().add(sc); // mantener relación bidireccional en memoria
                servicioCiudades.add(sc);
            }
        }
        servicioCiudadRepository.saveAll(servicioCiudades);
        System.out.println("Servicios asignados a ciudades: " + servicioCiudades.size());

        // Crear 50 productos
        List<Producto> productos = IntStream.rangeClosed(1, 50)
                .mapToObj(i -> new Producto("Producto " + i, getRandomCategoria(), generarPrecioBase(), generarFactor(), generarDemanda()))
                .collect(Collectors.toList());
        productoRepository.saveAll(productos);
        System.out.println("50 productos creados.");

        // Asignar 5 productos por ciudad (ProductoCiudad)
        List<ProductoCiudad> productosCiudad = new ArrayList<>();
        for (Ciudad ciudad : ciudades) {
            List<Producto> seleccionados = getProductosAleatorios(productos, 5);
            for (Producto producto : seleccionados) {
                try {
                    int factorDemanda = generarFactor();
                    int factorOferta = generarFactor();
                    int stock = random.nextInt(501) + 100;
                    int precioVenta = (int) Math.round(factorDemanda / (1.0 + stock));
                    if (precioVenta == 0) {
                        precioVenta = random.nextInt(401) + 100;
                    }

                    ProductoCiudad pc = new ProductoCiudad();
                    pc.setFactorDemanda(factorDemanda);
                    pc.setFactorOferta(factorOferta);
                    pc.setStock(stock);
                    pc.setPrecio(precioVenta);
                    pc.setProducto(producto);
                    pc.setCiudad(ciudad);

                    ciudad.getProductosCiudad().add(pc);
                    productosCiudad.add(productoCiudadRepository.save(pc));
                } catch (Exception e) {
                    System.err.println("Error guardando ProductoCiudad para ciudad " + ciudad.getNombre() + ": " + e.getMessage());
                }
            }
        }
        System.out.println("ProductoCiudad total guardados: " + productosCiudad.size());

        System.out.println("Inicialización completada.");
    }

    // Métodos auxiliares

    private Ciudad getRandomCiudadDiferente(List<Ciudad> ciudades, Ciudad excluida) {
        Ciudad ciudad;
        do {
            ciudad = ciudades.get(random.nextInt(ciudades.size()));
        } while (ciudad.equals(excluida));
        return ciudad;
    }

    private Producto.Categoria getRandomCategoria() {
        Producto.Categoria[] categorias = Producto.Categoria.values();
        return categorias[random.nextInt(categorias.length)];
    }

    private List<Producto> getProductosAleatorios(List<Producto> productos, int cantidad) {
        List<Producto> copia = new ArrayList<>(productos);
        Collections.shuffle(copia, random);
        return copia.subList(0, cantidad);
    }

    private List<Servicio> getServiciosAleatorios(List<Servicio> servicios, int cantidad) {
        List<Servicio> copia = new ArrayList<>(servicios);
        Collections.shuffle(copia, random);
        return copia.subList(0, cantidad);
    }

    private Integer generarImpuestosAleatorios() {
        return random.nextInt(951) + 50; // 50 a 1000
    }

    private Integer generarPrecioBase() {
        return random.nextInt(901) + 100; // 100 a 1000
    }

    private Integer generarFactor() {
        return random.nextInt(151) + 50; // 50 a 200
    }

    private Integer generarDemanda() {
        return random.nextInt(951) + 50; // 50 a 1000
    }

    private Integer generarPorcentaje() {
        return random.nextInt(81) + 20; // 20 a 100
    }
}
