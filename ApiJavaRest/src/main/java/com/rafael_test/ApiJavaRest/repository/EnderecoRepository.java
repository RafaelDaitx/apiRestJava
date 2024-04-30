package com.rafael_test.ApiJavaRest.repository;

import com.rafael_test.ApiJavaRest.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long> {

}
