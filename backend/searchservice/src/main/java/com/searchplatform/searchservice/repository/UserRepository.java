package com.searchplatform.searchservice.repository;

import com.searchplatform.searchservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,String> {

    boolean existsByEmail(String email);

    User findByUserName(String usernameOrEmail);

    User findByEmail(String usernameOrEmail);
}
