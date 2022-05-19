package com.via.api.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EquipmentType {

    @JsonProperty("bus")
    BUS,

    @JsonProperty("train")
    TRAIN,

    @JsonProperty("yacht")
    YACHT,
}
