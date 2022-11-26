package com.example.haskellsprinblog.controllers;

import com.example.haskellsprinblog.models.Post;
import com.example.haskellsprinblog.models.User;
import com.example.haskellsprinblog.repositories.PostRepository;
import com.example.haskellsprinblog.repositories.UserRepository;
import com.example.haskellsprinblog.services.EmailService;
import com.example.haskellsprinblog.services.PostService;

import com.example.haskellsprinblog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {


    private final EmailService mailService;
    private final UserService userService;
    private final PostService postService;

    public PostController(EmailService mailService, PostService postService, UserService userService){



        this.mailService = mailService;
        this.postService = postService;
        this.userService = userService;
    }




    @RequestMapping(method = RequestMethod.GET, path = "/posts")
    public String posts(Model model) {
        List<Post> post = postService.allPost();

        model.addAttribute("posts", post);

        return "posts/index";
    }


    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)

    public String byId(@PathVariable long id, Model model) {
       Post post = postService.findById(id);

        model.addAttribute("post", post);
        System.out.println(post);
        return "posts/show";
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)

    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)


    public String createPosts(@ModelAttribute Post post) {


       User user = userService.findById(1L);
        post.setOwner(user);
String subject = "new post";
                String body = "hey "+user.getUsername()+"your post has been successfully saved";
        postService.savePost(post);
        mailService.prepareAndSend(post,subject,body);
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.referencedById(id));
        return "posts/editPost";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        System.out.println(post.getId());
        User user = userService.findById(1L);
        post.setOwner(user);
//        post.setId(id);
       postService.savePost(post);
        return "redirect:/posts";

    }


}


