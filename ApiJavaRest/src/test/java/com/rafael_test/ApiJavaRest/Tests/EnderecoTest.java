package com.rafael_test.ApiJavaRest.Tests;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.model.Pessoa;
import com.rafael_test.ApiJavaRest.repository.EnderecoRepository;
import com.rafael_test.ApiJavaRest.repository.PessoaRepository;
import com.rafael_test.ApiJavaRest.service.endereco.EnderecoService;
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
public class EnderecoTest {

    private com.rafael_test.ApiJavaRest.model.Pessoa pessoa;
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    Endereco endereco = new Endereco();
    @Before
    public void setUp() {
        pessoa = new com.rafael_test.ApiJavaRest.model.Pessoa();
        pessoa.setNomePessoa("Rafael Teste");
        pessoa.setDataNascimento(new Date());
    }

    @Test
    @Order(1)
    public void testSalvarEndereco() {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        endereco.setCep(9556000L);
        endereco.setCidade("Torres");
        endereco.setEstado("RS");
        endereco.setEnderecoPrincipal(true);
        endereco.setLogradouro("Rua do Teste");
        endereco.setNumero(26);
        endereco.setIdPessoa(pessoa);

        var enderecoSalvo = enderecoRepository.save(endereco);
        assertNotNull(enderecoSalvo);
        assertEquals("Torres", enderecoSalvo.getCidade());
        assertEquals("RS", enderecoSalvo.getEstado());
        assertEquals("Rua do Teste", enderecoSalvo.getLogradouro());
        assertEquals(26, enderecoSalvo.getNumero());
        assertNotNull(pessoaSalva.getDataNascimento());
    }


    @Test
    @Order(2)
    public void testAtualizarEndereco() {
        enderecoRepository.save(endereco);
        endereco.setCep(88701002L);
        endereco.setCidade("Tubarao");
        endereco.setEstado("SC");
        endereco.setEnderecoPrincipal(true);
        endereco.setLogradouro("Rua do Teste 2");
        endereco.setNumero(12);

        Endereco enderecoAtualizado = enderecoService.atualizarEnderecoPessoa(endereco.getId(), endereco);
        assertNotNull(enderecoAtualizado);
        assertEquals("Tubarao", enderecoAtualizado.getCidade());
        assertEquals("SC", enderecoAtualizado.getEstado());
        assertEquals("Rua do Teste 2", enderecoAtualizado.getLogradouro());
        assertEquals(12, enderecoAtualizado.getNumero());

       Endereco enderecoNoBanco = enderecoRepository.findById(endereco.getId()).orElse(null);
        assertNotNull(enderecoNoBanco);
        assertEquals("Tubarao", enderecoNoBanco.getCidade());


    }

    @Test
    @Order(3)
    public void buscarEndereco(){
        enderecoRepository.save(endereco);
        enderecoService.buscarEndereco(endereco.getId());
    }

    @Test
    @Order(4)
    public void deletar(){
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        Long id = enderecoSalvo.getId();

        enderecoRepository.deleteById(id);

        assertFalse(enderecoRepository.findById(id).isPresent());
    }


}
