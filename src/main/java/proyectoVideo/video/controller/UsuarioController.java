package proyectoVideo.video.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import proyectoVideo.video.domain.dto.usuario.DtoUsuario;
import proyectoVideo.video.domain.model.Usuario;
import proyectoVideo.video.domain.service.ServiceUsuario;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @PostMapping("login")
    public Boolean loguearse(@RequestBody DtoUsuario dtoUsuario){
        return serviceUsuario.login(dtoUsuario);
    }
    @GetMapping("mostrar")
    public ResponseEntity<List<Usuario>> mostrar(){
        return serviceUsuario.mostrar();
    }

    @GetMapping("unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        return serviceUsuario.unidad(id);
    }

    @PostMapping("crear")
    public ResponseEntity crear(@RequestBody DtoUsuario dtoUsuario, UriComponentsBuilder uriComponentsBuilder){
        return serviceUsuario.crear(dtoUsuario,uriComponentsBuilder);
    }

    @GetMapping("unidad/user/{usuario}")
    public ResponseEntity unidadUsuario(@PathVariable String usuario){
        return serviceUsuario.unidadUsuario(usuario);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity borrar(@PathVariable Long id){
        return serviceUsuario.borrar(id);
    }

    @GetMapping("traerTodosVideos/{usuario}")
    public ResponseEntity traerTodosVideos(@PathVariable String usuario){
        return serviceUsuario.traerTodoVideos(usuario);
    }
}
