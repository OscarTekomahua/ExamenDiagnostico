package mx.edu.utez.ExamenDiagnostico.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.ExamenDiagnostico.model.DTO.PersonDto;
import mx.edu.utez.ExamenDiagnostico.model.entity.PersonBean;
import mx.edu.utez.ExamenDiagnostico.servicio.impl.ImplPerson;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("api/examendiag/persona")
public class PersonController {
    private final ImplPerson servicioPersona;

    @PostMapping("/create/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public PersonDto create(@RequestBody PersonDto dtoPerson) {
        PersonBean personaSave = servicioPersona.save(dtoPerson);

        return PersonDto.builder().id(personaSave.getIdPersona()).nombre(personaSave.getNombrePersona())
                .apellidos(personaSave.getApellidosPersona()).curp(personaSave.getCurp())
                .fechaNacimiento(personaSave.getFechaNac()).build();
    }

    @PutMapping("/update/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> update(@RequestBody PersonDto dtoPerson) {
        Map<String, Object> response = new HashMap<>();

        try {
            PersonBean updatePerson = servicioPersona.save(dtoPerson);
            return new ResponseEntity<>(updatePerson, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("msj", "Error al actualizar la persona");
            response.put("Persona", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            PersonBean findPerson = servicioPersona.findById(id);
            if (findPerson != null) {
                return new ResponseEntity<>(findPerson, HttpStatus.OK);
            } else {
                response.put("msj", "Error al encontrar la persona");
                response.put("Persona", null);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (DataAccessException e) {
            response.put("msj", "Error al encontrar la persona");
            response.put("Persona", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> getPersonas() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<PersonBean> personas = servicioPersona.findAll();
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("msj", "Error al encontrar las personas");
            response.put("Persona", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            PersonBean personaDelete = servicioPersona.findById(id);
            servicioPersona.delete(personaDelete);
            return new ResponseEntity<>(personaDelete, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("msj", "Error al eliminar la persona");
            response.put("Persona", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
