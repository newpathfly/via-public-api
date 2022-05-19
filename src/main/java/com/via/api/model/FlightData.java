package com.via.api.model;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.via.api.model.enums.EquipmentType;
import com.via.api.model.enums.PaxType;

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
public class FlightData {

    private Integer key;

    @Valid
    private Carrier carrier;

    @Valid
    private Carrier operatingCarrier;

    @Valid
    private Airport depDetail;

    @Valid
    private Airport arrDetail;

    private String flightNo;

    @Valid
    private Map<PaxType, ClassDetail> classDetail;

    private String aircraftType;

    private Integer stops;

    @Valid
    private List<Airport> stopDetail;

    private Long flyTime;

    private Long layover;

    private Boolean isReturn;

    @Valid
    private Amenities amenities;

    private EquipmentType equipmentType;

    private Boolean nextDayArr;

    private Boolean onlyHandbag;
}
