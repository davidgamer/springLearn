package br.learn.springLearn.Controller;

import br.learn.springLearn.Service.CategoriaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findCategoria(@PathVariable Integer id) throws NotFoundException {
        return  ResponseEntity.ok().body(categoriaService.findCategoria(id));
    }

    @PostMapping
    public  ResponseEntity<?> insertCategoria (@RequestBody String categoria){
        categoriaService.createCategoria(categoria);
        return  ResponseEntity.ok().body("Categoria Criada com sucesso!");
    }
    @GetMapping
    public ResponseEntity<?> ListCategorias (){

        return ResponseEntity.ok().body(categoriaService.listCategorias());
    }
}
