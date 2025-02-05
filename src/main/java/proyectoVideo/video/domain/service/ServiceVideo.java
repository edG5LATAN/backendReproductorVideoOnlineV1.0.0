package proyectoVideo.video.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import proyectoVideo.video.domain.dto.video.DtoVideo;
import proyectoVideo.video.domain.model.Video;
import proyectoVideo.video.domain.repository.RepositoryCategoria;
import proyectoVideo.video.domain.repository.RepositoryUsuario;
import proyectoVideo.video.domain.repository.RepositoryVideo;

import java.util.List;

@Service
public class ServiceVideo {

    @Autowired
    private RepositoryCategoria repositoryCategoria;
    @Autowired
    private RepositoryVideo repositoryVideo;

    public ResponseEntity borrar(Long id) {
      var video= repositoryVideo.getReferenceById(id);
      if(video==null){
          return ResponseEntity.ok("este video no se encuentra");
      }else {
          repositoryVideo.delete(video);
          return ResponseEntity.noContent().build();
      }
    }

    public ResponseEntity<List<Video>> mostrar() {
        var videos= repositoryVideo.findAll();
        return ResponseEntity.ok(videos);
    }

    public ResponseEntity<Video> crear(DtoVideo dtoVideo, UriComponentsBuilder uriComponentsBuilder) {
        var categori= repositoryCategoria.findByNombre(dtoVideo.categoria());
        if(categori!=null){
            var video=repositoryVideo.save(new Video(dtoVideo,categori));
            return ResponseEntity.ok(video);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    public ResponseEntity unidad(Long id) {
        var video= repositoryVideo.findById(id);
        if(video.isPresent()){
            return ResponseEntity.ok(video);
        }else {
            return ResponseEntity.ok("no se encontro video");
        }
    }

    public ResponseEntity videoPorCategoriaId(Long id) {
        var videos= repositoryVideo.buscarPorCategoriaId(id);
        if(videos==null){
            return ResponseEntity.ok("categoira no existe");
        }else {
            return ResponseEntity.ok(videos);
        }
    }
}
