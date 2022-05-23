package com.via.api.model;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightData {

    /**
     * Unique number for the flight in the flight list
     */
    private Integer key;

    /**
     * Description for the carrier involved in the flight
     */
    @Valid
    private Carrier carrier;

    /**
     * Description for the carrier involved in the flight
     */
    @Valid
    private Carrier operatingCarrier;

    /**
     * Departure detail
     */
    @Valid
    private Airport depDetail;

    /**
     * Arrival detail
     */
    @Valid
    private Airport arrDetail;

    /**
     * Flight number
     */
    private String flightNo;

    /**
     * Details of the class and fare basis for all passenger types involved in the
     * flight search
     */
    @Valid
    private Map<PaxType, ClassDetail> classDetail;

    /**
     * Gives the detail about the Aircraft Type
     */
    private String aircraftType;

    /**
     * No of stops including stop-over flights
     */
    private Integer stops;

    /**
     * Details of the stopover flights. Connecting flights will always come as
     * separate FlightData, so stopDetail will only contain detail of the flights
     * that has stopover i.e. flight number does not change in-between the journey
     */
    @Valid
    private List<Airport> stopDetail;

    /**
     * Flying time of the flight
     */
    private Long flyTime;

    /**
     * Layover time of the flight
     */
    private Long layover;

    /**
     * True if it is part of return journey
     */
    private Boolean isReturn;

    /**
     * Amenities given in the flight. This information might not be accurate
     * sometimes. We try our level best to keep it updated
     */
    @Valid
    private Amenities amenities;

    /**
     * Type of the equipment
     */
    private EquipmentType equipmentType;

    /**
     * Information whether the given flight would be arriving next day or not
     */
    private Boolean nextDayArr;

    /**
     * If it's a only hand baggage flight
     */
    private Boolean onlyHandbag;
}
