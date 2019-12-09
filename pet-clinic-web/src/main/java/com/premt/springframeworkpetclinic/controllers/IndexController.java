package com.premt.springframeworkpetclinic.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

//    @RequestMapping({"" , "/" , "index" , "index.html"})
    public String getIndex(){

        return "index";
    }
}
