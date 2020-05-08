package jjs.a1612.zhong.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页的访问申请
 */
//这个语句的功能简单理解就是可以允许这个类接收前端的请求，自动扫描当前的类
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
