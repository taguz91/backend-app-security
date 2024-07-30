import javax.persistence.*;

@Entity
@Table(name = "Tipo_Pago")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoPago;

    private String tipo;
    private String descrip;

    // Getters y Setters
}
