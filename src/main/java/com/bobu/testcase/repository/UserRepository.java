package com.bobu.testcase.repository;

import com.bobu.testcase.model.Child;
import com.bobu.testcase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByEmail(String email);

}
