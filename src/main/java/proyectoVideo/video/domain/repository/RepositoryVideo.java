package proyectoVideo.video.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proyectoVideo.video.domain.model.Video;

import java.util.List;

public interface RepositoryVideo extends JpaRepository<Video,Long> {
    @Query(value = "select * from mypage.video where categoria_id=:id",nativeQuery = true)
    List<Video> buscarPorCategoriaId(Long id);
}
