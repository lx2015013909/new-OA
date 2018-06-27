package com.example.oa.controller;

import com.example.oa.entity.Kaoqin;
import com.example.oa.exception.RecordAlreadyExistsException;
import com.example.oa.service.KaoqinService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kaoqin")
public class KaoqinController {

    @Autowired
    private KaoqinService kaoqinService;

    @GetMapping("/{username}")
    public  String index(@PathVariable(value = "username")String username, Model model){

        List<Kaoqin> kaoqinList= kaoqinService.findAll();
        PageInfo<Kaoqin> kaoqin = new PageInfo<>(kaoqinList);
        model.addAttribute("kaoqin",kaoqin);
        model.addAttribute("username",username);
        return  "kaoqin/index";
    }

    @PostMapping("")
    public  String insert (@RequestParam(value = "username")String username)  {
        System.out.print(username);
        Kaoqin kaoqin=new Kaoqin();
        kaoqin.setUsername(username);
        kaoqinService.insert(kaoqin);
        return "redirect:/kaoqin/"+username;

    }
}
