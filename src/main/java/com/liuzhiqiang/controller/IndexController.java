package com.liuzhiqiang.controller;

import com.liuzhiqiang.dao.UserMapper;
import com.liuzhiqiang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJJ on 2017/9/7.
 */
@RestController
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/index/{id}")
    @CrossOrigin //跨域返回json注解
    public Map<String, Object> view(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userMapper.selectByPrimaryKey(new Long("1"));
        map.put("user", user);
        map.put("user2", user);
        return map;
    }

    //mybaits测试
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getindex(Integer id, ModelMap modelMap) {
        User user = userMapper.selectByPrimaryKey(new Long("1"));
        modelMap.put("name", "liuzhiqiang");
        modelMap.put("user", user);
        return new ModelAndView("index", modelMap);
    }
}
