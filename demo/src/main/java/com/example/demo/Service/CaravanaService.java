@Service
public class CaravanaService {

    @Autowired
    private CaravanaMapper caravanaMapper;  // Inyección de CaravanaMapper

    @Autowired
    private InventarioMapper inventarioMapper;  // Inyección de InventarioMapper

    @Autowired
    private CaravanaRepository caravanaRepository;

    public CaravanaDTO createCaravana(CaravanaDTO caravanaDTO) {
        // Convierte CaravanaDTO a Caravana
        Caravana caravana = caravanaMapper.toEntity(caravanaDTO);

        // Crear el inventario relacionado
        Inventario inventario = inventarioMapper.toEntity(caravanaDTO.getInventarioDTO());
        caravana.setInventario(inventario);

        // Guardar la caravana en el repositorio
        caravana = caravanaRepository.save(caravana);

        // Devuelve el CaravanaDTO mapeado
        return caravanaMapper.toDTO(caravana);
    }
}
