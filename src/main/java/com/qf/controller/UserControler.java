package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/11/27.
 */
@RestController
public class UserControler {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectAll/{size}/{page}")
    private Msg selectAll(@PathVariable("size")Integer size,@PathVariable("page")Integer page){

        return userService.selectAll(size,page);
    }

    @RequestMapping("/deleteOne")
    private String deleteOne(@RequestBody User user){

        return userService.deleteOne(user.getId());
    }
    @RequestMapping("/selectOne/{id}")
    private User selectOne(@PathVariable("id")Integer id){

        return userService.selectOne(id);
    }
    @RequestMapping("/updateOne")
    private User updateOne(@RequestBody User user){
        return userService.updateOne(user);
    }
}
