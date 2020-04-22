package com.algaworks.algamoneyapi.resource;

import com.algaworks.algamoneyapi.event.RecursoCriadoEvent;
import com.algaworks.algamoneyapi.model.Categoria;
import com.algaworks.algamoneyapi.repository.CategoriaRepository;
import com.algaworks.algamoneyapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


//Essa classe expõe tudo que está relacionado a categoria, é um controlador REST!

@RestController //É um controlador REST que recebe requisições (GET, POST, PUT, DELETE)
//Isso é o retorno facilitado evitando anotações extras nos métodos utilizados, como converter os arquivos para json

@RequestMapping("/categorias") //Serve para criar um mapeamento da requisição criando uma rota de acesso

public class CategoriaResource {

    @Autowired
    //Como é uma interface utilizamos o @Autowired para o spring achar uma forma de implementação para categoriaRepository
    private CategoriaRepository categoriaRepository; /*Instanciamento da interface categoriaRepository onde estão nossos
    métodos do springDataJpa a partir do JpaRepository*/

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
    //Quando queremos buscar algo em nossa tabela(ler informações) utilizamos o verbo ""Get" seguido de Mapping (mapeamento do GET para url /categorias)
    public List<Categoria> list() { //<categoria> list() {método} para listar os dados de categorias
        return categoriaRepository.findAll(); //findALL vai buscar todos os dados dentro de categoria os listando utilizando os métodos dentro de categoriaRepository
    }

    @GetMapping("/{codigo}") //Método de busca por individual por ID
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
    public ResponseEntity buscarPeloCodigo(@PathVariable Long codigo) {
        Optional categoria = this.categoriaRepository.findById(codigo);
        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build(); //".isPresent" funciona apenas com o Optional
    }
//    Método de busca da lista e retorno retorno do status do code utilizando o responseEntity, neste caso não é certo usar dessa maneira, mas está aqui apenas para teste!
//    Comente o método GetMapping acima, abaixo e descomente este para uso.
//    @GetMapping
//    public ResponseEntity<?> list(){ //ResponseEntity é uma entidade de resposta para escolher uma resposta no status code, no caso de tipo indefinido <?>
//        List<Categoria> categorias = categoriaRepository.findAll(); //Instanciando list<Categoria> para "categorias" e recebendo os dados de categoriaRepository.findALL()
//        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.notFound().build(); /*equação ternária se categorias não estiver retorno lista
//        categorias com status ok (200), caso ela esteja vazia retorno apenas o status não encontrado(404), o ".build()" serve para gerar um response entity*/

//    }
//    Método de busca da lista e retorno retorno do status do code utilizando o responseEntity, neste caso não é certo usar dessa maneira, mas está aqui apenas para teste!
//    Comente os métodos GetMapping acima  e descomente este para uso.
//    @GetMapping
//    public ResponseEntity<?> list(){ //ResponseEntity é uma entidade de resposta para escolher uma resposta no status code, no caso de tipo indefinido <?>
//        List<Categoria> categorias = categoriaRepository.findAll(); //Instanciando list<Categoria> para "categorias" e recebendo os dados de categoriaRepository.findALL()
//        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build(); /*equação ternária se categorias não estiver retorno lista
//        categorias com status ok (200), caso ela esteja vazia retorno apenas o status sem conteúdo(204), o ".build()" serve para gerar um response entity*/

//    }

    @PostMapping
    //Quando queremos inserir uma nova linha na tabela utilizando o verbo "Post" seguido de Mapping (mapeamento do POST para url /categorias)
    //@ResponseStatus(HttpStatus.CREATED) //Utilizamos essa notação para quando terminar a utilização desse método retornar o status code "201 CREATED", avisando que deu tudo certo
    // Utilizar apenas se não tiver um ResponseEntity
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {/*Create() para criar uma categoria e instanciar, utilizando o @RequestBody para pegar a propriedade "nome"
        no postman na hora de inserir a identificando com o atributo "nome" da classe Categoria*/

        Categoria categoriaSalva = categoriaRepository.save(categoria);/*Para salvar utilizamos o .save(), dentro do paranteses colocar a instancia utilizada, no caso "categoria"
        //lembrando que utilizamos o categoriaRepository onde estão nossos métodos utilizados para salvar*/

//        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
//                .buildAndExpand(categoriaSalva.getCodigo()).toUri(); //Método utilizado para adicionar nosso caminho "locale" para cada ID

        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    //utilizando o verbo Delete para deletar dados da tabela
    @DeleteMapping("/{codigo}")
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCategoria(@PathVariable Long codigo) {
        this.categoriaRepository.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria) {
        Categoria categoriaSalva = categoriaService.atualizar(codigo, categoria);
        return ResponseEntity.ok(categoriaSalva);
    }
}