package jjs.a1612.zhong.community.controller;

import jjs.a1612.zhong.community.dto.AccessTokenDTO;
import jjs.a1612.zhong.community.dto.GithubUser;
import jjs.a1612.zhong.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 为了去获取GitHub的登录授权码
 */
@Controller
public class AuthorizeController {
//    它的功能是把写好的Spring 容器中的实例化的实例加载到当前的上下文。
    @Autowired
    GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("7fd25af5ee12a67262fa");
        accessTokenDTO.setClient_secret("8d20d7bfd5f50c377f8b40ca535e2c02a32f5d5d");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.toString());
        return "index";
    }
}
