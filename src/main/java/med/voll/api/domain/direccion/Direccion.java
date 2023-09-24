package med.voll.api.domain.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String distrito;
    private String ciudad;

    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.ciudad=datosDireccion.ciudad();
        this.complemento= datosDireccion.complemento();
        this.distrito= datosDireccion.distrito();
        this.numero=datosDireccion.numero();
    }

    public Direccion actualizarDatos(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.ciudad=datosDireccion.ciudad();
        this.complemento= datosDireccion.complemento();
        this.distrito= datosDireccion.distrito();
        this.numero=datosDireccion.numero();
        return this;
    }
}
