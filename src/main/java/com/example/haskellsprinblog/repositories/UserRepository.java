package com.example.haskellsprinblog.repositories;

import com.example.haskellsprinblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}