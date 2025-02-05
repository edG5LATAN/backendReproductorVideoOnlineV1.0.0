package proyectoVideo.video.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyectoVideo.video.domain.dto.usuario.DtoUsuario;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String user;
    private String clave;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Categoria> categorias = new ArrayList<>();

    public Usuario(DtoUsuario dtoUsuario) {
        this.user= dtoUsuario.usuario();
        this.clave= dtoUsuario.clave();
    }
}
