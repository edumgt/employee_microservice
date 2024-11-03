package com.devfleming.employees.domain.dto;

import lombok.*;

/**
 * Response class responsible to return information about a success request.
 * @author Rafael Fleming
 */
@Getter @Setter @ToString
@Builder
public class ResponseDto {

    public ResponseDto(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    private String statusCode;

    private String statusMessage;
}
