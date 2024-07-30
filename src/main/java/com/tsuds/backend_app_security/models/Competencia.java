import javax.persistence.*;

@Entity
@Table(name = "Competencia")
public class Competencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompetencias;

    private String nombre;
    private String descripcion;

    // Getters y Setters
}
