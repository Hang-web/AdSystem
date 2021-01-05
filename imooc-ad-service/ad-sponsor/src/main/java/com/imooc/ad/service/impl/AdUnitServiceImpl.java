package com.imooc.ad.service.impl;

import com.imooc.ad.constant.Constants;
import com.imooc.ad.dao.AdPlanRepository;
import com.imooc.ad.dao.AdUnitRepository;
import com.imooc.ad.dao.unit_condition.AdUnitKeywordRepository;
import com.imooc.ad.entity.AdPlan;
import com.imooc.ad.entity.AdUnit;
import com.imooc.ad.entity.unit_condition.AdUnitKeyword;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.service.IAdUnitService;
import com.imooc.ad.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdUnitServiceImpl implements IAdUnitService {

    private final AdPlanRepository adPlanRepository;
    private final AdUnitRepository adUnitRepository;
    private final AdUnitKeywordRepository adUnitKeywordRepository;

    @Autowired
    public AdUnitServiceImpl(AdPlanRepository adPlanRepository, AdUnitRepository adUnitRepository, AdUnitKeywordRepository adUnitKeywordRepository) {
        this.adPlanRepository = adPlanRepository;
        this.adUnitRepository = adUnitRepository;
        this.adUnitKeywordRepository = adUnitKeywordRepository;
    }

    @Override
    public AdUnitResponse createAdUnit(AdUnitRequest request) throws AdException {
        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        Optional<AdPlan> optional = adPlanRepository.findById(request.getPlanId());
        if (!optional.isPresent()){
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        AdUnit oldAdUnit = adUnitRepository.findByIdInAndUnitName(request.getPlanId(), request.getUnitName());
        if (oldAdUnit != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_UNIT_ERROR);
        }
        AdUnit newAdUnit = new AdUnit(request.getPlanId(), request.getUnitName(), request.getPositionType(), request.getBudget());
        return new AdUnitResponse(newAdUnit.getId(),newAdUnit.getUnitName());
    }

    @Override
    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {
        List<Long> unitIds = request.getUnitKeywords().stream().map(AdUnitKeywordRequest.UnitKeyword::getUnitId).collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<Long> ids = Collections.emptyList();
        ArrayList<AdUnitKeyword> unitKeywords = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitKeywords())) {
            request.getUnitKeywords().forEach(i -> unitKeywords.add(
                    new AdUnitKeyword(i.getUnitId(),i.getKeyword())
            ));
            ids = adUnitKeywordRepository.saveAll(unitKeywords).stream().map(AdUnitKeyword::getId).collect(Collectors.toList());
        }
        return new AdUnitKeywordResponse(ids);
    }

    @Override
    public AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException {
        return null;
    }

    @Override
    public AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException {
        return null;
    }

    private boolean isRelatedUnitExist(List<Long> unitIds) {
        if (CollectionUtils.isEmpty(unitIds)) {
            return false;
        }
        return adUnitRepository.findAllById(unitIds).size() == new HashSet<>(unitIds).size();
    }
}
