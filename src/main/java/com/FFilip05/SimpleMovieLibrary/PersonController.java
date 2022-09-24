package com.FFilip05.SimpleMovieLibrary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class PersonController {
    @GetMapping
    String getPeople(Model model){
                model.addAttribute("people", Arrays.asList(
                        new Movie(1,120,5,"StarWars")
                ));

        return "people";
    }
}
