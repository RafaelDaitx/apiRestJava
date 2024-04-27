package com.rafael_test.ApiJavaRest.repository;

import com.rafael_test.ApiJavaRest.model.EnderecoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoPessoaRepository extends JpaRepository <EnderecoPessoa, Long> {
}
