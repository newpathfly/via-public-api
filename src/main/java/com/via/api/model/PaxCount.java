package com.via.api.model;

import javax.validation.constraints.Min;

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
public class PaxCount {

    @Min(1)
    private Integer adt;
    
    @Min(0)
    private Integer chd;
    
    @Min(0)
    private Integer inf;
}
