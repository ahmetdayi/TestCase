package com.bobu.testcase.repository;

import com.bobu.testcase.model.Child;
import com.bobu.testcase.model.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Subscribe,String> {
}
