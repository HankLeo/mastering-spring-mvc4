package com.hank.masterspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Hank on 10/10/2017.
 */

@Controller
public class TweetController {

    @RequestMapping("/")
    /**
     * value in @RequestParam means the param name in URL, such as http://localhost:8080/?name=Hank
     * defaultValue means if there isn't the param in URL, this variable is this value
     */
    public String hello(@RequestParam(value = "name", defaultValue = "world") String username, Model model) {
        /**
         * Controller return View Name to Dispatcher Servlet
         * Then Dispatch will search from ViewResolver Interface
         */
        model.addAttribute("message", "Hello from the Controller");
        model.addAttribute("messageWithParam", "Hello, " + username);
        return "resultPage";
    }
}
