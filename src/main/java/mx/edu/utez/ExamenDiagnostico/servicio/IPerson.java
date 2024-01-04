package mx.edu.utez.ExamenDiagnostico.servicio;

import mx.edu.utez.ExamenDiagnostico.model.DTO.PersonDto;
import mx.edu.utez.ExamenDiagnostico.model.entity.PersonBean;

import java.util.List;

public interface IPerson {
    PersonBean save(PersonDto dtoPerson);
    PersonBean findById(Integer id);
    void delete(PersonBean persona);
    List<PersonBean> findAll();
}
