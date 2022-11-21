package com.example.haskellsprinblog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class rollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "/roll-dice";
    }


    @GetMapping("/roll-dice/{num}")
    public String diceResult(@PathVariable int num,  Model model) {
        int random = (int) Math.floor(Math.random()*(6-1+1)+1);
model.addAttribute("random",random);
model.addAttribute("num",num);

        return "/roll-dice";
    }

}



