package com.via.api.model;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Journey {

    /**
     * List of flights in the journey
     */
    @Valid
    @Singular
    private List<FlightData> flights;

    /**
     * Fare details for this journey
     */
    @Valid
    private FareDetails fares;

    /**
     * The minimum seat left in any of the flights. Might not come always
     */
    private Integer seatsLeft;

    /**
     * Unique key for the given journey
     */
    private String key;

    /**
     * True if blocking is allowed in this flight. Can be ignored.
     */
    private Boolean allowBlocking;

    /**
     * List of Journey Information
     */
    @Valid
    private List<JourneyInfo> journeyInfo;
}
