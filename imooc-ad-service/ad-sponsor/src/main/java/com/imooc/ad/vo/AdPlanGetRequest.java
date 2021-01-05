package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanGetRequest {
    private Long userId;
    private List<Long> ids;

    /**
     * 判断用户的id 或者 id列表为空
     * @return 为空返回false
     */
    public boolean validate() {
        return userId != null && !CollectionUtils.isEmpty(ids);
    }
}
