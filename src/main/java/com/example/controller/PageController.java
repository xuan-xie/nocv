package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class PageController {


    @RequestMapping("/topie")
    public String toPie(){
        return "pie";
    }

    @RequestMapping("/tobar")
    public String toBar(){
        return "bar";
    }

    @RequestMapping("/toline")
    public String toLine(){
        return "line";
    }
}
