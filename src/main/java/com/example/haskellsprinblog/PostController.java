package com.example.haskellsprinblog;

import com.example.haskellsprinblog.models.Post;
import com.example.haskellsprinblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    @RequestMapping(method = RequestMethod.GET,path= "/posts")
    public String posts(Model model){
       List<Post> post = postDao.findAll();

        model.addAttribute("posts",post);

        return "posts/index";
    }


    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)

        public String byId(@PathVariable Long id, Model model){
         Post post = postDao.getById(id);

model.addAttribute("post", post);
        return "posts/show";
        }



    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)

    public String create(){
        return "posts/create";
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)



    public String createPosts(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, Model model){
      Post post = new Post(title,body);
       postDao.save(post);
        return "redirect:/posts";
    }


}


