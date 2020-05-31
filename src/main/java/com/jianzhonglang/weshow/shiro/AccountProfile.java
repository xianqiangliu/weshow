package com.jianzhonglang.weshow.shiro;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author xianqiangliu
 * @since 2020/5/31
 */
@Data
public class AccountProfile {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String avatar;

    private String email;
}
