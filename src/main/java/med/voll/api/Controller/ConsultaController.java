package med.voll.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consultas.AgendaConsultaService;
import med.voll.api.domain.consultas.DatosDetalleConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import med.voll.api.domain.consultas.DatosAgendarConsulta;

@RestController
@ResponseBody
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private AgendaConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos){
        service.agendar(datos);
        return ResponseEntity.ok(new DatosDetalleConsulta(null, null, null, null));
    }


}
