package com.hank.masterspringmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Hank on 10/10/2017.
 */

@Controller
public class TweetController {

    @Autowired
    private Twitter twitter;

    @RequestMapping("/hello-world")
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
        return "helloPage";
    }

    @RequestMapping("/result")
    public String helloTwitter(@RequestParam(defaultValue = "masteringSpringMvc4") String search, Model model) {
        SearchResults searchResults = twitter.searchOperations().search(search);
        String text = searchResults.getTweets().get(0).getText();
        model.addAttribute("message", text);
        return "resultPage";
    }

    @RequestMapping("/")
    public String home() {
        return "searchPage";
    }
}
