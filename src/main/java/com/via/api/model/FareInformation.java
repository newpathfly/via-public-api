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
public class FareInformation {

    @Valid
    private FareData base;

    @Valid
    private FareData tax;

    @Valid
    private FareData total;

    @Valid
    private FareData tcf;
}
