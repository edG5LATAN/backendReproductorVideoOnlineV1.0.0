package proyectoVideo.video.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import proyectoVideo.video.domain.dto.categoria.DtoCategoria;
import proyectoVideo.video.domain.model.Categoria;
import proyectoVideo.video.domain.repository.RepositoryCategoria;
import proyectoVideo.video.domain.repository.RepositoryUsuario;

import java.net.URI;
import java.util.List;

@Service
public class ServiceCategoria {

    @Autowired
    private RepositoryCategoria repositoryCategoria;
    @Autowired
    private RepositoryUsuario repositoryUsuario;

    public ResponseEntity unidad(Long id) {
       var categoria= repositoryCategoria.findById(id);
       if (!categoria.isPresent()){
          return ResponseEntity.ok("no existe categoria");
       }else {
           return ResponseEntity.ok(categoria);
       }
    }

    public ResponseEntity<List<Categoria>> mostrar() {
       return ResponseEntity.ok(repositoryCategoria.findAll());
    }

    public ResponseEntity<Categoria> crear(DtoCategoria dtoCategoria, UriComponentsBuilder uriComponentsBuilder) {
        var usuario=repositoryUsuario.findByUser(dtoCategoria.usuario());
        if(usuario==null){
            return ResponseEntity.unprocessableEntity().build();
        }else {
            var categori= repositoryCategoria.findByNombre(dtoCategoria.nombre());
            if(categori==null){
                var newCategoria= repositoryCategoria.save(new Categoria(dtoCategoria,usuario));
                URI url= uriComponentsBuilder.path("/categoria/unidad/{id}").buildAndExpand(newCategoria.getId_categoria()).toUri();
                return ResponseEntity.created(url).body(newCategoria);
            }else {
                return ResponseEntity.unprocessableEntity().build();
            }
        }
    }

    public ResponseEntity borrar(Long id) {
        var categor= repositoryCategoria.getReferenceById(id);
        if(categor==null){
            return ResponseEntity.ok("categoria no existe");
        }else {
            repositoryCategoria.delete(categor);
            return ResponseEntity.noContent().build();
        }
    }
}
