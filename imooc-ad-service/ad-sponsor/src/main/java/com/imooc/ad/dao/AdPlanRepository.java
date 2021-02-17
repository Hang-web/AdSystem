package com.imooc.ad.dao;

import com.imooc.ad.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {
    AdPlan findByIdInAndPlanName(Long id, String planName);

    List<AdPlan> findAllByIdInAndUserId(List<Long> ids, Long userId);

    AdPlan findByIdInAndUserId(Long id, Long userId);

    List<AdPlan> findAllByPlanStatus(Integer status);
}
