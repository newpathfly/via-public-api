package com.via.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class EnvDta {
    
    private String domesticCountryId;

    private String currentEnv;

    private Boolean isB2CEnv;

    private String currencyCode;

    private String currencySymbol;

    private String countryCode;

    private String countryName;

    private String userRole;

    private String isMobile;

    private String languageSelected;
}
