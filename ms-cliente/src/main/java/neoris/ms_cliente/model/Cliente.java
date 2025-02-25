package neoris.ms_cliente.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cliente")
public class Cliente extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clienteId;
    private String contrasena;
    private boolean estado;
}
