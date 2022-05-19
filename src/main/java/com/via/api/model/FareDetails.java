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
public class FareDetails {

    @Valid
    private PaxWiseFareInformation paxFares;

    @Valid
    private FareInformation totalFare;
}
