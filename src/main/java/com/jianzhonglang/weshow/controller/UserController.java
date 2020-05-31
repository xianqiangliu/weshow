package com.jianzhonglang.weshow.controller;


import com.jianzhonglang.weshow.common.Result;
import com.jianzhonglang.weshow.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xianqiangliu
 * @since 2020-05-30
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping
    public Result save(@Validated @RequestBody User user) {

        return Result.success(user);
    }

}
