package com.rafael_test.ApiJavaRest.service.enderecoPessoa;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.repository.EnderecoPessoaRepository;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EnderecoPessoaServiceImpl implements EnderecoPessoaService {

    @Autowired
    private EnderecoPessoaRepository enderecoPessoaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Endereco salvarEnderecoPessoa(Long idPessoa, Endereco endereco) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var enderecoPessoa = new Endereco(
                pessoa,
                endereco.getLogradouro(),
                endereco.getCep(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.isEnderecoPrincipal()
        );
        return enderecoPessoaRepository.save(enderecoPessoa);
    }

    @Override
    public Optional<Endereco> buscarEndereco(Long idPessoa) {
        return enderecoPessoaRepository.findById(idPessoa);
    }

    @Override
    public Optional<Pessoa> buscarEnderecoPessoa(Long idPessoa) {
        return pessoaRepository.findById(idPessoa);
    }

    @Override
    public Endereco atualizarEnderecoPessoa(Endereco endereco) {
        return enderecoPessoaRepository.save(endereco);
    }

    @Override
    public void deletarEnderecoPessoa(Long id) {
        enderecoPessoaRepository.deleteById(id);
    }
}
