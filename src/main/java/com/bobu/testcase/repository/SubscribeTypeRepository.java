package com.bobu.testcase.repository;

import com.bobu.testcase.model.Child;
import com.bobu.testcase.model.SubscribeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscribeTypeRepository extends JpaRepository<SubscribeType,String> {

    Optional<SubscribeType> findByNameIgnoreCase(String name);
}
