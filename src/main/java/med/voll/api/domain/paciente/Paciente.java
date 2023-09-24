package med.voll.api.domain.paciente;
import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.direccion.Direccion;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "pacientes")
@Entity(name = "Paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    @Column(name = "documento_identidad")
    private String documentoIdentidad;
    @Embedded
    private Direccion direccion;
    private Boolean activo;

    public Paciente(DatosRegistroPaciente datosRegistroPaciente){
        this.activo = true;
        this.nombre = datosRegistroPaciente.nombre();
        this.email = datosRegistroPaciente.email();
        this.telefono = datosRegistroPaciente.telefono();
        this.documentoIdentidad = datosRegistroPaciente.documentoIdentidad();
        this.direccion = new Direccion(datosRegistroPaciente.direccion());
    }

    public void actualizarDatos(DatosActualizarPaciente datosActualizarPaciente) {
        if(datosActualizarPaciente.nombre() != null){
            this.nombre = datosActualizarPaciente.nombre();
        }
        if(datosActualizarPaciente.documentoIdentidad() != null){
            this.documentoIdentidad=datosActualizarPaciente.documentoIdentidad();
        }
        if(datosActualizarPaciente.direccion() != null){
            this.direccion=direccion.actualizarDatos(datosActualizarPaciente.direccion());
        }
    }




}
