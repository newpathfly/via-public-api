package com.via.api.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PaxType {
    @JsonProperty("adt")
    ADT,
    @JsonProperty("chd")
    CHD,
    @JsonProperty("inf")
    INF
}
