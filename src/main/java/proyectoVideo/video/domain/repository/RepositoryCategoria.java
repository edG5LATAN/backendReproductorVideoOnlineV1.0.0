package proyectoVideo.video.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyectoVideo.video.domain.model.Categoria;

public interface RepositoryCategoria extends JpaRepository<Categoria,Long> {
    Categoria findByNombre(String nombre);
}
