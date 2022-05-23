package com.via.api.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
        @Singular
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

        /**
         * List of onward journeys
         */
        @Valid
        private List<Journey> onwardJourneys;

        /**
         * List of return journeys
         */
        @Valid
        private List<Journey> returnJourneys;

        /**
         * This will come if the search was International return or International
         * multi-city or domestic multi-city more than 2 sectors or GDS discounted
         * search
         */
        @Valid
        private List<Journey> combinedJourneys;

        /**
         * True if its combined journey
         */
        private Boolean hasCombinedJourneys;

        /**
         * True if its a domestic search
         */
        private Boolean isDomestic;
    }
}
