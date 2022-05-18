package com.via.api.model;

import javax.validation.constraints.Size;

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
public class Place {
    
    @Size(min = 3, max = 3)
    private String code;

    private String name;

    private String city;

    private String country;
}
