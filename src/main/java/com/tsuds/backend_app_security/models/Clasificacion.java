import javax.persistence.*;

@Entity
@Table(name = "Clasificacion")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClasificacion;

    private String grupo;

    // Getters y Setters
}
