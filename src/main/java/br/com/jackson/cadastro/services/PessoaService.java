package br.com.jackson.cadastro.services;

import br.com.jackson.cadastro.models.Pessoa;
import br.com.jackson.cadastro.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizar(Pessoa pessoa) {
        return  pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> listarUnico(Long id) {
        return pessoaRepository.findById(id);
    }

    public void delete(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }
}
