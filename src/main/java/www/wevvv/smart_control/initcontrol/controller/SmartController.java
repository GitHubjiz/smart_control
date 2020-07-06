package www.wevvv.smart_control.initcontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import www.wevvv.smart_control.initcontrol.mapper.UsersMapper;
import www.wevvv.smart_control.initcontrol.model.Users;
import www.wevvv.smart_control.util.MD5Util;

@Controller
public class SmartController {

    @Autowired
    private Users users;

    @Autowired
    private UsersMapper userMapper;
    @RequestMapping("/login")
    public String login (){
        return "login";
    }

    @RequestMapping("/auth/index")
    public String index (){
        return "index";
    }

    @RequestMapping("/auth/login")
    @ResponseBody
    public String  index( Users  users) {
        if(!users.getUsername().equals("") || !users.getPassword().equals("")) {
            String username = users.getUsername();
            String password = users.getPassword();
            String s = MD5Util.encode2hex(password);
            Users user = userMapper.getUsers(username);
            if (user.getUsername().equals(username) && user.getPassword().equals(s)) {
                return "success";
            }else {
                return "密码输入错误";
            }

        }

        return "操作失败，请输入管理员";
    }




}