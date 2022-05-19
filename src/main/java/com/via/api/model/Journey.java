package com.via.api.model;

import java.util.List;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Journey {

    @Valid
    @Singular
    private List<FlightData> flights;

    @Valid
    private FareDetails fares;

    private Integer seatsLeft;

    private String key;

    private Boolean allowBlocking;

    @Valid
    private JourneyInfo journeyInfo;
}
