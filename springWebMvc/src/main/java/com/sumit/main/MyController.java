package com.sumit.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping("/helloPage")
    public ModelAndView openHelloPage() {
        System.out.println("OpenHelloPage() is executed !!");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }
}
