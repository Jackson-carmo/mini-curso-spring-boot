package br.com.jackson.cadastro.controller;

import br.com.jackson.cadastro.models.Pessoa;
import br.com.jackson.cadastro.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService  pessoaService;

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> listarUnico(@PathVariable(value = "id") Long id) {
        Optional<Pessoa> optionalPessoa = pessoaService.listarUnico(id);

        return ResponseEntity.status(HttpStatus.OK).body(optionalPessoa.get());
    }

    @PutMapping
    public Pessoa atualizar(@RequestBody Pessoa pessoa) {
        return pessoaService.atualizar(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable(value = "id") Long id){
        Optional<Pessoa> optionalPessoa = pessoaService.listarUnico(id);
        pessoaService.delete(optionalPessoa.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa removida com sucesso!.");

}
}
