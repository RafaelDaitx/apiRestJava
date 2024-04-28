package com.rafael_test.ApiJavaRest.service.enderecoPessoa;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.repository.EnderecoPessoaRepository;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
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
    public Endereco atualizarEnderecoPessoa(Long id,Endereco endereco) {
        return enderecoPessoaRepository.findById(id)
                .map(enderecoExistente -> {
                    enderecoExistente.setLogradouro(endereco.getLogradouro());
                    enderecoExistente.setCep(endereco.getCep());
                    enderecoExistente.setNumero(endereco.getNumero());
                    enderecoExistente.setCidade(endereco.getCidade());
                    enderecoExistente.setEstado(endereco.getEstado());
                    enderecoExistente.setEnderecoPrincipal(endereco.isEnderecoPrincipal());
                    return enderecoPessoaRepository.save(enderecoExistente);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com o ID: " + id));
    }

    @Override
    public void deletarEnderecoPessoa(Long id) {
        Optional<Endereco> enderecoOptional = enderecoPessoaRepository.findById(id);
        Endereco endereco = enderecoOptional.orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com o ID: " + id));
        enderecoPessoaRepository.delete(endereco);
    }
}
