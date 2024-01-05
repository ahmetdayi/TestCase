package com.bobu.testcase.repository;

import com.bobu.testcase.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChildRepository extends JpaRepository<Child,String> {
    Optional<Child> findByEmail(String email);
}
