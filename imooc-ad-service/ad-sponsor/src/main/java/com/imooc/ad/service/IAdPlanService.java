package com.imooc.ad.service;

import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.AdPlanGetRequest;
import com.imooc.ad.vo.AdPlanRequest;
import com.imooc.ad.vo.AdPlanResponse;

import java.util.List;

public interface IAdPlanService {

    /**
     * 创建计划
     * @param request 广告计划的统一请求对象
     * @return 返回广告计划的统一响应对象
     * @throws AdException 统一处理异常
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 获得计划id列表
     * @param request 广告计划获得 统一请求对象
     * @return 返回广告计划列表
     * @throws AdException 查询无计划id，抛出ids无法找到异常
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新计划
     * @param request 广告计划的统一请求对象
     * @return 返回广告计划的统一响应对象
     * @throws AdException 当参数中的值不存在时抛出异常
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除计划
     * @param request 广告计划的统一请求对象
     * @throws AdException 当找不到广告计划的id时，抛出异常
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
