package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * 统一请求处理
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;

    /**
     * 判断前台页面传来的用户名是否为空
     * @return 用户名如为空，则返回false
     */
    public boolean validate() {
        return !StringUtils.isEmpty(username);
    }
}
