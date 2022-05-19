package com.via.api.model;

import com.via.api.model.enums.BaggageUnit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaggageInformation {

    private String desc;

    private BaggageUnit unit;

    private Integer qty;
}
