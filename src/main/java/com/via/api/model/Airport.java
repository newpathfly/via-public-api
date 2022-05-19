package com.via.api.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Airport {

    @Size(min = 3, max = 3)
    private String code;

    private String name;

    private String city;

    private String country;

    @JsonFormat(pattern = "uuuu-MM-dd HH:mm:ss.SSS")
    private LocalDateTime time;

    private String terminal;
}
