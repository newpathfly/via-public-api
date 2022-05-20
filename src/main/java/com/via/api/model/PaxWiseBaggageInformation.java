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
public class PaxWiseBaggageInformation {

    @Valid
    private BaggageInformation adt;

    @Valid
    private BaggageInformation chd;

    @Valid
    private BaggageInformation inf;
}
