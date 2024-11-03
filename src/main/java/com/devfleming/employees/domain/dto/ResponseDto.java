package com.devfleming.employees.domain.dto;

import lombok.*;

/**
 * Response class responsible to return information about a success request.
 *
 * @author Rafael Fleming
 */
@Getter @Setter @ToString
@Builder
@AllArgsConstructor
public class ResponseDto {

    private String statusCode;

    private String statusMessage;
}
