package neoris.ms_cuenta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
