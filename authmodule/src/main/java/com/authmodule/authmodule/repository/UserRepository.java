package com.authmodule.authmodule.repository;

import com.authmodule.authmodule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existByUsername(String username);

    User findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

}
