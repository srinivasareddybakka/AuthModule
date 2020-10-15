package com.simpleorder.management.service;

import com.simpleorder.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLoginRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    List<User> findByIdIn(Long[] userList);

}
