package com.jianzhonglang.weshow.service.impl;

import com.jianzhonglang.weshow.entity.User;
import com.jianzhonglang.weshow.mapper.UserMapper;
import com.jianzhonglang.weshow.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xianqiangliu
 * @since 2020-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
