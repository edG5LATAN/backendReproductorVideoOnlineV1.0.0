package proyectoVideo.video.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proyectoVideo.video.domain.model.Usuario;
import proyectoVideo.video.domain.model.Video;

import java.util.List;
import java.util.Map;


public interface RepositoryUsuario extends JpaRepository<Usuario,Long> {
    Usuario findByUser(String usuario);

    @Query(value = "SELECT v.id_video, v.titulo, v.imagen, v.video, v.detalles, c.id_categoria, c.nombre AS categoria\n" +
            "FROM video v\n" +
            "JOIN categoria c ON v.categoria_id = c.id_categoria\n" +
            "JOIN usuario u ON c.usuario_id = u.id_usuario\n" +
            "WHERE u.user = :usuario",nativeQuery = true)
    List<Map<String,Object>> busquedaPorUsuario(String usuario);

}
