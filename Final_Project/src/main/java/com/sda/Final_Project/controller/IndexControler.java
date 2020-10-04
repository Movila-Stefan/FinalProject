package com.sda.Final_Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexControler {
@RequestMapping("employee")

    String Index(){
    return "home";
}

}
