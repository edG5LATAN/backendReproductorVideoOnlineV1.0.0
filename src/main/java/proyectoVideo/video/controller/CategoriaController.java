package proyectoVideo.video.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import proyectoVideo.video.domain.dto.categoria.DtoCategoria;
import proyectoVideo.video.domain.model.Categoria;
import proyectoVideo.video.domain.service.ServiceCategoria;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private ServiceCategoria serviceCategoria;

    @GetMapping("mostrar")
    public ResponseEntity<List<Categoria>> mostrar(){
        return serviceCategoria.mostrar();
    }

    @GetMapping("unidad/{id}")
    public ResponseEntity unidad(@PathVariable Long id){
        return serviceCategoria.unidad(id);
    }

    @PostMapping("crear")
    public ResponseEntity<Categoria> crear(@RequestBody DtoCategoria dtoCategoria, UriComponentsBuilder uriComponentsBuilder){
        return serviceCategoria.crear(dtoCategoria,uriComponentsBuilder);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity borrar(@PathVariable Long id){
        return serviceCategoria.borrar(id);
    }


}
