package com.jianzhonglang.weshow.controller;


import com.jianzhonglang.weshow.common.Result;
import com.jianzhonglang.weshow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/show")
public class ShowController {

    @Autowired private ShowService showService;

    @GetMapping
    public Result getShows() {
        return Result.success(showService.list());
    }

}
