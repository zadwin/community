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
public class HelloController {
    @Autowired(required=false)
    private UserMapper userMapper;
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name")String name, Model model){
        User user = new User();
        user.setToken("2020");
        user.setName("adwin");
        user.setAccountId(String.valueOf("20160203158"));
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        userMapper.insert(user);
        User user1 = new User();
        ArrayList<User> userList = new ArrayList<>();
        user1 = userMapper.findById(1);
        userList = userMapper.findAll("adwin");
        System.out.println("用户："+user1.toString());
        for(User user2:userList){
            System.out.println("用户集合："+user2.toString());
        }
        if(user1 != null){
//            相当于给网页注入参数
            model.addAttribute("name",user1.getName());
        }else{
            model.addAttribute("name",name);
        }
        return "hello";
    }
}
