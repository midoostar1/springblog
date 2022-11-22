package com.example.haskellsprinblog;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

@Controller
public class PostController {

    @RequestMapping(method = RequestMethod.GET,path= "/posts")
    public String posts(Model model){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post("iphone","Brand new a a cheap price"));
        post.add(new Post("55inch Sansung Tv","Brand new a a cheap price"));

        model.addAttribute("posts",post);

        return "posts/index";
    }


    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)

        public String byId(@PathVariable int id, Model model){
         Post post = new Post(id,"first post","first time studying spring");

model.addAttribute("post", post);
        return "posts/show";
        }



    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String create(){
        return "view the form for creating a post";
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPosts(){
        return "view the form for creating a post";
    }


}


