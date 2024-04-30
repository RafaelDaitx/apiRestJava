package com.rafael_test.ApiJavaRest.service.pessoa;

import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.repository.EnderecoRepository;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> buscarPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Optional<Pessoa> buscarPeloId(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
        return pessoaRepository.findById(id)
                .map(pessoaExistente -> {
                    pessoaExistente.setNomePessoa(pessoa.getNomePessoa());
                    pessoaExistente.setDataNascimento(pessoa.getDataNascimento());
                    return pessoaRepository.save(pessoaExistente);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com o ID: " + id));
    }

    @Override
    public void deletarPessoa(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        Pessoa pessoa = pessoaOptional.orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com o ID: " + id));
        pessoaRepository.delete(pessoa);
    }
}
