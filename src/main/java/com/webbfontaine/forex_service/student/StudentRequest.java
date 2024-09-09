package com.webbfontaine.forex_service.student;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentRequest {

    private String name;
    private Integer age;
    
}
