package com.rafael_test.ApiJavaRest.Tests;

import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import com.rafael_test.ApiJavaRest.service.pessoa.PessoaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaTest {

    private com.rafael_test.ApiJavaRest.model.Pessoa pessoa;
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Before
    public void setUp() {
        pessoa = new com.rafael_test.ApiJavaRest.model.Pessoa();
        pessoa.setNomePessoa("Rafael Teste");
        pessoa.setDataNascimento(new Date());
    }

    @Test
    @Order(1)
    public void testSalvarPessoa() {
        com.rafael_test.ApiJavaRest.model.Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        assertNotNull(pessoaSalva);
        assertEquals("Rafael Teste", pessoaSalva.getNomePessoa());
        assertNotNull(pessoaSalva.getDataNascimento());
    }


    @Test
    @Order(2)
    public void testAtualizarPessoa() {
        String novoNome = "Rafael Atualizado";
        pessoa.setNomePessoa(novoNome);

        Pessoa pessoaAtualizada = pessoaService.atualizarPessoa(pessoa.getId(), pessoa);
        assertNotNull(pessoaAtualizada);
        assertEquals(novoNome, pessoaAtualizada.getNomePessoa());

        Pessoa pessoaNoBanco = pessoaRepository.findById(pessoa.getId()).orElse(null);
        assertNotNull(pessoaNoBanco);
        assertEquals(novoNome, pessoaNoBanco.getNomePessoa());
    }

    @Test
    @Order(3)
    public void buscar(){
        pessoaService.buscarPessoas();
    }

    @Test
    @Order(4)
    public void deletar(){
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        Long idPessoa = pessoaSalva.getId();

        pessoaRepository.deleteById(idPessoa);

        assertFalse(pessoaRepository.findById(idPessoa).isPresent());
    }


}
