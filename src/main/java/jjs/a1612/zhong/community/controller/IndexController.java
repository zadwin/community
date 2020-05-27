package jjs.a1612.zhong.community.controller;

import jjs.a1612.zhong.community.mapper.UserMapper;
import jjs.a1612.zhong.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 主页的访问申请
 */
//这个语句的功能简单理解就是可以允许这个类接收前端的请求，自动扫描当前的类
@Controller
public class IndexController {
    @Autowired(required = false)
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
//        这里是为了获取访问的cookie值，来记住用户是否登录过。并且判断该用户是否存在与数据库中。
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user !=null){
//                    给浏览器设置访问值
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
