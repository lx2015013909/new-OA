package com.example.oa.controller;

import com.example.oa.entity.Notice;
import com.example.oa.service.NoticeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.oa.util.ResultUtil;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("")
    public  String index(Model model){

        List<Notice> noticelist= noticeService.FindAll();
        PageInfo<Notice> notice = new PageInfo<>(noticelist);
        model.addAttribute("notice",notice);
        return  "Notice/index";
    }

    @GetMapping("/{id}/edit")
    public  String edit(@PathVariable(value = "id") Long id,Model model){
        Notice selectByPrimaryKey=noticeService.selectByPrimaryKey(id);
        model.addAttribute("notice",selectByPrimaryKey);
        return "Notice/edit";
    }


    @PostMapping("")
    public String save(@RequestParam(value = "head")String head,@RequestParam(value = "content")String content){
         Notice notice = new Notice();
         notice.setHead(head);
         notice.setContent(content);
         noticeService.insert(notice);
        return "redirect:/notice";
    }

    @PutMapping("/{id}")
    public String update(@RequestParam(value = "head")String head,@RequestParam(value = "content")String content,@PathVariable(value = "id")Integer id){
        Integer update = noticeService.updateById(id,head,content);
        return  "redirect:/notice/" + id + "/edit";
    }

     @DeleteMapping("/{id}")
    public String destory(@PathVariable("id") Integer id){

        noticeService.deleteById(id);
        return "redirect:/notice";
     }
}
