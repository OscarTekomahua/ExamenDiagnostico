package mx.edu.utez.ExamenDiagnostico.model.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonDto {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String curp;
}
