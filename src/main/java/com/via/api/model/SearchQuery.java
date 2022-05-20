package com.via.api.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.via.api.model.enums.ClassType;
import com.via.api.model.enums.RouteType;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchQuery {
    
    private List<SectorInfo> sectorInfos;

    @JsonProperty("class")
    private ClassType classType;

    private PaxCount paxCount;

    private RouteType route;
}
