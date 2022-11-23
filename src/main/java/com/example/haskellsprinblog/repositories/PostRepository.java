package com.example.haskellsprinblog.repositories;

import com.example.haskellsprinblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}