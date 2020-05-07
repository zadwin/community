package jjs.a1612.zhong.community.controller;

import jjs.a1612.zhong.community.UserMapper.UserMapper;
import jjs.a1612.zhong.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

//这个语句的功能简单理解就是可以允许这个类接收前端的请求，自动扫描当前的类
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
