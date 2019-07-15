package com.example.springbootthymeleaf.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("song")
public class SongController {

    @GetMapping("/ajax")
    public String toAjax(){
        return "/ajaxTest";
    }

    //两种方法,通过response返回信息
    /*@PostMapping("/ajaxTest")
    public void ajaxTest(@RequestBody Song song, HttpServletResponse resp)throws Exception{
        String songName = song.getSongName();
        System.out.println("songName:"+songName+";singer:"+song.getSinger());
        String flagMessage = "success";
        String hintMessage="数据添加成功!!!";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",flagMessage);
        jsonObject.put("hintMessage",hintMessage);
        System.out.println(jsonObject.toJSONString());
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println(jsonObject.toJSONString());
        resp.getWriter().close();
    }*/

    //两种方法,通过@ResponseBody形式返回,感觉更好一些
    @PostMapping("/ajaxTest")
    @ResponseBody
    public Object ajaxTest(@RequestBody Song song){
        String songName = song.getSongName();
        System.out.println("songName:"+songName+";singer:"+song.getSinger());
        String flagMessage = "success";
        String hintMessage="数据添加成功!!!";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag",flagMessage);
        jsonObject.put("hintMessage",hintMessage);
        System.out.println(jsonObject.toJSONString());
        return jsonObject;
    }

    @GetMapping("/add")
    public ModelAndView addSong(){
        ModelAndView modelAndView = new ModelAndView();
        Song song = new Song();
        modelAndView.addObject("song", song);
        modelAndView.addObject("hintMessage", "初始化成功！");
        modelAndView.setViewName("/formTest");
        return modelAndView;
    }


    @PostMapping("/save")
    public ModelAndView insertSong(@Valid Song song, BindingResult result){
        //@Valid注解启动后台校验,
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("歌手名称:"+ song.getSinger());
        if(result.hasErrors()){
            modelAndView.addObject("hintMessage", "出错啦！");
        }else{
            boolean flag=true;
            if(flag){
                modelAndView.addObject("hintMessage", "数据库已有该条记录！");
            }else{
                modelAndView.addObject("hintMessage", "提交成功！");
            }
        }
        modelAndView.setViewName("/formTest");
        return modelAndView;
    }

}
