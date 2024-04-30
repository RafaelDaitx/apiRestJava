package com.rafael_test.ApiJavaRest.repository;

import com.rafael_test.ApiJavaRest.model.Endereco;
import com.rafael_test.ApiJavaRest.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaEnderecoRepository extends JpaRepository<Endereco, Long> {

}
