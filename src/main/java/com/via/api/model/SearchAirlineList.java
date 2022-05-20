package com.via.api.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.via.api.model.enums.RouteType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

public class SearchAirlineList {

    private SearchAirlineList() {
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
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {

        private List<CarrierListData> searchList;

        private SearchQuery searchQuery;

        private Long id;
    }
}
