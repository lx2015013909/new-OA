package com.example.oa.controller;

import com.example.oa.entity.Kaoqin;
import com.example.oa.entity.User;
import com.example.oa.exception.RecordAlreadyExistsException;
import com.example.oa.service.KaoqinService;
import com.example.oa.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping ("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private KaoqinService kaoqinService;

    @GetMapping("")
    public String login(){
        return "login";
    }

    @GetMapping("/select")
    public String select(Model model){
        List<User> userList=userService.findAll();
        PageInfo<User> user = new PageInfo<>(userList);
        model.addAttribute("user",user);
        return "info";
    }

    @PostMapping("")
    public String login(@RequestParam(value = "login-username")String username,
                        @RequestParam(value = "login-password")String password, Model model) throws Exception {
        User user=new User();
        user = userService.selectByAll(username, password);
        model.addAttribute("user",user);
        Kaoqin kaoqin=new Kaoqin();
        kaoqin.setUsername(username);
        kaoqinService.insert(kaoqin);
        return "index";
    }

    @PostMapping("/register")
    public String save(@RequestParam(value = "register-username")String username,
                       @RequestParam(value = "register-password")String password) throws RecordAlreadyExistsException {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.insert(user);
        return "redirect:/";
    }
    @PostMapping("/forget")
    public String update(@RequestParam(value = "forget-username")String username,
                         @RequestParam(value = "forget-password")String password) throws RecordAlreadyExistsException {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
          userService.update(user);
        return "redirect:/";
    }



}
