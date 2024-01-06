package com.bobu.testcase.repository;

import com.bobu.testcase.model.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscribeRepository extends JpaRepository<Subscribe,String> {

    Optional<Subscribe> findByUser_Id(String userId);
}
