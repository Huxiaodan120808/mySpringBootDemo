package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class TestControl {
//   @Autowired
//    UserService userService;

    @GetMapping("/")
    public ModelAndView hello(){
//        userService.te
        return new ModelAndView("index");
    }
}
