package com.rafael_test.ApiJavaRest.service.enderecoPessoa;

import com.rafael_test.ApiJavaRest.model.EnderecoPessoa;
import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.repository.EnderecoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnderecoPessoaServiceImpl implements EnderecoPessoaService {

    @Autowired
    private EnderecoPessoaRepository enderecoPessoaRepository;

    @Override
    public EnderecoPessoa salvarEnderecoPessoa(EnderecoPessoa enderecoPessoa) {
        return enderecoPessoaRepository.save(enderecoPessoa);
    }

    @Override
    public List<EnderecoPessoa> buscarEndereco(Long idPessoa) {
        return enderecoPessoaRepository.findAll();
    }

    @Override
    public EnderecoPessoa atualizarEnderecoPessoa(EnderecoPessoa enderecoPessoa) {
        return enderecoPessoaRepository.save(enderecoPessoa);
    }

    @Override
    public void deletarEnderecoPessoa(Long id) {
        enderecoPessoaRepository.deleteById(id);
    }
}
