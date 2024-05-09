package com.myapp.bookservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class SwaggerController {

    @GetMapping("/")
    @ResponseBody
    public RedirectView redirectToSwagger() {
        return new RedirectView("/swagger-ui.html");
    }

}
