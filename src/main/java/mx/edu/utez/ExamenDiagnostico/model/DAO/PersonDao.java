package mx.edu.utez.ExamenDiagnostico.model.DAO;

import mx.edu.utez.ExamenDiagnostico.model.entity.PersonBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<PersonBean, Integer> {
}
