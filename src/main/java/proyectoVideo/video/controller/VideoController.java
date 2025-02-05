package proyectoVideo.video.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import proyectoVideo.video.domain.dto.video.DtoVideo;
import proyectoVideo.video.domain.model.Video;
import proyectoVideo.video.domain.service.ServiceVideo;

import java.util.List;

@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    private ServiceVideo serviceVideo;

    @PostMapping("crear")
    public ResponseEntity<Video> crear(@RequestBody DtoVideo dtoVideo, UriComponentsBuilder uriComponentsBuilder){
        return serviceVideo.crear(dtoVideo,uriComponentsBuilder);
    }

    @GetMapping("unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        return serviceVideo.unidad(id);
    }

    @GetMapping("mostrar")
    public ResponseEntity<List<Video>> mostrar(){
        return serviceVideo.mostrar();
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity borrar(@PathVariable Long id){
        return serviceVideo.borrar(id);
    }

    @GetMapping("videocategoria/{id}")
    public ResponseEntity videoCategoriaId(@PathVariable Long  id){
        return serviceVideo.videoPorCategoriaId(id);
    }
}
