package com.devfleming.employees.domain.dto;

import lombok.*;

@Getter @Setter @ToString
@Builder
@AllArgsConstructor
public class ResponseDto {

    private String statusCode;

    private String statusMessage;
}
