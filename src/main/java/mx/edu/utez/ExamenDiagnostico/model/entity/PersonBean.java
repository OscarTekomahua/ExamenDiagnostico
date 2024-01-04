package mx.edu.utez.ExamenDiagnostico.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "personas")
public class PersonBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idPersona;
    @Column(name = "nombre", nullable = false)
    private String nombrePersona;
    @Column(name = "apellidos", nullable = false)
    private String apellidosPersona;
    @Column(name = "fecha_nacimiento", nullable = false)
    private String fechaNac;
    @Column(name = "curp", nullable = false)
    private String curp;
}
