package br.learn.springLearn.Service;

import br.learn.springLearn.Entity.Categoria;
import br.learn.springLearn.Repository.CategoriaRepository;
import br.springLearn.Exception.ObjectNotFoundException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria createCategoria(String nome){
        Categoria c = new Categoria(null, nome);
        c.setNome(nome);
        return this.categoriaRepository.save(c);
    }
    public Categoria findCategoria(Integer id) throws ObjectNotFoundException {
        return this.categoriaRepository.findById(id).orElseThrow(
                ()-> new ObjectNotFoundException("Categoria"+ Categoria.class.getName()+ " não encontrada"));
    }
    public void deleteCategoria(Integer id) throws ObjectNotFoundException {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(
                ()-> new ObjectNotFoundException("Categoria não encontrada"));
        this.categoriaRepository.delete(categoria);
    }
    public List<Categoria> listCategorias(){
        return this.categoriaRepository.findAll();
    }

}
