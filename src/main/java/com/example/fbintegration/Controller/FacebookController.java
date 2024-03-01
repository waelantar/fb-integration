package com.example.fbintegration.Controller;

import com.example.fbintegration.test;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class FacebookController {

    private Facebook facebook;



    private ConnectionRepository connectionRepository;



    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;

        this.connectionRepository = connectionRepository;
    }



    @GetMapping
    public String getfacebookFeeds(Model model) {
//https://github.com/asilvino/facebook-collector
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

        List<Post> posts = facebook.feedOperations().getFeed();


        model.addAttribute("posts", posts);
        return "profile";
    }
    @GetMapping("/comments/{objectId}")
    public String getfacebookComments(@PathVariable String objectId,Model model) {

        System.out.println(objectId);
        PagedList<Comment> comments=facebook.commentOperations().getComments(objectId);

        model.addAttribute("comments", comments);
        return "profile2" ;

    }

}