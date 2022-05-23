package com.via.api.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BaggageUnit {
    @JsonProperty("kg")
    KG,

    @JsonProperty("pc")
    PC
}
