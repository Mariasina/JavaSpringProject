package com.trevis.startup.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trevis.startup.example.model.DepartmentModel;


@Repository
public interface DepartmentJPARepository extends JpaRepository<DepartmentModel ,Long> {
    List<DepartmentModel> findByNameContaining(String name); // Containing deve ser implementado com o método contain
}
