package com.am.socket.controller;
import com.am.socket.model.User;
import com.am.socket.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCtrl {

    @Resource
    private UserService user;

    @PostMapping("/login")
    public boolean userFind(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        return user.findUserIsTrue(username,password);
    }
    //   parameter from front-end: ["mazy","angle"]
    @PostMapping("/checkUser")
    public List<String> moreUserFind(@RequestBody List<String> users) {
        return user.moreUserExist(users);
    }

    @PostMapping("/register")
    public String userRegister(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) throws Exception {
        return user.userRegister(username, password, email);
    }

    @PostMapping("/addFriend")
    public String userAddFriend(@RequestParam("username") String username, @RequestParam("friendName") String friendName) {
        return user.userAddFriend(username, friendName);
    }

    @PostMapping("/findFriend")
    public List<User> userFindFriend(@RequestParam("username") String username) {
        return user.userFindFriend(username);
    }

    @PostMapping("/activate")
    public String userActivate(@RequestParam("email") String email, @RequestParam("activeCode") String activeCode) {
        return user.processActivate(email, activeCode);
    }

}
