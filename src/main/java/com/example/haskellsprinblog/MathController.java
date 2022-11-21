package com.example.haskellsprinblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{number1}/{and}/{number2}")
    @ResponseBody
    public String add(@PathVariable int number1,@PathVariable String and,  @PathVariable int number2){
        int sum = number1 + number2;
        String display;
        return display  = String.format("Addition of  %d  %s  %d is %d ",number1,and,number2,sum);

    }


    @GetMapping("/subtract/{num1}/{from}/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1,@PathVariable String from,  @PathVariable int num2) {
        int difference = num1 - num2;

        return String.format( "the difference of %d %s %d is %d ",num1,from,num2,difference );
    }


    @GetMapping("/multiply/{num1}/{and}/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1,@PathVariable String and,  @PathVariable int num2) {
        int multiply = num1 * num2;
        return String.format( "%d %s %d  is %d ",num1,and,num2,multiply );
    }



    @GetMapping("/divide/{num1}/{by}/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1,@PathVariable String by,  @PathVariable int num2) {
        double division = (double) (num1 / num2);
        return  String.format(" %d %s %d  is %.2f ",num1,by,num2,division );
    }



}