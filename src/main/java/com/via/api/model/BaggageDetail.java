package com.via.api.model;

import javax.validation.Valid;

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
public class BaggageDetail {

    @Valid
    private PaxWiseBaggageInformation checkin;

    @Valid
    private PaxWiseBaggageInformation cabin;
}
