package com.example.haskellsprinblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @RequestMapping(method = RequestMethod.GET,path= "/posts")
    @ResponseBody
    public String posts(){
        return "posts index page";
    }


    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
        @ResponseBody
        public String byId(@PathVariable int id){
            return "view an individual post";
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


