package med.voll.api.domain.consultas.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConCOnsulta implements ValidadorDeConsultas{
    @Autowired
    private ConsultaRepository consultaRepository;


    public void validar(DatosAgendarConsulta datos){

        if(datos.idMedico()==null){
            return;
        }

        var medicoConConsulta = consultaRepository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());

        if(medicoConConsulta){
            throw new ValidationException("Este medico ya tiene cita asignada en esa hora");
        }


    }
}
