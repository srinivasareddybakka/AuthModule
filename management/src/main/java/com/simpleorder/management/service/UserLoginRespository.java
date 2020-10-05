package com.simpleorder.management.service;

import com.simpleorder.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRespository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

}
