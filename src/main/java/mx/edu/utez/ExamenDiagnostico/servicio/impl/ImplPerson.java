package mx.edu.utez.ExamenDiagnostico.servicio.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.ExamenDiagnostico.model.DAO.PersonDao;
import mx.edu.utez.ExamenDiagnostico.model.DTO.PersonDto;
import mx.edu.utez.ExamenDiagnostico.model.entity.PersonBean;
import mx.edu.utez.ExamenDiagnostico.servicio.IPerson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplPerson implements IPerson {
    private final PersonDao daoPersona;

    @Transactional
    @Override
    public PersonBean save(PersonDto dtoPerson) {
        PersonBean persona = PersonBean.builder().idPersona(dtoPerson.getId())
                .nombrePersona(dtoPerson.getNombre()).apellidosPersona(dtoPerson.getApellidos())
                .fechaNac(dtoPerson.getFechaNacimiento()).curp(dtoPerson.getCurp()).build();
        return daoPersona.save(persona);
    }

    @Transactional(readOnly = true)
    @Override
    public PersonBean findById(Integer id) {
        return daoPersona.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(PersonBean persona) {
        daoPersona.delete(persona);
    }

    @Override
    public List<PersonBean> findAll() {
        return (List<PersonBean>) daoPersona.findAll();
    }
}
