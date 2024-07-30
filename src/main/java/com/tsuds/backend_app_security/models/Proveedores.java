import javax.persistence.*;

@Entity
@Table(name = "Proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;

    private String nombre;
    private String ruc;
    private String telefono;
    private String pais;

    // Getters y Setters
}
