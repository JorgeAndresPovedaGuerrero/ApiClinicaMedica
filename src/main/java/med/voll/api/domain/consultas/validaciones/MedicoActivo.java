package med.voll.api.domain.consultas.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consultas.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoActivo implements ValidadorDeConsultas{
    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DatosAgendarConsulta datos){
        var medicoActivo = medicoRepository.findActivoById(datos.idMedico());

        if(!medicoActivo){
            throw new ValidationException("No se agendan citas a Medicos inactivos");
        }
    }

}
