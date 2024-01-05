package com.bobu.testcase.repository;

import com.bobu.testcase.model.Child;
import com.bobu.testcase.model.Parent;
import com.bobu.testcase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent,String> {
    List<Parent> findByInviteCodeIn(List<String> inviteCodeList);

    Optional<Parent> findByEmail(String email);
}
