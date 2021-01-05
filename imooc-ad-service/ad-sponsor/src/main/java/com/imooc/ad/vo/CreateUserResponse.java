package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 创建用户的统一响应类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {

    private Long id;
    private String username;
    private String token;
    private Date createTime;
    private Date updateTime;

}
