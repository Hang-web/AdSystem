package com.imooc.ad.dao;

import com.imooc.ad.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdUnitRepository extends JpaRepository<AdUnit, Long> {
    AdUnit findByIdInAndUnitName(Long id, String unitName);

    List<AdUnit> findAllByUnitStatus(Integer status);
}
