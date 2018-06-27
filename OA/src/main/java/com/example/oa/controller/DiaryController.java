package com.example.oa.controller;

import com.example.oa.entity.Diary;
import com.example.oa.service.DiaryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping("")
    public  String index(Model model){

        List<Diary> diaryList= diaryService.findAll();
        PageInfo<Diary> diary = new PageInfo<>(diaryList);
        model.addAttribute("diary",diary);
        return  "Diary/index";
    }

    @GetMapping("/{id}/edit")
    public  String edit(@PathVariable(value = "id") Long id, Model model){
        Diary selectByPrimaryKey=diaryService.selectByPrimaryKey(id);
        model.addAttribute("diary",selectByPrimaryKey);
        return "Diary/edit";
    }

    @PostMapping("")
    public String save(@RequestParam(value = "head")String head,@RequestParam(value = "content")String content){
        Diary notice = new Diary();
        notice.setHead(head);
        notice.setContent(content);
        diaryService.insert(notice);
        return "redirect:/diary";
    }
    @PutMapping("/{id}")
    public String update(@RequestParam(value = "head")String head, @RequestParam(value = "content")String content, @PathVariable(value = "id")Integer id){
        Integer update = diaryService.updateById(id,head,content);
        return  "redirect:/diary/" + id + "/edit";
    }

    @DeleteMapping("/{id}")
    public String destory(@PathVariable("id") Integer id){

        diaryService.deleteById(id);
        return "redirect:/diary";
    }
}
