package com.wenkai.nowcode_community.controller;


import com.wenkai.nowcode_community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.getData();
    }

    @RequestMapping(path="/student", method = RequestMethod.GET)
    public ModelAndView getPerson(
            @RequestParam(name="name",required = true) String name,
            @RequestParam(name="age",required = false,defaultValue = "0") int age){

            ModelAndView mav = new ModelAndView();
            mav.addObject("name", name);
            mav.addObject("age", age);
            mav.addObject("welcome","Welcome Back");
            mav.setViewName("/Demo/student");
            return mav;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public String signUpUser(Model model, String userName, int age){
        model.addAttribute("name", userName);
        model.addAttribute("age",age);
        model.addAttribute("welcome","Congrats! You are signed up");
        return "/Demo/student";
    }


}
