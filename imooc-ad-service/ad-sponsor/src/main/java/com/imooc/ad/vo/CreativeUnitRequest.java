package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreativeUnitRequest {
    private List<CreativeUnitItem> creativeUnitItems;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class CreativeUnitItem {
        private Long creativeId;
        private Long unitId;
    }
}