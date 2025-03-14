package org.edu.miu.cs.cs425.citylibrarywebappsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("")
    public String displayHomePage() {
        return "public/index";
    }
}
