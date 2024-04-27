package com.rafael_test.ApiJavaRest.repository;

import com.rafael_test.ApiJavaRest.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
