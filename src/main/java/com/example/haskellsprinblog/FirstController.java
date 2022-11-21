package com.example.haskellsprinblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

    @GetMapping("/test")
    @ResponseBody
    public String more(){
        return "hello from spring";
    }

    @RequestMapping(method = RequestMethod.GET,path= "/bubbles")
@ResponseBody
    public String bubbles(){
        return "blllllllalalllhh";
    }

    @GetMapping("/greeting/{name}")
@ResponseBody
    public String greeting(@PathVariable String name){
        return "greetings "+ name;
    }
}
