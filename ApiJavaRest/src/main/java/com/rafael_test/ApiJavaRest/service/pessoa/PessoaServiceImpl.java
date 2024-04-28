package com.rafael_test.ApiJavaRest.service.pessoa;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.repository.EnderecoPessoaRepository;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoPessoaRepository enderecoPessoaRepository;

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
    public Pessoa atualizarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void deletarPessoa(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        Pessoa pessoa = pessoaOptional.orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com o ID: " + id));
        pessoaRepository.delete(pessoa);
    }
}
