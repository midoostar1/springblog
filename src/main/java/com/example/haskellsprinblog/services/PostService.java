package com.example.haskellsprinblog.services;

import com.example.haskellsprinblog.models.Post;
import com.example.haskellsprinblog.repositories.PostRepository;
import com.example.haskellsprinblog.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service")
public class PostService {
    private final PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;


    }

  public List<Post> allPost(){
      return postDao.findAll();
    }

    public Post findById(long id){
        Optional<Post> post = postDao.findById(id);
        return post.orElse(null);

    }

    public void savePost(Post post){
        postDao.save(post);
    }


    public Post referencedById(long id){
        return postDao.getReferenceById(id);

    }
}
