package com.rafael_test.ApiJavaRest.service.pessoa;

import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

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
        pessoaRepository.deleteById(id);
    }
}
