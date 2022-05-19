package com.via.api.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.via.api.model.enums.ClassType;
import com.via.api.model.enums.RouteType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

public class Search {

    private Search() {
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        @Valid
        @NotEmpty
        @Singular
        private List<SectorInfo> sectorInfos;

        @Valid
        @NotNull
        private PaxCount paxCount;

        @NotNull
        private RouteType route;

        @Valid
        @NotNull
        @JsonProperty("class")
        private ClassType classType;

        @Valid
        private List<Carrier> prefAirlines;

        private Boolean multiCity;
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {

        @Valid
        private Journey onwardJourneys;

        @Valid
        private Journey returnJourneys;

        @Valid
        private Journey combinedJourneys;

        private Boolean hasCombinedJourneys;

        private Boolean isDomestic;
    }
}
