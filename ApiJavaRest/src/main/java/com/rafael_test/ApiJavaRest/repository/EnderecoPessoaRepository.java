package com.rafael_test.ApiJavaRest.repository;

import com.rafael_test.ApiJavaRest.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoPessoaRepository extends JpaRepository <Endereco, Long> {
}
