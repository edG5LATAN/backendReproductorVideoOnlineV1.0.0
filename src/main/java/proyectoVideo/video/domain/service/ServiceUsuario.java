package proyectoVideo.video.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import proyectoVideo.video.domain.dto.usuario.DtoUsuario;
import proyectoVideo.video.domain.model.Usuario;
import proyectoVideo.video.domain.repository.RepositoryUsuario;

import java.net.URI;
import java.util.List;

@Service
public class ServiceUsuario {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    public ResponseEntity<List<Usuario>> mostrar() {
       var usuarios= repositoryUsuario.findAll();
       return ResponseEntity.ok(usuarios);
    }


    public ResponseEntity crear(DtoUsuario dtoUsuario, UriComponentsBuilder uriComponentsBuilder) {
         var usuario= repositoryUsuario.findByUser(dtoUsuario.usuario());
         if(usuario!=null){
             return ResponseEntity.unprocessableEntity().build();
         }else {
            var newUsuario= repositoryUsuario.save(new Usuario(dtoUsuario));
             URI url= uriComponentsBuilder.path("/usuario/unidad/{id}").buildAndExpand(newUsuario.getId_usuario()).toUri();
            return ResponseEntity.created(url).body(newUsuario);
         }
    }

    public ResponseEntity borrar(Long id) {
        var usuario= repositoryUsuario.getReferenceById(id);
        if(usuario==null){
            return ResponseEntity.ok("usuario no existe");
        }else {
            repositoryUsuario.delete(usuario);
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity unidad(Long id) {
        var unidad= repositoryUsuario.findById(id);
        if(!unidad.isPresent()){
            return ResponseEntity.ok("no existe este usuario");
        }else {
            return ResponseEntity.ok(unidad);
        }
    }

    public Boolean login(DtoUsuario dtoUsuario) {
        var usuario= repositoryUsuario.findByUser(dtoUsuario.usuario());
        var login=verificar(usuario,dtoUsuario);
        return login;
    }

    public Boolean verificar(Usuario usuario,DtoUsuario dtoUsuario){
        if(usuario!=null && usuario.getClave().equals(dtoUsuario.clave())){
            return true;
        }else {
            return false;
        }
    }

    public ResponseEntity unidadUsuario(String usuario) {
        var user= repositoryUsuario.findByUser(usuario);
        if(user==null){
            return ResponseEntity.ok("usuario no existe");
        }else {
            return ResponseEntity.ok(user);
        }
    }

    public ResponseEntity traerTodoVideos(String usuario) {
        var userNew = repositoryUsuario.findByUser(usuario);
        if(userNew==null){
            return ResponseEntity.ok("no se encontro este usuario");
        }else {
            var videos=repositoryUsuario.busquedaPorUsuario(usuario);
            return ResponseEntity.ok(videos);
        }
    }
}
