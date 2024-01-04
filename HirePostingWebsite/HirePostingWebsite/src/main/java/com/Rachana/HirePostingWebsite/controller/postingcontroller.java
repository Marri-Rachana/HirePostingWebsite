package com.Rachana.HirePostingWebsite.controller;


import com.Rachana.HirePostingWebsite.Model.PostingProfile;
import com.Rachana.HirePostingWebsite.Repository.PostingProfileRepo;
import com.Rachana.HirePostingWebsite.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import  java.util.List;

@RestController
public class postingcontroller {

    @Autowired
    PostingProfileRepo repo;

    @Autowired
    SearchRepository searchrepo;

    @ApiIgnore
    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
             response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    List<PostingProfile> findAllProfiles(HttpServletResponse httpServletResponse){

        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    List<PostingProfile> search(@PathVariable String text){
          return searchrepo.findByText(text);
    }

    @PostMapping("/addProfile")
    public PostingProfile saveProfile(@RequestBody PostingProfile postingProfile)
    {
        return repo.save(postingProfile);
    }

}
