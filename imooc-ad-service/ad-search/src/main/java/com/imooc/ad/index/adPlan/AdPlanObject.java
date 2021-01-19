package com.imooc.ad.index.adPlan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanObject {
    private Long planId;
    private Long userId;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;

    public void update(AdPlanObject newObject) {
        if (null != newObject.getPlanId()) {
            this.planId = newObject.getPlanId();
        }
        if (null != newObject.getUserId()) {
            this.userId = newObject.getUserId();
        }
        if (null != newObject.getPlanId()) {
            this.planStatus = newObject.getPlanStatus();
        }
        if (null != newObject.getPlanId()) {
            this.startDate = newObject.getStartDate();
        }
        if (null != newObject.getPlanId()) {
            this.endDate = newObject.getEndDate();
        }
    }
}
