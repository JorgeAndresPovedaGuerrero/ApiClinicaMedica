package med.voll.api.domain.consultas.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConCOnsulta implements  ValidadorDeConsultas{
    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosAgendarConsulta datos) {
        if(datos.idMedico()==null)
            return;

        var medicoConConsulta= repository.existsByMedicoIdAndFecha(datos.idMedico(),datos.fecha());
        if(medicoConConsulta){
            throw new ValidationException("este medico ya tiene una consulta en ese horario");
        }
    }
}
