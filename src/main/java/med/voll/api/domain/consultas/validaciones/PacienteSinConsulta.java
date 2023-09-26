package med.voll.api.domain.consultas.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteSinConsulta implements ValidadorDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    public void validar(DatosAgendarConsulta datos){
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);

        var pacienteConsulta = consultaRepository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);

        if(pacienteConsulta){
            throw new ValidationException("No es posible asignar dos consultas el mismo día");
        }

    }
}
